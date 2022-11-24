package com.example.appovertonhotel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edit_user = findViewById(R.id.edit_user);
        EditText edit_pass = findViewById(R.id.edit_pass);

        findViewById(R.id.Loginone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_pass.getText().toString().isEmpty() || edit_user.getText().toString().isEmpty()) {
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Overton")
                            .setMessage("Debes de escribir el nombre de usuario y el password")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            }).show();
                } else{
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }
            }
        });

        findViewById(R.id.btn_registrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegistroActivity.class));
            }
        });
    }
}