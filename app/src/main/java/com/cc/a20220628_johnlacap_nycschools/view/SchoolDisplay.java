package com.cc.a20220628_johnlacap_nycschools.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cc.a20220628_johnlacap_nycschools.R;
import com.cc.a20220628_johnlacap_nycschools.di.Injector;
import com.cc.a20220628_johnlacap_nycschools.model.pojo.NYCSchoolResponse;
import com.cc.a20220628_johnlacap_nycschools.model.state.Error;
import com.cc.a20220628_johnlacap_nycschools.model.state.SuccessSchoolResponse;
import com.cc.a20220628_johnlacap_nycschools.model.state.UIState;
import com.cc.a20220628_johnlacap_nycschools.view.viewmodel.SchoolViewModel;
import com.cc.a20220628_johnlacap_nycschools.view.viewmodel.SchoolViewModelProvider;

import java.util.List;

public class SchoolDisplay extends Fragment implements Listener.ListClickEvent{

    private SchoolViewModel viewModel;
    private RecyclerView schoolList;
    private SchoolAdapter adapter;
    private Listener listener;
    private SchoolViewModelProvider schoolViewModelProvider = Injector.getInstance().provideProvider();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Listener)
            listener = (Listener) context;
        else
            throw new ExceptionInInitializerError("Incorrect Host Activity");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(
                R.layout.school_display_fragment_layout
                , container,
                false);
        initViews(view);
        initObservables();
        return view;
    }

    private void initObservables() {
        viewModel = new ViewModelProvider(this, schoolViewModelProvider).get(SchoolViewModel.class);
        viewModel.schoolState().observe(getViewLifecycleOwner(), this::processUIState);
    }

    private void processUIState(UIState uiState) {
        if (uiState instanceof SuccessSchoolResponse)
            updateAdapter(((SuccessSchoolResponse) uiState).getData());
        else if (uiState instanceof Error)
            showError(((Error) uiState).getErrorMessage());
    }

    private void showError(String errorMessage) {

    }

    private void updateAdapter(List<NYCSchoolResponse> data) {
        adapter = new SchoolAdapter(data, this);
        schoolList.setAdapter(adapter);
    }

    private void initViews(View view) {
        schoolList = view.findViewById(R.id.school_list);
        schoolList.setLayoutManager(new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false));
    }

    @Override
    public void clickDetails(String dbn, String name) {
        listener.openDetails(dbn, name);
    }
}
