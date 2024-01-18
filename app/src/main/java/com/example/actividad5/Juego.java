package com.example.actividad5;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
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
import android.widget.TableLayout;

public class Juego extends AppCompatActivity{

    private Button boton00 = (Button) findViewById(R.id.boton00);
    private Button boton01 = (Button) findViewById(R.id.boton01);
    private Button boton02 = (Button) findViewById(R.id.boton02);
    private Button boton10 = (Button) findViewById(R.id.boton10);
    private Button boton11 = (Button) findViewById(R.id.boton11);
    private Button boton12 = (Button) findViewById(R.id.boton12);
    private Button boton20 = (Button) findViewById(R.id.boton20);
    private Button boton21 = (Button) findViewById(R.id.boton21);
    private Button boton22 = (Button) findViewById(R.id.boton22);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);

        TableLayout lay = (TableLayout) findViewById(R.id.bgjuego);
        lay.setBackgroundColor(Color.parseColor("#BBAAFF"));

        int[][] matriz = new int[3][3];
        matriz[1][1] = 1;

        comprobar(matriz);
    }

    public static void comprobar(int[][] matriz) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
