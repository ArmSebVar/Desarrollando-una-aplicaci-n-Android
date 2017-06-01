package com.example.equipo.androidsemana2coursera;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.content.Intent;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et1,et2,et3,et4,et5;
    private Button boton;
    private int año1, mes1, dia1, año2, mes2, dia2;
    static final int Fecha_id = 0;
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        año2 = calendar.get(Calendar.YEAR);
        mes2 = calendar.get(Calendar.MONTH);
        dia2 = calendar.get(Calendar.DAY_OF_MONTH);

        et1 = (EditText)findViewById(R.id.campo_nombre);
        et2 = (EditText)findViewById(R.id.campo_telefono);
        et3 = (EditText)findViewById(R.id.campo_correo);
        et4 = (EditText)findViewById(R.id.campo_descripcion);
        et5 = (EditText)findViewById(R.id.campo_fecha);
        boton = (Button) findViewById(R.id.boton_aceptar);
        boton.setOnClickListener(this);

        et5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            showDialog(Fecha_id);
            }
        });}

        private void colocar_fecha() {
            et5.setText((mes1 + 1) + "-" + dia1 + "-" + año1+" ");
        }
        private DatePickerDialog.OnDateSetListener mDateSetListener =
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        año1 = year;
                        mes1 = monthOfYear;
                        dia1 = dayOfMonth;
                        colocar_fecha();

                    }

                };
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case Fecha_id:
                return new DatePickerDialog(this, mDateSetListener, año2, mes2, dia2);


        }


        return null;


    }


    @Override
    public void onClick(View v) {
        Intent intent;

        intent = new Intent(this,DetalleContacto.class);
        String nombre = et1.getText().toString();
        String telefono = et2.getText().toString();
        String correo = et3.getText().toString();
        String descripción = et4.getText().toString();
        String fecha=et5.getText().toString();

        intent.putExtra("nombre",nombre);
        intent.putExtra("telefono",telefono);
        intent.putExtra("correo",correo);
        intent.putExtra("descripción",descripción);
        intent.putExtra("fecha",fecha);

        startActivity(intent);
    }
}








