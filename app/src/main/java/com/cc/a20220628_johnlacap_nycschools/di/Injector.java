package com.cc.a20220628_johnlacap_nycschools.di;

import com.cc.a20220628_johnlacap_nycschools.model.Repository;
import com.cc.a20220628_johnlacap_nycschools.model.RepositoryImpl;
import com.cc.a20220628_johnlacap_nycschools.model.network.Network;
import com.cc.a20220628_johnlacap_nycschools.view.viewmodel.SchoolViewModelProvider;

public class Injector {
    private static final Injector ourInstance = new Injector();

    public static Injector getInstance() {
        return ourInstance;
    }

    private Injector() {
    }

    public SchoolViewModelProvider provideProvider(){
        return new SchoolViewModelProvider(provideRepository());
    }

    private Repository provideRepository(){
        return new RepositoryImpl(Network.getInstance());
    }
}
