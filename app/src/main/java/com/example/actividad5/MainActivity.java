package com.example.actividad5;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import com.example.actividad5.databinding.JuegoBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Intent actividad2 = new Intent(this, Juego.class);

        Button salirp = (Button) findViewById(R.id.btnCerrar);
        Button iniciarJ = (Button) findViewById(R.id.btnIniciar);
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

        iniciarJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actividad2.addCategory(Intent.CATEGORY_HOME);
                actividad2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(actividad2);
            }
        });

    }
}