package com.kolmakova.responseServices;

import com.kolmakova.dto.AccountDTO;
import com.kolmakova.responses.AccountExistsResponse;

public interface AccountResponseService {
    AccountExistsResponse registerNewUser(AccountDTO accountDto);
}
