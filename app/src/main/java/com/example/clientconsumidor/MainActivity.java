package com.example.clientconsumidor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button data_btn;
        Button id_btn;
        Button ultimo_btn;
        EditText data_et;
        EditText id_et;

        data_btn = findViewById(R.id.data_brn);
        id_btn = findViewById(R.id.id_btn);
        ultimo_btn = findViewById(R.id.last_btn);
        data_et = findViewById(R.id.data_tv);
        id_et = findViewById(R.id.id_tv);

        data_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data_et.getText().toString().isEmpty())
                    return;
                Fragment fragment = new DadoFragment();
                Bundle bundle = new Bundle();
                bundle.putString("data", data_et.getText().toString());
                data_et.getText().clear();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment).commit();
            }
        });

        id_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id_et.getText().toString().isEmpty())
                    return;
                Fragment fragment = new DadoFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("id", Integer.parseInt(id_et.getText().toString()));
                id_et.getText().clear();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment).commit();
            }
        });
        ultimo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,  new DadoFragment()).commit();
            }
        });
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,  new DadoFragment()).commit();
    }

    @Override
    public void onClick(View v) {

    }
}