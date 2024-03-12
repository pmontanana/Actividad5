package com.example.actividad5;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;

public class SignUp extends AppCompatActivity {

    SignUp context;

    FirebaseAuth auth;
    Button botonSign;
    Button botonRef;
    EditText signUser, signPasswd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        botonSign = findViewById(R.id.signButton);
        botonRef = findViewById(R.id.btnRefLog);
        auth = FirebaseAuth.getInstance();
        signUser = findViewById(R.id.userETR);
        signPasswd = findViewById(R.id.passwdETR);

        botonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = signUser.getText().toString().trim();
                String contrasena = signPasswd.getText().toString().trim();

                if (usuario.isEmpty()) {
                    signUser.setError("Tienes que introducir un usuario");
                }
                if (contrasena.isEmpty()) {
                    signPasswd.setError("Tienes que escribir una contraseña");
                } else {
                    auth.createUserWithEmailAndPassword(usuario, contrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Snackbar.make(getCurrentFocus(), "Registro completo", BaseTransientBottomBar.LENGTH_SHORT).show();

                                startActivity(new Intent(SignUp.this, Login.class));
                            } else {
                                Snackbar.make(getCurrentFocus(), "Registro fallido", BaseTransientBottomBar.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });

        botonRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, Login.class));
            }
        });

    }


}