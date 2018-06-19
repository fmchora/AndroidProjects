package com.example.fmcho.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView myListView;

    public void generateTable(int i)
    {
        ArrayList<String> timesTable = new ArrayList<String>();
        for(int j = 1; j <= 10; j++)
        {
            timesTable.add( Integer.toString(j* i));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTable);
        myListView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView = findViewById(R.id.NameList);
        SeekBar seekBar = findViewById(R.id.myseekBar);

        int max = 20;
        int startingPosition = 10;

        generateTable(startingPosition);
        seekBar.setMax(max);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int number;

                if(progress < min)
                {
                    number = min;
                    seekBar.setProgress(min);
                }
                else
                {
                    number = progress;
                }

                Log.i("SeekBar Value", Integer.toString(number));

                generateTable(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
