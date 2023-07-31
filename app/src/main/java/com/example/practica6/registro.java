package com.example.practica6;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class registro extends AppCompatActivity {

    EditText edit_1, edit_2;
    RadioButton mujer, hombre;
    Button btn4, btn5;
    SharedPreferences preferences;
    String nombre="",edad="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edit_1 = (EditText) findViewById(R.id.editnombre);
        edit_2 = (EditText) findViewById(R.id.editedad);
        mujer = (RadioButton) findViewById(R.id.mujer);
        hombre = (RadioButton) findViewById(R.id.hombre);
        btn4 = (Button) findViewById(R.id.guardardatos);
        btn5 = (Button) findViewById(R.id.regresar);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarCampos();

                Toast.makeText(getApplicationContext(), "Se guardo correctamente tus datos", Toast.LENGTH_SHORT).show();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Haz regresado a inicio", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void validarCampos() {
        String Nombre = "", Edad = "";
        Nombre = edit_1.getText().toString();
        Edad = edit_2.getText().toString();
        String error="";error+="";
        if (Nombre.equals("") || Edad.equals(""))
            error="--No puedes dejar campos vacios";
        if (!mujer.isChecked() && !hombre.isChecked())
            error+="--Selecciona tu genero";
        if(!error.equals(""))
            Toast.makeText(getApplicationContext(), "ERROR"+error, Toast.LENGTH_LONG).show();
        else {
            guardarDatos(nombre,edad,mujer.isChecked());
            Intent i= new Intent(getApplicationContext(),paginaprincipal.class);
            startActivity(i);
        }
    }
    private void guardarDatos(String name, String ege, boolean hombre){
        preferences=getSharedPreferences( "Registro", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("nombre",name);
        editor.putString("edad",ege);
        if(hombre)
            editor.putString("genero","masculino");
        else
            editor.putString("genero","femenino");
        editor.commit();
    }

}