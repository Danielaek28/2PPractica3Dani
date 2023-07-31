package com.example.practica6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class paginaprincipal extends AppCompatActivity {

    TextView bienvenida;
    SharedPreferences preferences;
    String nombre = "", edad = "", masculino = "";
    ImageView caricatura, accion, terror;
    Button btn4, btn5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paginaprincipal);
        bienvenida = (TextView) findViewById(R.id.bien);
        caricatura = (ImageView) findViewById(R.id.caricatura);
        accion = (ImageView) findViewById(R.id.accion);
        terror = (ImageView) findViewById(R.id.terror);
        btn4=(Button) findViewById(R.id.salir2);
        btn5=(Button) findViewById(R.id.registro2);

        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Toast.makeText(getApplicationContext(), "Hiciste click en registro", Toast.LENGTH_SHORT).show();
                Intent  i = new Intent(getApplicationContext(), registro.class);
                startActivity(i);
            }

        });

        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Toast.makeText(getApplicationContext(), "Saliste de la aplicacion", Toast.LENGTH_SHORT).show();
                finish();
            }

        });
        LeerDatos();
        String cadena = "";
        if (masculino.equals("masculino"))
            cadena = "Bienvenido";
        else
            cadena = "Bienvenida";

        cadena += nombre + "Por tu edad:" + edad + "Tienes acceso a todo";

        bienvenida.setText(cadena);
        Integer age = Integer.valueOf(edad);
        if (age<12) {
            Toast.makeText(getApplicationContext(), "Eres menor de 12 solo tienes acceso a caricaturas", Toast.LENGTH_SHORT).show();
            accion.setVisibility(View.INVISIBLE);
            terror.setVisibility(View.INVISIBLE);

        }
        if (age>12&&age<18) {
            Toast.makeText(getApplicationContext(), "Eres menor de edad solo tienes acceso a caricaturas y accion", Toast.LENGTH_SHORT).show();
            terror.setVisibility(View.INVISIBLE);
        }
        if (age>18) {
            Toast.makeText(getApplicationContext(), "Eres mayor de edad tienes acceso a todas las categorias", Toast.LENGTH_SHORT).show();
        }

    }

    private void LeerDatos() {
        preferences = getSharedPreferences("Registro", Context.MODE_PRIVATE);
        nombre = preferences.getString("nombre", "No se encuentra");
        edad = preferences.getString("edad", "No se encuentra");
        masculino = preferences.getString("genero", "No se encuentra");
    }


}
