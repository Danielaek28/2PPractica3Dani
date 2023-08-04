package com.example.practica6;

import android.app.Dialog;
import android.content.Context;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class dia {


    protected void onCreate(Context contexto ) {
        final Dialog dialogo = new Dialog(contexto);
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo.setCancelable(false);

        dialogo.setContentView(R.layout.dialogo);

        EditText editedad= (EditText) dialogo.findViewById(R.id.editedad);
        EditText editnombre =(EditText) dialogo.findViewById(R.id.editnombre);
        Button aceptar = (Button) dialogo.findViewById(R.id.guardardatos);
        Button cancelar= (Button) dialogo.findViewById(R.id.regresar);
        RadioButton mujer = (RadioButton) dialogo.findViewById(R.id.mujer);
        final RadioButton hombre = (RadioButton) dialogo.findViewById(R.id.hombre);
        editedad.setInputType (InputType.TYPE_CLASS_NUMBER );
        editnombre.setInputType (InputType.TYPE_CLASS_TEXT );

        aceptar.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           dialogo.dismiss();
                                       }
                                   });
            cancelar.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View v) {

                    dialogo.dismiss();

                    dialogo.show();
                }
            });

            }}