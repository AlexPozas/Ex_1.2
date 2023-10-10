package com.example.ex_12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordActivity extends AppCompatActivity {
    static ArrayList<Record> records = new ArrayList<Record>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        //Record jug = new Record("alex",2);
        //Record jug2 = new Record("Lucas",5);
        //Log.i("INFO",jug.getNom());
        //records.add(jug);
        //records.add(jug2);

        TableRow.LayoutParams  params1=new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT,1.0f);
        TableRow.LayoutParams params2=new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableLayout tbl=(TableLayout) findViewById(R.id.tablerecord);

        TableRow row0=new TableRow(RecordActivity.this);
        TextView txt10=new TextView(RecordActivity.this);
        TextView txt20=new TextView(RecordActivity.this);

        //setting the text
        txt10.setText("Nom");
        txt20.setText("Intents");
        txt10.setLayoutParams(params1);
        txt20.setLayoutParams(params1);

        //the textviews have to be added to the row created
        row0.addView(txt10);
        row0.addView(txt20);
        row0.setLayoutParams(params2);
        tbl.addView(row0);
        for(int ctr=0;ctr<records.size();ctr++)
        {
            //Creating new tablerows and textviews
            TableRow row=new TableRow(RecordActivity.this);
            TextView txt1=new TextView(RecordActivity.this);
            TextView txt2=new TextView(RecordActivity.this);

            //setting the text
            txt1.setText(records.get(ctr).getNom());
            txt2.setText(String.valueOf(records.get(ctr).getIntents()));
            txt1.setLayoutParams(params1);
            txt2.setLayoutParams(params1);

            //the textviews have to be added to the row created
            row.addView(txt1);
            row.addView(txt2);
            row.setLayoutParams(params2);
            tbl.addView(row);
        }

        final Button button = findViewById(R.id.atras);
        button.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecordActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });



    }
}