package com.kolmakova.responses;

public class AccountExistsResponse {

    private boolean userAlreadyExists;

    public AccountExistsResponse(boolean userAlreadyExists) {
        this.userAlreadyExists = userAlreadyExists;
    }

    public boolean isUserAlreadyExists() {
        return userAlreadyExists;
    }

    public void setUserAlreadyExists(boolean userAlreadyExists) {
        this.userAlreadyExists = userAlreadyExists;
    }

}
