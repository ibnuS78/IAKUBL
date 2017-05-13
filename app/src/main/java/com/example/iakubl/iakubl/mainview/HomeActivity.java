package com.example.iakubl.iakubl.mainview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.iakubl.iakubl.R;

public class HomeActivity extends AppCompatActivity {

    private TextView mtxtSukses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mtxtSukses = (TextView) findViewById(R.id.txtSukses);
        Intent mintent = getIntent();
        String username = mintent.getStringExtra("username");
        mtxtSukses.setText(username);
    }
}
