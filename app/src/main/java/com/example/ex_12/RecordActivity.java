package com.example.ex_12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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


        TableRow.LayoutParams  params1=new TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT,1.0f);
        TableRow.LayoutParams params2=new TableRow.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        TableLayout tbl=(TableLayout) findViewById(R.id.tablerecord);
        for(int ctr=0;ctr<records.size();ctr++)
        {
            //Creating new tablerows and textviews
            TableRow row=new TableRow(this);
            TextView txt1=new TextView(this);
            TextView txt2=new TextView(this);
            TextView txt3=new TextView(this);
            //setting the text
            txt1.setText(records.get(ctr).getNom());
            txt2.setText(records.get(ctr).getIntents());
            txt1.setLayoutParams(params1);
            txt2.setLayoutParams(params1);

            //the textviews have to be added to the row created
            row.addView(txt1);
            row.addView(txt2);

            row.setLayoutParams(params2);
            tbl.addView(row);
        }


    }
}