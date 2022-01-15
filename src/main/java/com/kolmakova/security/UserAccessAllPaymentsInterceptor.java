package com.kolmakova.security;

import com.kolmakova.entities.Account;
import com.kolmakova.security.utils.HttpRequestUtils;
import com.kolmakova.services.PassengerService;
import com.kolmakova.services.impl.AccountServiceImpl;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.Map;

import static com.kolmakova.security.utils.HttpRequestUtils.ACCESS_DENIED_MESSAGE;

@Component("userAccessAllPaymentsInterceptor")
public class UserAccessAllPaymentsInterceptor implements HandlerInterceptor {

    private static final String PASSENGER_ID_PATH_VARIABLE = "passengerId";

    @Autowired
    private PassengerService passengerService;
    @Autowired
    private HttpRequestUtils httpRequestUtils;

    @Override
    @Transactional
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Account account = httpRequestUtils.getFromRequest(request);
        Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        if (!pathVariables.containsKey(PASSENGER_ID_PATH_VARIABLE) || !NumberUtils.isParsable(pathVariables.get(PASSENGER_ID_PATH_VARIABLE))) {
            return true;
        }

        Integer passengerId = Integer.parseInt(pathVariables.get(PASSENGER_ID_PATH_VARIABLE));
        boolean hasAccess = passengerService.containsPassenger(account.getPassengers(), passengerId);

        if (!hasAccess) {
            throw new AccessDeniedException(ACCESS_DENIED_MESSAGE);
            //need to be logged with .error
        }

        return true;
    }
}
