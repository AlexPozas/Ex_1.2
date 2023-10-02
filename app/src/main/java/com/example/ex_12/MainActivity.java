package com.example.ex_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView numero_aleatorio;
    Random r = new Random();
    int valorDado = r.nextInt(100)+1;
    int intentos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText campoTexto = (EditText) findViewById(R.id.mensajeeditTextText);
        numero_aleatorio= findViewById(R.id.numero);
        numero_aleatorio.setText(String.valueOf(valorDado));
        Toast noti= Toast.makeText(this,"G",Toast.LENGTH_SHORT);
        final Button button = findViewById(R.id.boton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int numerointr=Integer.parseInt(campoTexto.getText().toString());
                if (valorDado>numerointr){
                    noti.setText("El valor es mayor");

                    noti.show();
                    intentos+=1;
                    //Log.i("Valor ET", campoTexto.getText().toString());

                } else if (valorDado<numerointr) {
                    noti.setText("El valor es menor");
                    noti.show();
                    intentos+=1;

                }
                else {
                    intentos+=1;
                    noti.setText("Has acertat"+" Intentos = " +intentos);
                    noti.show();

                }


            }
        });
    }


}