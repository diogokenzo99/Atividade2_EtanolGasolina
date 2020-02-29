package com.example.atividade2_etanolgasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private TextView valorGasolinaTextView;
    private TextView valorEtanolTextView;
    private TextView resultTextView;

    private ImageView imageView;

    private double valorEtanol = 5.0;
    private double valorGasolina = 5.0;

    private void resultChange (){

        if(valorEtanol/valorGasolina >= 0.7){
            screenUpdate(R.drawable.gasolina, R.string.resultGasolina);
        }
        else{
            screenUpdate(R.drawable.cana, R.string.resultEtanol);
        }
    }

    private void screenUpdate(int image, int result){
        imageView.setImageResource(image);
        resultTextView.setText(result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorEtanolTextView = findViewById(R.id.valorEtanolTextView);
        valorGasolinaTextView = findViewById(R.id.valorGasolinaTextView);
        valorGasolinaTextView.setText(currencyFormat.format(valorGasolina));
        valorEtanolTextView.setText(currencyFormat.format(valorEtanol));

        resultTextView = findViewById(R.id.resultTextView);
        imageView = findViewById(R.id.imageView);

        SeekBar gasolinaSeekBar = findViewById(R.id.gasolinaSeekBar);
        gasolinaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                valorGasolina = i/10.;
                valorGasolinaTextView.setText(currencyFormat.format(valorGasolina));
                resultChange();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                resultChange();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar etanolSeekBar = findViewById(R.id.etanolSeekBar);
        etanolSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                valorEtanol = i/10.;
                valorEtanolTextView.setText(currencyFormat.format(valorEtanol));
                resultChange();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                resultChange();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
