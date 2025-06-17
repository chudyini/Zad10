package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity{

    EditText daneWlasciciela;
    TextView gatuneczek;
    Spinner mySimpleSpinner;
    TextView ileLat;
    TextView aktualnyWiek;
    SeekBar wiekSeekBar;
    EditText celWizyty;
    TimePicker timePickerr;
    Button przycisk;
    TextView wyswietlanko;
    int selectedItemPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daneWlasciciela =findViewById(R.id.daneWlasciciela);
        gatuneczek =findViewById(R.id.gatuneczek);
        mySimpleSpinner =findViewById(R.id.mySimpleSpinner);
        ileLat =findViewById(R.id.ileLat);
        wiekSeekBar =findViewById(R.id.wiekSeekBar);
        celWizyty =findViewById(R.id.celWizyty);
        timePickerr = findViewById(R.id.timePickerr);
        przycisk = findViewById(R.id.przycisk);
        timePickerr.setHour(16);
        timePickerr.setMinute(0);
        wyswietlanko = findViewById(R.id.wyswietlanko);



        wiekSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    ileLat.setText("" + progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_options_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySimpleSpinner.setAdapter(adapter);

        mySimpleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItemPosition = position;
                String selectUnit;
                selectUnit = parent.getItemAtPosition(position).toString();
                ileLat.setText("0");
                if(selectUnit == "Pies"){
                    wiekSeekBar.setMax(18);
                } else if (selectUnit == "Kot") {
                    wiekSeekBar.setMax(20);

                } else if (selectUnit == "Swinka Morska") {
                    wiekSeekBar.setMax(9);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        wiekSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ileLat.setText(wiekSeekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String daneWlascicielaText = daneWlasciciela.getText().toString().trim();
                wyswietlanko.setText(daneWlascicielaText+","+mySimpleSpinner.getItemAtPosition(selectedItemPosition)+","+ileLat.getText()+","+celWizyty.getText()+","+timePickerr.getHour()+":"+timePickerr.getMinute());

            }
        });





    }
}