package com.example.parada_cabrera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsuario, etPassword;
    private SharedPreferences misPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        referenciar();
        misPreferencias = getSharedPreferences("tienda app", MODE_PRIVATE);

        //VERIFICAR SI ESTA LOGUEADO

        if (misPreferencias.getBoolean("logueado", false)==true){
            Intent miIntent = new Intent(this, MainActivity.class);
            startActivity(miIntent);
            finish();
        }
    }
    private void referenciar(){
        etUsuario = findViewById(R.id.et_user_login);
        etPassword = findViewById(R.id.et_user_contraseña);
    }
    public void clickIniciarSesion(View view){
        String PASS = "123456";
        String USER = "cristian";

        String passUser = etPassword.getText().toString();
        String userUser = etUsuario.getText().toString();

        if (PASS.equals(passUser) && USER.equals(userUser)) {

            SharedPreferences.Editor myEditor = misPreferencias.edit();
            myEditor.putBoolean("logueado", true);
            myEditor.apply();

            Intent miIntent = new Intent(this, MainActivity.class);
            startActivity(miIntent);
            finish();
        }else{
            Toast.makeText(this, "credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }
    }
}