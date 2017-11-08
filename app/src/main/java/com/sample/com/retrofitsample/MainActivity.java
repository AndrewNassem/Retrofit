package com.sample.com.retrofitsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sample.com.retrofitsample.Network.ApiResponse;
import com.sample.com.retrofitsample.Network.HttpCall;

public class MainActivity extends AppCompatActivity implements ApiResponse{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestModel requestModel = new RequestModel();
        new HttpCall(this , this).signIn(requestModel);
    }

    @Override
    public void onSuccess(Object response) {

    }

    @Override
    public void onFailed(String error) {

    }
}
