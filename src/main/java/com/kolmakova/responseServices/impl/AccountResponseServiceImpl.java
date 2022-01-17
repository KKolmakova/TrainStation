package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.AccountDTO;
import com.kolmakova.entities.Account;
import com.kolmakova.responseServices.AccountResponseService;
import com.kolmakova.responses.AccountExistsResponse;
import com.kolmakova.services.AccountService;
import com.kolmakova.services.PassengerService;
import com.kolmakova.util.Converter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountResponseServiceImpl implements AccountResponseService {

    private static final Logger LOG = Logger.getLogger(AccountResponseService.class);

    @Autowired
    private AccountService accountService;
    @Autowired
    private Converter converter;

    @Override
    public AccountExistsResponse registerNewUser(AccountDTO accountDTO) {
        AccountExistsResponse response = new AccountExistsResponse(true);
        Account accountToSave = converter.convertToAccount(accountDTO);

        if (userNotExists(accountToSave)) {
            LOG.info(String.format("Create new account with username %s", accountToSave.getUsername()));

            accountService.save(accountToSave);
            response.setUserAlreadyExists(false);
        }

        return response;
    }

    private boolean userNotExists(Account accountToSave) {
        return !accountService.getOne(accountToSave.getUsername()).isPresent();
    }
}
