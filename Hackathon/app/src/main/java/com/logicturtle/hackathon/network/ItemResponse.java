package com.logicturtle.hackathon.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ItemResponse<T> {

    public T getData() {
        return data;
    }

    @Expose
    @SerializedName("data")
    private T data;


}
