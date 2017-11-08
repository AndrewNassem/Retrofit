package com.sample.com.retrofitsample.Network;

/**
 * Created by DELL on 09/06/2017.
 */

public interface ApiResponse {
    public void onSuccess(Object response);

    public void onFailed(String error);
}
