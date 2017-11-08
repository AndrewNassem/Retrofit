package com.sdatasolutions.report.Network;

import android.app.Activity;
import android.util.Log;

import com.google.gson.JsonObject;
import com.sdatasolutions.report.Model.BasicModel;
import com.sdatasolutions.report.Model.Consumed;
import com.sdatasolutions.report.Model.OrdersResponse;
import com.sdatasolutions.report.Model.SignInModel;
import com.sdatasolutions.report.Model.SignResponse;
import com.sdatasolutions.report.Model.StatisticDataSearch;
import com.sdatasolutions.report.Model.StatisticRequest;
import com.sdatasolutions.report.Model.StatisticResponse;

import java.util.List;

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


    public void signIn(SignInModel signInModel) {
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<SignResponse> connection = service.signIn(signInModel);

        connection.enqueue(new Callback<SignResponse>() {
            @Override
            public void onResponse(Call<SignResponse> call, Response<SignResponse> response) {
                String reponseStr = response.toString().replaceAll("\\\\", "");
                Log.e("new String", reponseStr);
                apiResponse.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SignResponse> call, Throwable t) {
                Log.e("QR ", " " + t.getLocalizedMessage());
                apiResponse.onFailed(t.getLocalizedMessage());
            }
        });
    }

    public void gettingStatisticSearchData(BasicModel basicModel) {
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<StatisticDataSearch> connection = service.gettingStatisticSearchData(basicModel);
        if (connection != null) {
            connection.enqueue(new Callback<StatisticDataSearch>() {
                @Override
                public void onResponse(Call<StatisticDataSearch> call, Response<StatisticDataSearch> response) {
                    String reponseStr = response.toString().replaceAll("\\\\", "");
                    Log.e("new String", reponseStr);
                    apiResponse.onSuccess(response.body());
                }

                @Override
                public void onFailure(Call<StatisticDataSearch> call, Throwable t) {

                    Log.e("QR ", " " + t.getLocalizedMessage());
                    apiResponse.onFailed(t.getLocalizedMessage());
                }
            });
        }

    }

    public void gettingStatistic(StatisticRequest statisticRequest) {
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<StatisticResponse> connection = service.gettingStatistic(statisticRequest);
        if (connection != null) {
            connection.enqueue(new Callback<StatisticResponse>() {
                @Override
                public void onResponse(Call<StatisticResponse> call, Response<StatisticResponse> response) {
                    String reponseStr = response.toString().replaceAll("\\\\", "");
                    Log.e("new String", reponseStr);
                    apiResponse.onSuccess(response.body());
                }

                @Override
                public void onFailure(Call<StatisticResponse> call, Throwable t) {

                    Log.e("QR ", " " + t.getLocalizedMessage());
                    apiResponse.onFailed(t.getLocalizedMessage());
                }
            });
        }

    }
    public void gettingConsumed(StatisticRequest statisticRequest) {
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Consumed>> connection = service.gettingConsumed(statisticRequest);
        if (connection != null) {
            connection.enqueue(new Callback<List<Consumed>>() {
                @Override
                public void onResponse(Call<List<Consumed>> call, Response<List<Consumed>> response) {
                    String reponseStr = response.toString().replaceAll("\\\\", "");
                    Log.e("new String", reponseStr);
                    apiResponse.onSuccess(response.body());
                }

                @Override
                public void onFailure(Call<List<Consumed>> call, Throwable t) {

                    Log.e("QR ", " " + t.getLocalizedMessage());
                    apiResponse.onFailed(t.getLocalizedMessage());
                }
            });
        }
    }
    public void dailyOrders(StatisticRequest statisticRequest) {
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<OrdersResponse> connection = service.dailyOrders(statisticRequest);
        if (connection != null) {
            connection.enqueue(new Callback<OrdersResponse>() {
                @Override
                public void onResponse(Call<OrdersResponse> call, Response<OrdersResponse> response) {
                    String reponseStr = response.toString().replaceAll("\\\\", "");
                    Log.e("new String", reponseStr);
                    apiResponse.onSuccess(response.body());
                }

                @Override
                public void onFailure(Call<OrdersResponse> call, Throwable t) {

                    Log.e("QR ", " " + t.getLocalizedMessage());
                    apiResponse.onFailed(t.getLocalizedMessage());
                }
            });
        }
    }


}
