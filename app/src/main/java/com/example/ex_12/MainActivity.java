package com.example.ex_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            final TextView helloTextView = (TextView) findViewById(R.id.text_view_id);
            helloTextView.setText(R.string.user_greeting);
            public void onClick(View v) {
                EditText campoTexto = (EditText) findViewById(R.id.editTextText);
                Log.d("Valor ET", campoTexto.getText().toString());


            }
        });
    }


}