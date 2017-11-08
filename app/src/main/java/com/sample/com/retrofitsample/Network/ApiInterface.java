package com.sdatasolutions.report.Network;

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
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by DELL on 30/06/2017.
 */

public interface ApiInterface {

    @POST("/access.php ")
    Call<SignResponse> signIn(@Body SignInModel signInModel);

    @POST("/sign_out.php ")
    Call<JsonObject> signOut(@Body JsonObject jsonObject);

    @POST("/getting_data_statics.php")
    Call<StatisticDataSearch> gettingStatisticSearchData(@Body BasicModel basicModel);

    @POST("/getting_statistics.php")
    Call<StatisticResponse> gettingStatistic(@Body StatisticRequest statisticRequest);

    @POST("/consumed.php")
    Call<List<Consumed>> gettingConsumed(@Body StatisticRequest statisticRequest);

    @POST("/daily_orders.php")
    Call<OrdersResponse> dailyOrders(@Body StatisticRequest statisticRequest);



}
