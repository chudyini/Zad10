package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

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

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daneWlasciciela =findViewById(R.id.daneWlasciciela);
        gatuneczek =findViewById(R.id.gatuneczek);
        mySimpleSpinner =findViewById(R.id.mySimpleSpinner);
        ileLat =findViewById(R.id.ileLat);
        aktualnyWiek =findViewById(R.id.ileLat);
        wiekSeekBar =findViewById(R.id.wiekSeekBar);
        celWizyty =findViewById(R.id.celWizyty);
        timePickerr = findViewById(R.id.timePickerr);
        przycisk = findViewById(R.id.przycisk);
        timePickerr.setHour(16);
        timePickerr.setMinute(0);

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





    }
}