package com.example.actividad5;

import static kotlin.random.RandomKt.nextInt;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Random;

public class Juego extends AppCompatActivity {

    int[] tabla = new int[] {
            0, 0, 0,
            0, 0, 0,
            0, 0, 0
    };
    TextView textWin;
    Integer[] matriz;

    TextView pruebita;
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

        textWin = (TextView) findViewById(R.id.textWin);
        textWin.setVisibility(View.INVISIBLE);

        matriz = new Integer[] {
                R.id.boton00, R.id.boton01, R.id.boton02, R.id.boton10, R.id.boton11, R.id.boton12, R.id.boton20,
                R.id.boton21, R.id.boton22
        };

        pruebita = (TextView) findViewById(R.id.pruebita);

        botones = new ToggleButton[] { findViewById(R.id.boton00), findViewById(R.id.boton01),
                findViewById(R.id.boton02),
                findViewById(R.id.boton10), findViewById(R.id.boton11), findViewById(R.id.boton12),
                findViewById(R.id.boton20), findViewById(R.id.boton21), findViewById(R.id.boton22) };

    }

    /*
     * public void escribir(View vw){
     * boolean jugador = true;
     * int botonPulsado = 0;
     * boolean fin = true;
     * int casillas = 0;
     * String holia;
     * int[] botnpuls = new int[9];
     * Random ran = new Random();
     * int pos = ran.nextInt(tabla.length);
     * 
     * while(fin){
     * 
     * botonPulsado = Arrays.asList(matriz).indexOf(vw.getId());
     * if (botonPulsado == 1){
     * break;
     * }
     * vw.setBackgroundResource(R.drawable.star);
     * tabla[botonPulsado] = 1;
     * casillas++;
     * if (casillas >= 5){
     * fin = false;
     * }
     * 
     * botnpuls = new int[botonPulsado];
     * }
     * 
     * 
     * 
     * }
     */

    public void poner(View vw) {
        int botonPulsado = Arrays.asList(matriz).indexOf(vw.getId());
        if (botones[botonPulsado].isChecked()) {
            botones[botonPulsado].setEnabled(false);
            vw.setBackgroundResource(casillas % 2 == 0 ? R.drawable.star : R.drawable.moon);
            tabla[botonPulsado] = casillas % 2 + 1;
            casillas++;
        }
    }

    // public int comprobador(int matriz){
    // for (int i = 0; i< matriz.length;i++){
    // return new int[]{matriz[i]};
    //
    // }
    // }

}
