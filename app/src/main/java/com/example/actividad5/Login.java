package com.example.actividad5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {

    Login context;

    FirebaseAuth auth;
    Button botonLogin, botonRef;
    EditText loginUser, loginPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        botonRef = findViewById(R.id.btnRefReg);
        botonLogin = findViewById(R.id.loginButton);
        auth = FirebaseAuth.getInstance();
        loginUser = findViewById(R.id.userET);
        loginPasswd = findViewById(R.id.passwdET);

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = loginUser.getText().toString();
                String contraseña = loginPasswd.getText().toString();

                if (!usuario.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(usuario).matches()) {
                    if (!contraseña.isEmpty()) {
                        auth.signInWithEmailAndPassword(usuario, contraseña)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Snackbar.make(getCurrentFocus(), "Sesion iniciada", BaseTransientBottomBar.LENGTH_SHORT).show();
                                        startActivity(new Intent(Login.this, Menu_Principal.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Snackbar.make(getCurrentFocus(), "Inicio de sesion fallido", BaseTransientBottomBar.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        loginPasswd.setError("Tienes que escribir una contraseña");
                    }
                } else if (usuario.isEmpty()) {
                    loginUser.setError("Tienes que escribir un usuario");
                } else {
                    loginUser.setError("El usuario introducido no es valido");
                }
            }
        });

        botonRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUp.class));
            }
        });

    }


}