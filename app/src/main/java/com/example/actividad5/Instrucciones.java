package com.example.actividad5;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.actividad5.databinding.ActivityInstruccionesBinding;

public class Instrucciones extends AppCompatActivity {

    Button btnVolver;
    Context context;
    private ActivityInstruccionesBinding binding;

    //EasterEgg😉😉
    private void generarCuadroDialogo() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Ubicacion Actual");
        alertDialogBuilder
                .setMessage("Quieres obtener tu ubicacion?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Toast.makeText(Instrucciones.this, "Estas en Albacete", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).create().show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        btnVolver = findViewById(R.id.btnVolver);

        binding = ActivityInstruccionesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generarCuadroDialogo();
            }
        });


    }

    public void volver(View vw) {
        startActivity(new Intent(this, Menu_Principal.class));
    }


}