package com.kolmakova.security.utils;

import com.kolmakova.entities.Account;
import com.kolmakova.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;

@Component
public class HttpRequestUtils {
    public static final String ACCESS_DENIED_MESSAGE = "403 FORBIDDEN";

    @Autowired
    private AccountService accountService;

    private static final String ILLEGAL_STATE_MESSAGE = "Can't find principal user for request %s";
    private static final String USER_NOT_FOUND_MESSAGE = "User %s NOT FOUND";

    public Account getFromRequest(HttpServletRequest request) {
        validatePrincipalExists(request);
        User principal = (User) ((UsernamePasswordAuthenticationToken) request.getUserPrincipal()).getPrincipal();
        Optional<Account> accountOptional = accountService.getOne(principal.getUsername());

        if (!accountOptional.isPresent()) {
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, principal.getUsername()));
        }

        return accountOptional.get();
    }

    private void validatePrincipalExists(HttpServletRequest request) {
        if (!principalExists(request)) {
            throw new IllegalStateException(String.format(ILLEGAL_STATE_MESSAGE, request));
        }
    }

    private boolean principalExists(HttpServletRequest request) {
        return Objects.isNull(request) ||
                Objects.isNull(request.getUserPrincipal()) ||
                !(request.getUserPrincipal() instanceof User);
    }
}
