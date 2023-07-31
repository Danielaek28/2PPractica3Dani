package com.example.practica6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.registro);
        btn2 = (Button) findViewById(R.id.pruebagratis);
        btn3 = (Button) findViewById(R.id.salir);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hiciste click en registro", Toast.LENGTH_SHORT).show();
                Intent i= new Intent(getApplicationContext(),registro.class);
                startActivity(i);

            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hiciste click en prueba Gratis", Toast.LENGTH_SHORT).show();
                Intent i= new Intent(getApplicationContext(),paginaprincipal.class);
                startActivity(i);
            }

        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Saliste de la aplicación", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}



