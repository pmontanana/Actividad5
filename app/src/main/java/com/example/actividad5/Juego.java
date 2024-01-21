package com.example.actividad5;

import static android.app.PendingIntent.getActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Arrays;

public class Juego extends AppCompatActivity{


    int[] tabla = new int[]{
            0,0,0,
            0,0,0,
            0,0,0
    };
    TextView textJug1;
    TextView textJug2;
    Integer[] matriz ;

    ToggleButton[] botones;

    boolean fin = true;
    int casillas = 0;
    boolean jugador = true;
    int contadorParImpar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_tr);

        View lay = (View) findViewById(R.id.bgjuego);
        lay.setBackgroundColor(Color.parseColor("#BBAAFF"));

        textJug1 = (TextView) findViewById(R.id.textJug1);
        textJug1.setVisibility(View.VISIBLE);
        textJug2 = (TextView) findViewById(R.id.textJug2);
        textJug2.setVisibility(View.INVISIBLE);

        matriz = new Integer[]{
                R.id.boton00, R.id.boton01, R.id.boton02, R.id.boton10, R.id.boton11, R.id.boton12, R.id.boton20, R.id.boton21, R.id.boton22
        };


        botones = new ToggleButton[]{findViewById(R.id.boton00), findViewById(R.id.boton01), findViewById(R.id.boton02),
                                    findViewById(R.id.boton10), findViewById(R.id.boton11), findViewById(R.id.boton12),
                                    findViewById(R.id.boton20), findViewById(R.id.boton21), findViewById(R.id.boton22)};

    }

    public void win(){
        botones[0].setEnabled(false);
        botones[1].setEnabled(false);
        botones[2].setEnabled(false);
        botones[3].setEnabled(false);
        botones[4].setEnabled(false);
        botones[5].setEnabled(false);
        botones[6].setEnabled(false);
        botones[7].setEnabled(false);
        botones[8].setEnabled(false);

    }
    public void poner(View vw) {
        if (contadorParImpar % 2 == 0){
            textJug2.setVisibility(View.INVISIBLE);
            textJug1.setVisibility(View.VISIBLE);
            int botonPulsado = Arrays.asList(matriz).indexOf(vw.getId());
            if (botones[botonPulsado].isChecked()){
                botones[botonPulsado].setEnabled(false);
                contadorParImpar++;
            }
            vw.setBackgroundResource(R.drawable.star);
            tabla[botonPulsado] = 1;
            textJug2.setVisibility(View.VISIBLE);
            textJug1.setVisibility(View.INVISIBLE);
        } else {
            textJug1.setVisibility(View.INVISIBLE);
            textJug2.setVisibility(View.VISIBLE);
            int botonPulsado = Arrays.asList(matriz).indexOf(vw.getId());
            if (botones[botonPulsado].isChecked()){
                botones[botonPulsado].setEnabled(false);
                contadorParImpar++;
            }
            vw.setBackgroundResource(R.drawable.moon);
            tabla[botonPulsado] = 2;
            textJug1.setVisibility(View.VISIBLE);
            textJug2.setVisibility(View.INVISIBLE);
        }

        if (tabla[0] == 1 && tabla[1] == 1 && tabla[2] == 1
                || tabla[0] == 1 && tabla[3] == 1 && tabla[6] == 1
                || tabla[2] == 1 && tabla[5] == 1 && tabla[8] == 1
                || tabla[6] == 1 && tabla[7] == 1 && tabla[8] == 1
                || tabla[3] == 1 && tabla[4] == 1 && tabla[5] == 1
                || tabla[1] == 1 && tabla[4] == 1 && tabla[7] == 1
                || tabla[0] == 1 && tabla[4] == 1 && tabla[8] == 1
                || tabla[2] == 1 && tabla[4] == 1 && tabla[6] == 1){
            win();
            dialogoVictoria("Jugador 1");
        }
        if (tabla[0] == 2 && tabla[1] == 2 && tabla[2] == 2
                || tabla[0] == 2 && tabla[3] == 2 && tabla[6] == 2
                || tabla[2] == 2 && tabla[5] == 2 && tabla[8] == 2
                || tabla[6] == 2 && tabla[7] == 2 && tabla[8] == 2
                || tabla[3] == 2 && tabla[4] == 2 && tabla[5] == 2
                || tabla[1] == 2 && tabla[4] == 2 && tabla[7] == 2
                || tabla[0] == 2 && tabla[4] == 2 && tabla[8] == 2
                || tabla[2] == 2 && tabla[4] == 2 && tabla[6] == 2){
            win();
            dialogoVictoria("Jugador 2");
        }
    }


    public void reiniciar(View vw){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
    public void dialogoVictoria(String jugador) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("VICTORIA");
        builder.setMessage("Ha ganado el " + jugador);
        builder.setPositiveButton("OK",null);
        builder.create();
        builder.show();
    }
    }






