package com.sample.com.retrofitsample.Network;


import com.sample.com.retrofitsample.RequestModel;
import com.sample.com.retrofitsample.ResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by DELL on 30/06/2017.
 */

public interface ApiInterface {

    @POST("/access.php ")
    Call<ResponseModel> signIn(@Body RequestModel signInModel);




}
