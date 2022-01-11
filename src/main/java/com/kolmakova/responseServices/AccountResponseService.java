package com.kolmakova.responseServices;

import com.kolmakova.dto.AccountDto;
import com.kolmakova.responses.AccountResponse;

public interface AccountResponseService {
    AccountResponse registerNewUser(AccountDto accountDto);
}
