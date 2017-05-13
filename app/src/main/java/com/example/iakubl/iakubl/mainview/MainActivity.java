package com.example.iakubl.iakubl.mainview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iakubl.iakubl.R;
import com.example.iakubl.iakubl.interactor.interfacemain;
import com.example.iakubl.iakubl.interactor.interfacepresenter;

public class MainActivity extends AppCompatActivity implements interfacemain {

    private EditText mtxtUserName;
    private EditText mtxtPassword;
    private Button  mbtnLogin;
    private mainpresenter mmainpresenter;
    private interfacepresenter minterfacepresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtxtUserName = (EditText) findViewById(R.id.txtUserName);
        mtxtPassword = (EditText) findViewById(R.id.txtPassword);
        mbtnLogin = (Button) findViewById(R.id.btnLogin);
        minterfacepresenter = new mainpresenter(this);

        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minterfacepresenter.Login(mtxtUserName.getText().toString(),mtxtPassword.getText().toString());
            }
        });
    }

    @Override
    public void ShowError() {
        Toast.makeText(this,"User or Password is Blank!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ConnectionError() {
        Toast.makeText(this,"Please Check Your Connection!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginError() {
        Toast.makeText(this,"Invalid User or Password!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginSuccess() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        intent.putExtra("username",mtxtUserName.getText().toString());
        startActivity(intent);

    }
}
