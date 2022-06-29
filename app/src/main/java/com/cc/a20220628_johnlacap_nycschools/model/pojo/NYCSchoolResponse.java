package com.cc.a20220628_johnlacap_nycschools.model.pojo;

public class NYCSchoolResponse {
    private String dbn;
    private String school_name;

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getDbn() {
        return dbn;
    }

    public String getSchool_name() {
        return school_name;
    }
}