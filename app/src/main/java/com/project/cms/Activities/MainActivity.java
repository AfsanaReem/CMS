package com.project.cms.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.project.cms.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button registerButton;
    private MaterialButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        registerButton = findViewById(R.id.registerButton);
        loginButton = findViewById(R.id.loginButton);
        registerButton.setBackgroundColor(Color.TRANSPARENT);

        registerButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerButton:
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
                break;
            case R.id.loginButton:
                Intent intent2 = new Intent(MainActivity.this, Home.class);
                startActivity(intent2);
                break;
        }
    }


}
