package com.kolmakova.services.impl;

import com.kolmakova.entities.Account;
import com.kolmakova.repositories.UserRepository;
import com.kolmakova.services.AccountService;
import com.kolmakova.services.PassengerService;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOG = Logger.getLogger(PassengerService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Optional<Account> getOne(String username) {
        LOG.info(String.format("Get user with username %s", username));
        return userRepository.findByUsername(username);
    }

    @Override
    public Account save(Account account) {
        String encryptedPassword = encoder.encode(account.getPassword());
        account.setPassword(encryptedPassword);

        LOG.debug(String.format("Save user with name %s", account.getUsername()));
        return userRepository.save(account);
    }
}
