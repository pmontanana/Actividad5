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

        //filas
        for (int i = 0; i< 9; i+=3){
            if (tabla[i] == jugador && tabla[i+1] == jugador && tabla[i+2] == jugador){
                botones[i].setBackgroundResource(jugador == 1 ? R.drawable.starwin: R.drawable.moonwin);
                botones[i+1].setBackgroundResource(jugador == 1 ? R.drawable.starwin: R.drawable.moonwin);
                botones[i+2].setBackgroundResource(jugador == 1 ? R.drawable.starwin: R.drawable.moonwin);
                return true;
            }
        }
        //columnas
        for (int i = 0; i< 3; i++){
            if (tabla[i] == jugador && tabla[i+3] == jugador && tabla[i+6] == jugador){
                botones[i].setBackgroundResource(jugador == 1 ? R.drawable.starwin: R.drawable.moonwin);
                botones[i+3].setBackgroundResource(jugador == 1 ? R.drawable.starwin: R.drawable.moonwin);
                botones[i+6].setBackgroundResource(jugador == 1 ? R.drawable.starwin: R.drawable.moonwin);
                return true;
            }
        }
        //diagonales
        if (tabla[0] == jugador && tabla[4] == jugador && tabla[8] == jugador){
            botones[0].setBackgroundResource(jugador == 1 ? R.drawable.starwin: R.drawable.moonwin);
            botones[4].setBackgroundResource(jugador == 1 ? R.drawable.starwin: R.drawable.moonwin);
            botones[8].setBackgroundResource(jugador == 1 ? R.drawable.starwin: R.drawable.moonwin);
            return true;
        }
        if (tabla[2] == jugador && tabla[4] == jugador && tabla[6] == jugador){
            botones[2].setBackgroundResource(jugador == 1 ? R.drawable.starwin: R.drawable.moonwin);
            botones[4].setBackgroundResource(jugador == 1 ? R.drawable.starwin: R.drawable.moonwin);
            botones[6].setBackgroundResource(jugador == 1 ? R.drawable.starwin: R.drawable.moonwin);
            return true;
        }
        return false;
    }


}






