package com.example.efcs.ejercicio5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int cantidad;
    Button buttonMas, buttonMenos, buttonPedir;
    EditText nombre;
    CheckBox crema, chocolate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textViewCantidad);
        buttonMas = (Button) findViewById(R.id.buttonMas);
        buttonMenos = (Button) findViewById(R.id.buttonMenos);
        buttonPedir = (Button) findViewById(R.id.buttonPedir);

        nombre = (EditText) findViewById(R.id.editTextNombre);
        crema = (CheckBox) findViewById(R.id.checkBoxCrema);
        chocolate = (CheckBox) findViewById(R.id.checkBoxChocolate);

        buttonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementar(v);
            }
        });

        buttonMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementar(v);
            }
        });

        buttonPedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"Nombre: "+nombre.getText().toString()+"\n" +
                        "Añadir crema: "+(crema.isChecked() ? "Si" : "No")+"\n" +
                        "Añadir chocolate: " + (chocolate.isChecked() ? "Si" : "No") + "\n" +
                        "Cantidad: "+textView.getText().toString()+"\n" +
                        "Total : 24€ \n" +
                        "Gracias!",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }


    public void incrementar(View view){
        cantidad = Integer.parseInt(textView.getText().toString());
        if(cantidad == 100){
            return;
        }
        cantidad = cantidad + 1;
        mostrarCantidad(cantidad);
    }

    public void decrementar(View view){
        cantidad = Integer.parseInt(textView.getText().toString());
        if(cantidad == 100){
            return;
        }
        cantidad = cantidad - 1;
        mostrarCantidad(cantidad);
    }

    private void mostrarCantidad(int numeroCafes){
        textView.setText(String.valueOf(numeroCafes));
    }
}
