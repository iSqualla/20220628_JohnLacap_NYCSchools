package com.cc.a20220628_johnlacap_nycschools.model;

import com.cc.a20220628_johnlacap_nycschools.model.state.UIState;

import io.reactivex.rxjava3.core.Single;

public interface Repository {
    Single<UIState> getSchoolList();
    Single<UIState> getSchoolDetails(String dbn);
}