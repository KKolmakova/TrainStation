package com.kolmakova.services.impl;

import com.kolmakova.entities.Account;
import com.kolmakova.repositories.UserRepository;
import com.kolmakova.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<Account> getOne(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Account save(Account account) {
        return userRepository.save(account);
    }
}
