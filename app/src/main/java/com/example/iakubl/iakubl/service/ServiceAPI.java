package com.example.iakubl.iakubl.service;

import com.example.iakubl.iakubl.model.ServiceModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ibnu on 5/14/2017.
 */

public interface ServiceAPI {

    String END_POINT = "questions";//Last Name Directory On JSON URL

    @GET(END_POINT)
    Call<List<ServiceModel>> getData();//Get Model Data
}
