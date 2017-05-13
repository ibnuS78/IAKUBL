package com.example.iakubl.iakubl.mainview;

import android.text.TextUtils;

import com.example.iakubl.iakubl.interactor.interfacemain;
import com.example.iakubl.iakubl.interactor.interfacepresenter;

/**
 * Created by Ibnu on 5/13/2017.
 */

public class mainpresenter implements interfacepresenter {
    private interfacemain minterfacemain;

    public mainpresenter(interfacemain interfacemain) {
        minterfacemain = interfacemain;
    }

    @Override
    public void Login(String username,String password){
        if(TextUtils.isEmpty(username)|| TextUtils.isEmpty(password)){
            minterfacemain.ShowError();
        }else{
            if(username.equals("admin")&&password.equals("admin")){
                minterfacemain.LoginSuccess();
            }else {
                minterfacemain.LoginError();
            }
        }
    }
}
