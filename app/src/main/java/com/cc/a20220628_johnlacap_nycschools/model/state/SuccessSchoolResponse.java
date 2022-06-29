package com.cc.a20220628_johnlacap_nycschools.model.state;

import com.cc.a20220628_johnlacap_nycschools.model.pojo.NYCSchoolResponse;

import java.util.List;

public class SuccessSchoolResponse extends UIState{
    private List<NYCSchoolResponse> data;

    public List<NYCSchoolResponse> getData() {
        return data;
    }

    public void setData(List<NYCSchoolResponse> data) {
        this.data = data;
    }
}