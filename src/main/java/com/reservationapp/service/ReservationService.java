package com.reservationapp.service;

import com.itextpdf.text.DocumentException;
import com.reservationapp.Entity.Bus;
import com.reservationapp.Entity.Passenger;
import com.reservationapp.Entity.Route;
import com.reservationapp.Entity.SubRoute;
import com.reservationapp.payload.ReservationDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.PassengerRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.SubRouteRepository;
import com.reservationapp.util.EmailService;
import com.reservationapp.util.PdfTicketGeneratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private BusRepository busRepository;
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private PdfTicketGeneratorServiceImpl pdfTicketGeneratorService;

    @Autowired
    private SubRouteRepository subRouteRepository;
    @Autowired
    EmailService emailService;

    public ResponseEntity<?> bookTicket(long busId, long routeId, Passenger pasenger) {
        boolean busIsPresent = false;
        boolean routeIsPresent = false;
        boolean subRouteIsPresent = false;
        Optional<Bus> byId = busRepository.findById(busId);
        if (byId.isPresent()) {
            busIsPresent = true;
            Bus bus = byId.get();
        }
        Optional<Route> byRouteId = routeRepository.findById(routeId);
        if (byRouteId.isPresent()) {
            routeIsPresent = true;
            Bus bus = byId.get();
        }
        Optional<SubRoute> bySubRouteId = subRouteRepository.findById(routeId);
        if (byRouteId.isPresent()) {
            subRouteIsPresent = true;
            Bus bus = byId.get();
        }
        if (busIsPresent && routeIsPresent || busIsPresent && subRouteIsPresent) {
    Passenger p = new Passenger();
    p.setFirstName(pasenger.getFirstName());
    p.setLastName(pasenger.getLastName());
    p.setEmail(pasenger.getEmail());
    p.setMobile(pasenger.getMobile());
    p.setBusId(busId);
    p.setRouteId(routeId);
    Passenger savedPaasenger = passengerRepository.save(p);
            byte[] pdfBytes = new byte[0];
            try {
                pdfBytes = pdfTicketGeneratorService.generateTicket(savedPaasenger, byRouteId.get().getFromLocation(), byRouteId.get().getToLocation(), byRouteId.get().getFromDate(), byRouteId.get().getToDate());
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            }
            emailService.sendTicketEmail(pasenger.getEmail(),"Booking Confirm", pdfBytes,"TicketInfo","Your reservation id "+savedPaasenger.getPassengerId());
        }
        return new ResponseEntity<>("Ticket Booked SuccessFully", HttpStatus.CREATED);
    }
}