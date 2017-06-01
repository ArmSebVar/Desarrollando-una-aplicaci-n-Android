package com.example.equipo.androidsemana2coursera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {
    private TextView texto,texto2,texto3,texto4,texto5;
    private Button boton2;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
        
        texto = (TextView)findViewById(R.id.text_View1);
        texto2 = (TextView)findViewById(R.id.text_View2);
        texto3 = (TextView)findViewById(R.id.text_View3);
        texto4 = (TextView)findViewById(R.id.text_View4);
        texto5 = (TextView)findViewById(R.id.text_View5);

        boton2 = (Button)findViewById(R.id.boton_cerrar);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        recogerExtras();


    }

    private void recogerExtras() {
        Bundle extras = getIntent().getExtras();


        String v=extras.getString("descripción");
        String c=extras.getString("correo");
        String s=extras.getString("nombre");
        String x=extras.getString("telefono");
        String z=extras.getString("fecha");

        texto4.setText("Descripción: " + v);
        texto3.setText("Correo: " + c);
        texto2.setText("Telefono."+x);
        texto.setText("Nombre: " + s);
        texto5.setText("Fecha: " + z);

    }


}