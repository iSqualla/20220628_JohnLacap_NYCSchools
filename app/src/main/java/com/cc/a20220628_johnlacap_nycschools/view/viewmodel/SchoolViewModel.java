package com.cc.a20220628_johnlacap_nycschools.view.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cc.a20220628_johnlacap_nycschools.model.Repository;
import com.cc.a20220628_johnlacap_nycschools.model.state.SuccessSATResponse;
import com.cc.a20220628_johnlacap_nycschools.model.state.UIState;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SchoolViewModel extends ViewModel {

    private MutableLiveData<UIState> _schoolState = new MutableLiveData<>();
    public LiveData<UIState> schoolState(){
        return _schoolState;
    }
    private Repository repository;

    public SchoolViewModel(Repository repository){
        this.repository = repository;
        init();
    }

    private void init(){
        repository.getSchoolList()
                .subscribeOn(
                        Schedulers.io()
                )
                .observeOn(
                        AndroidSchedulers.mainThread()
                )
                .subscribe(
                        new SingleObserver<UIState>(){
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                // dispose any composable...
                            }
                            @Override
                            public void onSuccess(@NonNull UIState uiState) {
                                _schoolState.setValue(uiState);
                            }
                            @Override
                            public void onError(@NonNull Throwable e) {
                                e.printStackTrace();
                            }
                        }
                );
    }

    public void getSatDetails(String dbn){
        repository.getSchoolDetails(dbn)
                .subscribeOn(
                        Schedulers.io()
                )
                .observeOn(
                        AndroidSchedulers.mainThread()
                )
                .subscribe(
                        new SingleObserver<UIState>(){

                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                // dispose any composable...
                            }

                            @Override
                            public void onSuccess(@NonNull UIState uiState) {
                                Log.d("TAG", "onSuccess: "+ ((SuccessSATResponse) uiState).getData().getNum_of_sat_test_takers());
                                _schoolState.setValue(uiState);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                e.printStackTrace();
                            }
                        }
                );
    }
}