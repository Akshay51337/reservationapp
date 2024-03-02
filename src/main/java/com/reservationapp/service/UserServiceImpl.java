package com.reservationapp.service;

import com.reservationapp.Entity.UserRegistration;
import com.reservationapp.payload.UserRegistrationDto;
import com.reservationapp.repository.UserRegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMapExtensionsKt;

import java.util.Optional;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRegistrationRepository urr;
    public UserRegistration createUser(UserRegistration userRegistration){
        UserRegistration user = urr.save(userRegistration);

        return user;
    }

    public UserRegistration getUserbyId(long id) {
        UserRegistration userRegistration = urr.findById(id).get();
        return userRegistration;
    }
}
