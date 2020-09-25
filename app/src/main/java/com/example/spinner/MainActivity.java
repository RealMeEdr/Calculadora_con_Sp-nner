package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Se decclaran las variables con el típo que son:
    private Spinner Spinner1;
    private EditText Valor1, Valor2;
    private TextView Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //aqui se les da el valor de Find
        Spinner1 = (Spinner)findViewById(R.id.Spinner1);
        Valor1 = (EditText)findViewById(R.id.Edit_Text1);
        Valor2 = (EditText)findViewById(R.id.Edit_Text2);
        Result = (TextView)findViewById(R.id.Text_View1);

        //Se crea un arreglo para darle las operaciones que realizará al spinner
        String[] opciones = {"sumar","restar","multiplicar","dividir"};

        // Se crea un Array adapter con el tipo de variable que se utiliza, en este caso es un String
        // después dentro del parentes se indica a donde se va a utlizar ese adaptar android.R.layout, el tipo de Spinner y el nombre
        //del arreglo creado previamente.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_edr, opciones);
        Spinner1.setAdapter(adapter);
    }
    public void Calcular(View view) {
        try {
            String valor1_String = Valor1.getText().toString();
            String valor2_String = Valor2.getText().toString();

            int valor1_int = Integer.parseInt(valor1_String);
            int valor2_int = Integer.parseInt(valor2_String);

            String seleccion = Spinner1.getSelectedItem().toString();
                if (seleccion.equals("sumar")) {
                    int suma = valor1_int + valor2_int;
                    String resultado = String.valueOf(suma);
                    Result.setText(resultado);
                } else if (seleccion.equals("restar")) {
                    int resta = valor1_int - valor2_int;
                    String resultado = String.valueOf(resta);
                    Result.setText(resultado);
                } else if (seleccion.equals("multiplicar")) {
                    int multi = valor1_int * valor2_int;
                    String resultado = String.valueOf(multi);
                    Result.setText(resultado);
                } else if (seleccion.equals("dividir")) {
                    if (valor2_int != 0) {
                        int div = valor1_int / valor2_int;
                        String resultado = String.valueOf(div);
                        Result.setText(resultado);
                    } else {
                        Toast.makeText(this, "Debe poner un valor diferente a cero en el  cuadro de 'segundo valor'", Toast.LENGTH_LONG).show();
                    }
                }

        }catch (Exception mensaje){
            Toast.makeText(this, "Error en: "+mensaje.getMessage(), Toast.LENGTH_LONG).show();

        }
    }
}