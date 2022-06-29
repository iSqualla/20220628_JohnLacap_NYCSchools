package com.cc.a20220628_johnlacap_nycschools.view.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.cc.a20220628_johnlacap_nycschools.model.Repository;

public class SchoolViewModelProvider implements ViewModelProvider.Factory {

    private Repository repository;

    public SchoolViewModelProvider(Repository repository){
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SchoolViewModel(repository);
    }
}