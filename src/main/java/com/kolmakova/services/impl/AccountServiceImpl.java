package com.kolmakova.services.impl;

import com.kolmakova.entities.Account;
import com.kolmakova.repositories.UserRepository;
import com.kolmakova.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Optional<Account> getOne(String username) {
        LOGGER.info("User with username {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public Account save(Account account) {
        String encryptedPassword = encoder.encode(account.getPassword());
        account.setPassword(encryptedPassword);

        LOGGER.debug("User with name {} was saved", account.getUsername());
        return userRepository.save(account);
    }
}
