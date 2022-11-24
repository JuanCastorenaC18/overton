package com.example.appovertonhotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    String [] listcity = {"Torreon","Gomez Palacio","Lerdo"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        EditText edit_email = findViewById(R.id.edit_email);
        EditText edit_telefono = findViewById(R.id.edit_telefono);
        EditText edit_name = findViewById(R.id.edit_name);
        EditText edit_city = findViewById(R.id.edit_city);
        EditText edit_pass = findViewById(R.id.edit_pass);
        EditText edit_passcon = findViewById(R.id.edit_passcon);

        findViewById(R.id.btn_registro).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_email.getText().toString().isEmpty() || edit_telefono.getText().toString().isEmpty() || edit_name.getText().toString().isEmpty() || edit_city.getText().toString().isEmpty() || edit_pass.getText().toString().isEmpty() || edit_passcon.getText().toString().isEmpty()) {
                    new AlertDialog.Builder(RegistroActivity.this)
                            .setTitle("Overton")
                            .setMessage("Debes de llenar todos los campos")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            }).show();
                } else{
                    startActivity(new Intent(RegistroActivity.this, HomeActivity.class));
                }
            }
        });

        autoCompleteTextView = findViewById(R.id.edit_city);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item,listcity);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Item: "+item,Toast.LENGTH_SHORT).show();
            }
        });
    }
}