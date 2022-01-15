package com.kolmakova.serviceImpl;

import com.kolmakova.entities.Account;
import com.kolmakova.repositories.UserRepository;
import com.kolmakova.services.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AccountServiceImpl accountServiceImpl;

    @Test
    public void saveAccount(){
        //GIVEN
        Account account = new Account();
        account.setUsername("bob");
        account.setPassword("tolikov");

        //WHEN
        when(userRepository.save(account)).thenReturn(account);
        Account savedAccount = accountServiceImpl.save(account);

        //THEN
        account.getUsername().equals(savedAccount.getUsername());
    }
}
