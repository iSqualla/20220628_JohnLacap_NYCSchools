package com.cc.a20220628_johnlacap_nycschools.model.state;

import com.cc.a20220628_johnlacap_nycschools.model.pojo.NYCSATResponse;

public class SuccessSATResponse extends UIState{
    private NYCSATResponse data;

    public NYCSATResponse getData() {
        return data;
    }

    public void setData(NYCSATResponse data) {
        this.data = data;
    }
}