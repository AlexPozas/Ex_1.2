package com.example.ex_12;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
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
    TextView hist;
    Random r = new Random();
    String histo;
    int intentos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int valorDado = r.nextInt(100)+1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText campoTexto = (EditText) findViewById(R.id.mensajeeditTextText);
        numero_aleatorio= findViewById(R.id.numero);
        hist= findViewById(R.id.historial);
        hist.setText(" ");

        numero_aleatorio.setText(String.valueOf(valorDado));
        Toast noti= Toast.makeText(this,"G",Toast.LENGTH_SHORT);
        final Button button = findViewById(R.id.boton);
        final Button ran = findViewById(R.id.ranking);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
        AlertDialog dialog = builder.create();
        AlertDialog dialog2 = builder2.create();

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int numerointr=Integer.parseInt(campoTexto.getText().toString());
                if (valorDado>numerointr){
                    noti.setText("El valor es mayor");
                    histo+="El valor es mayor\n";
                    hist.setText(histo);
                    noti.show();
                    intentos+=1;

                } else if (valorDado<numerointr) {
                    noti.setText("El valor es menor");
                    histo+="El valor es menor\n";
                    hist.setText(histo);
                    noti.show();
                    intentos+=1;
                }
                else {
                    intentos+=1;
                    noti.setText("Has acertat"+" Intentos = " +intentos);
                    builder.setMessage("Your score: "+ intentos+" points").setTitle("Congratulation!!");
                    noti.show();
                    final EditText input = new EditText(MainActivity.this);
                    builder2.setMessage("Introdueix el teu nom per guardar el regord");
                    builder2.setView(input);
                    Intent intent = new Intent(MainActivity.this,RecordActivity.class);
                    String nom= input.getText().toString();
                    builder2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id) {

                            Record jug = new Record(nom,intentos);
                            RecordActivity.records.add(jug);
                            startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            builder2.show();

                        }});
                    builder.show();
                }
            }


        });
        ran.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RecordActivity.class);
                startActivity(intent);

            }
        });
    }
}