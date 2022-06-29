package com.cc.a20220628_johnlacap_nycschools.model.network;

import com.cc.a20220628_johnlacap_nycschools.model.pojo.NYCSATResponse;
import com.cc.a20220628_johnlacap_nycschools.model.pojo.NYCSchoolResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface SchoolService {
    @GET(ENDPOINTS.ENDPOINT_SCHOOL)
    Single<List<NYCSchoolResponse>> getSchoolList();

    @GET(ENDPOINTS.ENDPOINT_SAT)
    Single<List<NYCSATResponse>> getSatList();
}

