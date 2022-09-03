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


import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {
    private EditText txtHGT,txtHGTmeta, txtFator;
    private TextView Resultado;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

            setTheme(R.style.theme_Splash);
            Resultado = findViewById(R.id.Resultado);
            txtHGT = findViewById(R.id.txtHGT);
            txtHGTmeta = findViewById(R.id.txtHGTmeta);
            txtFator = findViewById(R.id.txtFator);

            try {
                     Thread.sleep(1000);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }

            findViewById(R.id.fechar).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                 checkExit();
                }
            });
    }

            // Código botão Voltar
            public boolean onKeyDown(int keyCode, KeyEvent event) {
                //Manuseie o botão Voltar aqui
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    checkExit();
                    return true;
                } else {
                    return super.onKeyDown(keyCode, event);
                }
            }
            public void checkExit()
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Deseja realmente sair?")
                        .setCancelable(false)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                //Ação tomada caso o usuário escolha opção Sim.
                            }
                        })
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
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

    public void CHO(View v){
        Intent intent = new Intent(getApplicationContext(),BolusAlimentar.class);
        startActivity(intent);
    }

           public void calcular(View view) {
                // verifica campos obrigatórios antes de realizar o calculo.
                if (txtHGT.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Informe Sua Glicemia!", Toast.LENGTH_SHORT).show();
                    txtHGT.requestFocus();
                } else if (txtHGTmeta.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Campo Glicemia Meta Vazio!", Toast.LENGTH_SHORT).show();
                    txtHGTmeta.requestFocus();
                } else if (txtFator.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Campo Fator de Correção Vazio!", Toast.LENGTH_SHORT).show();
                    txtFator.requestFocus();
                } else {
                        //executa a conversão e calcula o resultado final
                        double valor1 = Double.parseDouble(txtHGT.getText().toString());
                        double valor2 = Double.parseDouble(txtHGTmeta.getText().toString());
                        double valor3 = Double.parseDouble(txtFator.getText().toString());
                        double resultadoCalculo = (valor1 - valor2) / valor3;
                        String ResultadoFinal = String.format("%.2f", resultadoCalculo);
                        Resultado.setText(ResultadoFinal);
                }
            }

    }