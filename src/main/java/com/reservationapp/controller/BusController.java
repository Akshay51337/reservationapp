package com.reservationapp.controller;

import com.reservationapp.Entity.Bus;
import com.reservationapp.payload.BusDto;
import com.reservationapp.payload.SearchListOfBusesDto;
import com.reservationapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping
    public ResponseEntity<String> addBus(@RequestBody BusDto busDto) throws ParseException {

       busService.addBus(busDto);
        return new ResponseEntity<>("Data saved",HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getAllBuses(@RequestParam String fromLocation,
                                                                        @RequestParam String toLocation,
                                                                        @RequestParam String fromDate){
        ResponseEntity<?> allBuses = busService.getAllBuses(fromLocation, toLocation, fromDate);
        return new ResponseEntity<>(allBuses,HttpStatus.OK);
    }

}

