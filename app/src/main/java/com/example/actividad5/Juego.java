package com.example.actividad5;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;

public class Juego extends AppCompatActivity{


    int[] tabla = new int[]{
            0,0,0,
            0,0,0,
            0,0,0
    };
    TextView textWin;
    Integer[] matriz ;

    TextView pruebita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_tr);

        View lay = (View) findViewById(R.id.bgjuego);
        lay.setBackgroundColor(Color.parseColor("#BBAAFF"));

        textWin = (TextView) findViewById(R.id.textWin);
        textWin.setVisibility(View.INVISIBLE);

        matriz = new Integer[]{
                R.id.boton00, R.id.boton01, R.id.boton02, R.id.boton10, R.id.boton11, R.id.boton12, R.id.boton20, R.id.boton21, R.id.boton22
        };

        pruebita = (TextView) findViewById(R.id.pruebita);


    }

    public void escribir(View vw){
        boolean jugador = true;
        int botonPulsado = 0;
        boolean fin = true;
        int casillas = 0;
        String holia;


        while(fin){
            if (botonPulsado == 0){
                botonPulsado = Arrays.asList(matriz).indexOf(vw.getId());
                vw.setBackgroundResource(R.drawable.star);
                if (tabla[casillas] != 1) {
                    tabla[botonPulsado] = 1;
                }
            }

                casillas++;
                if (casillas >= 5){
                    fin = false;
                }


            }



        }




    }




