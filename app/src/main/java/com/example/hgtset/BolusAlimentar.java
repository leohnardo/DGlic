package com.example.hgtset;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BolusAlimentar extends AppCompatActivity  {
    private EditText txtCHO, txtRCI;
    private TextView ResultadoCHO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolus_alimentar);
        txtCHO = findViewById(R.id.txtCHO);
        txtRCI = findViewById(R.id.txtRCI);

        ResultadoCHO = findViewById(R.id.ResultadoCHO);
    }
    public void calcCHO(View view) {
        // verifica campos obrigatórios antes de realizar o calculo.
        if (txtCHO.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Informe Sua Glicemia!", Toast.LENGTH_SHORT).show();
            txtCHO.requestFocus();
        } else if (txtRCI.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "Informe o Valor de referência!", Toast.LENGTH_SHORT).show();
            txtRCI.requestFocus();
        } else {
            //executa a conversão e calcula o resultado final
            double valor1 = Double.parseDouble(txtCHO.getText().toString());
            double valor2 = Double.parseDouble(txtRCI.getText().toString());
            double resultadoCalculo = (valor1) / (valor2);
            //double resultadoCalculo = (valor1) * (0.0666666666666667) ;
            String ResultadoFinal = String.format("%.2f", resultadoCalculo);
            ResultadoCHO.setText(ResultadoFinal);
        }
    }
    public void sobreautor (View view)
    {
        try
        {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://linktr.ee/lleonardofreitas"));
            startActivity(browserIntent);
        }
        finally
        {
        }
    }

    public void CalculoHGT(View v){
        finish();
    }

    // Código botão Voltar
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Manuseie o botão Voltar aqui
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}