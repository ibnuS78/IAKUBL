package com.example.iakubl.iakubl.mainhome;

import android.content.Context;

import com.example.iakubl.iakubl.interactor.HomeInterface;
import com.example.iakubl.iakubl.model.HomeModel;

import java.util.ArrayList;

/**
 * Created by Ibnu on 5/14/2017.
 */

public class HomePresenter implements HomeInterface{
    private Context mContext;
    private ArrayList<HomeModel> mHomeModel;

    public HomePresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void ShowList(ArrayList<HomeModel> Homemodels) {
        mHomeModel = Homemodels;
        mHomeModel.add(new HomeModel("Ibnu","Jakarta","ibnu1995@gmail.com","087885063186"));
        mHomeModel.add(new HomeModel("Adi","Jakarta","adi@gmail.com","089885063186"));
        mHomeModel.add(new HomeModel("Budi","Jakarta","budi@gmail.com","087885903186"));
        mHomeModel.add(new HomeModel("Ciko","Jakarta","ciko@gmail.com","090885903186"));
        mHomeModel.add(new HomeModel("Dudi","Jakarta","dudi@gmail.com","089985903186"));
        mHomeModel.add(new HomeModel("Edi","Jakarta","edi@gmail.com","088885903186"));
    }
}
