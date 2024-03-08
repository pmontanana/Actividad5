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
    Integer[] matriz ;

    ToggleButton[] botones;

    int casillas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_tr);

        View lay = (View) findViewById(R.id.bgjuego);
        lay.setBackgroundColor(Color.parseColor("#BBAAFF"));

        textJug1 = (TextView) findViewById(R.id.textJug1);


        matriz = new Integer[]{
                R.id.boton00, R.id.boton01, R.id.boton02, R.id.boton10, R.id.boton11, R.id.boton12, R.id.boton20, R.id.boton21, R.id.boton22
        };


        botones = new ToggleButton[]{findViewById(R.id.boton00), findViewById(R.id.boton01), findViewById(R.id.boton02),
                                    findViewById(R.id.boton10), findViewById(R.id.boton11), findViewById(R.id.boton12),
                                    findViewById(R.id.boton20), findViewById(R.id.boton21), findViewById(R.id.boton22)};

    }

    public void poner(View vw) {
        int jugador = casillas%2+1;
        muestraTurno(jugador);
        int botonPulsado = Arrays.asList(matriz).indexOf(vw.getId());
        if (botones[botonPulsado].isChecked()){
            botones[botonPulsado].setEnabled(false);
            casillas++;
        }
        vw.setBackgroundResource(jugador == 1 ? R.drawable.star: R.drawable.moon);
        tabla[botonPulsado] = jugador;

        if (condicionVictoria(jugador)){
            win();
            dialogoVictoria(jugador);
        }

    }

    public void muestraTurno(int jugador){
        textJug1.setText("Turno del jugador " + jugador);
    }

    public void win(){
        for (int i = 0; i < tabla.length;i++){
            botones[i].setEnabled(false);
        }

    }

    public void reiniciar(View vw){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
    public void dialogoVictoria(int jugador) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("VICTORIA");
        builder.setMessage("Ha ganado el jugador " + jugador);
        builder.setPositiveButton("OK",null);
        builder.create();
        builder.show();
    }

    public boolean condicionVictoria(int jugador){

        int[] condiciones = new int[] {
                0, 1, 2,
                3, 4, 5,
                6, 7, 8,
                0, 3, 6,
                1, 4, 7,
                2, 5, 8,
                0, 4, 8,
                2, 4, 6
        };

        for (int i = 0; i < 24; i+=3){
            if (tabla[condiciones[i]] == jugador && tabla[condiciones[i+1]] == jugador && tabla[condiciones[i+2]] == jugador) {
                botones[condiciones[i]].setBackgroundResource(jugador == 1 ? R.drawable.starwin : R.drawable.moonwin);
                botones[condiciones[i+1]].setBackgroundResource(jugador == 1 ? R.drawable.starwin : R.drawable.moonwin);
                botones[condiciones[i+2]].setBackgroundResource(jugador == 1 ? R.drawable.starwin : R.drawable.moonwin);
                return true;
            }
        }
        return false;
    }


}






