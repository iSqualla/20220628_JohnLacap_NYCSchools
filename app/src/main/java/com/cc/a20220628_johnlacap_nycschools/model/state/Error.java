package com.cc.a20220628_johnlacap_nycschools.model.state;

public class Error extends UIState {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
