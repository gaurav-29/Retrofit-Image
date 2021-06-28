package com.example.retrofitimage;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("CategoryList")
    Call<TestModel> getCategory();   // we can give any name of method instead of MarvelList().

}
