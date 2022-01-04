//package com.kolmakova.services.impl;
//
//import com.kolmakova.entities.Account;
//import com.kolmakova.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class CustomUserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository usersRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Account> accountOptional = usersRepository.findByUsername(username);
//        if (accountOptional.isPresent()) {
//            //return accountOptional.get();
//        } else {
//            throw new UsernameNotFoundException(String.format("User with name %s not found", username));
//        }
//    }
//}
