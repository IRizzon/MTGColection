package com.example.magiccolection.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.magiccolection.R;

public class LoginActivity extends AppCompatActivity {

    Button idEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idEnter = findViewById(R.id.idEnter);

        idEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent telaPrincipal = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(telaPrincipal);
                finish();

            }
        });
    }
}