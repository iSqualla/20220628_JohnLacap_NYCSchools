package com.cc.a20220628_johnlacap_nycschools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cc.a20220628_johnlacap_nycschools.view.Listener;
import com.cc.a20220628_johnlacap_nycschools.view.SchoolDetails;
import com.cc.a20220628_johnlacap_nycschools.view.SchoolDisplay;

public class MainActivity extends AppCompatActivity implements Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDisplayFragment();
    }

    private void showDisplayFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new SchoolDisplay())
                .commit();
    }

    @Override
    public void openDetails(String dbn, String name) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new SchoolDetails().getInstance(dbn, name))
                .addToBackStack(null)
                .commit();
    }

}