package com.example.iakubl.iakubl.mainview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iakubl.iakubl.R;
import com.example.iakubl.iakubl.adapter.HomeAdapter;
import com.example.iakubl.iakubl.interactor.HomeInterface;
import com.example.iakubl.iakubl.mainhome.HomePresenter;
import com.example.iakubl.iakubl.model.HomeModel;
import com.example.iakubl.iakubl.model.ServiceModel;
import com.example.iakubl.iakubl.service.ServiceAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity implements HomeInterface {

    private TextView mtxtSukses;
    private RecyclerView mrecyclerView;
    private HomeAdapter mHomeAdapter;
    private HomeInterface mHomeInterface;
    private ArrayList<HomeModel> mHomeModel;

    private List<ServiceModel> mService;

    public static final String Base_URL = "https://private-4e4159-qurrata.apiary-mock.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mtxtSukses = (TextView) findViewById(R.id.txtSukses);
        Intent mintent = getIntent();
        String username = mintent.getStringExtra("username");
        mtxtSukses.setText(username);

        mHomeInterface = new HomePresenter(this);
        mHomeModel = new ArrayList<>();
        mHomeInterface.ShowList(mHomeModel);
        initView();
        getData();
    }

    private void initView(){
        mrecyclerView = (RecyclerView) findViewById(R.id.Rview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setHasFixedSize(true);
        mHomeAdapter = new HomeAdapter(mHomeModel,this);
        mrecyclerView.setAdapter(mHomeAdapter);
    }

    @Override
    public void ShowList(ArrayList<HomeModel> Homemodels) {

    }

    private void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServiceAPI serviceAPI = retrofit.create(ServiceAPI.class);
        Call<List<ServiceModel>> call = serviceAPI.getData();
        call.enqueue(new Callback<List<ServiceModel>>() {
            @Override
            public void onResponse(Call<List<ServiceModel>> call, Response<List<ServiceModel>> response) {
                mService = response.body();
                int jumlah = mService.size();
                for (int i = 0; i < jumlah; i++){
                    String judul = mService.get(i).getJudul();
                    Toast.makeText(HomeActivity.this, "" + judul ,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ServiceModel>> call, Throwable t) {

            }
        });
    }
}
