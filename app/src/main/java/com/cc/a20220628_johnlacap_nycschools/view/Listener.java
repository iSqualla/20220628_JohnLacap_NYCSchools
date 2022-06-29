package com.cc.a20220628_johnlacap_nycschools.view;

public interface Listener{
    void openDetails(String dbn, String name);
    interface ListClickEvent{
        void clickDetails(String dbn, String name);
    }
}
