package com.example.actividad5;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;


import android.widget.Button;

public class Menu_Principal extends AppCompatActivity {

    private AppBarConfiguration barra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button salirp = (Button) findViewById(R.id.btnCerrar);
        Button iniciarJ = (Button) findViewById(R.id.btnIniciar);
        Button login = (Button) findViewById(R.id.loginbtn);
        Button instr = findViewById(R.id.btnInstrucciones);
        View lay = findViewById(R.id.bgr);
        lay.setBackgroundColor(Color.parseColor("#00AAFF"));


        iniciarJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad2 = new Intent(getApplicationContext(), Juego.class);
                startActivity(actividad2);
            }


        });
        salirp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        instr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Principal.this, Instrucciones.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(), Login.class);
                startActivity(login);
            }


        });

    }
}