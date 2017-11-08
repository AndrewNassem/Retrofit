package com.sample.com.retrofitsample.Network;

import android.app.Activity;
import android.util.Log;


import com.sample.com.retrofitsample.RequestModel;
import com.sample.com.retrofitsample.ResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DELL on 09/06/2017.
 */

public class HttpCall {
    private Activity activity;
    private ApiResponse apiResponse;

    public HttpCall(Activity activity, ApiResponse apiResponse) {

        this.activity = activity;
        this.apiResponse = apiResponse;
    }

    public HttpCall(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }


    public void signIn(RequestModel requestModel) {
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseModel> connection = service.signIn(requestModel);

        connection.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                String reponseStr = response.toString().replaceAll("\\\\", "");
                Log.e("new String", reponseStr);
                apiResponse.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.e("QR ", " " + t.getLocalizedMessage());
                apiResponse.onFailed(t.getLocalizedMessage());
            }
        });
    }



}
