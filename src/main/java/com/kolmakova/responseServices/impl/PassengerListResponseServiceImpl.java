package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.entities.Account;
import com.kolmakova.entities.Passenger;
import com.kolmakova.responseServices.PassengerListResponseService;
import com.kolmakova.responses.PassengerListResponse;
import com.kolmakova.services.AccountService;
import com.kolmakova.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PassengerListResponseServiceImpl implements PassengerListResponseService {

    @Autowired
    private AccountService accountService;
    @Autowired
    private Converter converter;

    @Override
    public PassengerListResponse getResponse() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        PassengerListResponse passengerListResponse = new PassengerListResponse();
        Optional<Account> accountOptional = accountService.getOne(username);

        if (accountOptional.isPresent()) {
            List<Passenger> passengerList = accountOptional.get().getPassengers();
            List<PassengerDTO> passengerDTOList = converter.convertToPassengerDTOList(passengerList);

            passengerListResponse.setPassengerDTOList(passengerDTOList);

            return passengerListResponse;
        }

        passengerListResponse.setPassengerDTOList(new ArrayList<>());

        return passengerListResponse;
    }
}
