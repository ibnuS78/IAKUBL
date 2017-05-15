package com.example.iakubl.iakubl.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iakubl.iakubl.R;
import com.example.iakubl.iakubl.model.HomeModel;

import java.util.ArrayList;

/**
 * Created by Ibnu on 5/14/2017.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private ArrayList<HomeModel> mHomeModel;
    private Context mContext;

    public HomeAdapter(ArrayList<HomeModel> mHomeModel, Context mContext) {
        this.mHomeModel = mHomeModel;
        this.mContext = mContext;
    }

    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mlayoutInflater = LayoutInflater.from(parent.getContext());
        View mview = mlayoutInflater.inflate(R.layout.item_home_view,parent,false);
        return new ViewHolder(mview);
    }

    @Override
    public void onBindViewHolder(HomeAdapter.ViewHolder holder, int position) {
        HomeModel homeModel = mHomeModel.get(position);
        holder.txt1.setText(homeModel.getNama());
        holder.txt2.setText(homeModel.getAlamat());
        holder.txt3.setText(homeModel.getEmail());
        holder.txt4.setText(homeModel.getNoTelp());
    }

    @Override
    public int getItemCount() {
        return mHomeModel.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt1,txt2,txt3,txt4;
        public ViewHolder(View iteView){
            super(iteView);
            txt1 = (TextView) iteView.findViewById(R.id.tv_name);
            txt2 = (TextView) iteView.findViewById(R.id.tv_alamat);
            txt3 = (TextView) iteView.findViewById(R.id.tv_email);
            txt4 = (TextView) iteView.findViewById(R.id.tv_telepon);
        }
    }
}
