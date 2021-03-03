package com.example.calculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarGorjeta;
    private TextView textGorjetaPorcentagem;
    private TextView textGorjetaCalculo;
    private TextView textFinal;
    private EditText editValor;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);
        textGorjetaPorcentagem = findViewById(R.id.textGorjeta);
        textGorjetaCalculo = findViewById(R.id.textGorjetaCalculo);
        textFinal = findViewById(R.id.textTotal);
        editValor = findViewById(R.id.editValorConta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textGorjetaPorcentagem.setText(Math.round(porcentagem) + "%");

                calcularGorjeta();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void calcularGorjeta() {

        String valorRecuperado = editValor.getText().toString();

        if (valorRecuperado == null || valorRecuperado.equals("")) {

            Toast.makeText(getApplicationContext(), "Digite um valor", Toast.LENGTH_SHORT).show();

        } else {

            double valorDigitado = Double.parseDouble(valorRecuperado);
            double valorCalculado = valorDigitado*(porcentagem/100);
            textGorjetaCalculo.setText("R$" + (valorCalculado));

            double valorFinal = valorDigitado + valorCalculado;
            textFinal.setText("R$" + (valorFinal));

        }
    }
}
