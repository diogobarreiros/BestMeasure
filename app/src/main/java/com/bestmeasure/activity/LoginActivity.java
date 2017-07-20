package com.bestmeasure.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Classe responsável por carregar a página de login.
 * @author diogo.barreiros
 *
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button botao = (Button)findViewById(R.id.botao);

        botao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv =(TextView)findViewById(R.id.erroLogin);
                EditText nome = (EditText)findViewById(R.id.login);
                EditText senha = (EditText)findViewById(R.id.senha);
                if(nome.getEditableText().toString().equals("teste") &&
                        senha.getEditableText().toString().equals("teste")){
                    Intent menuMesas = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(menuMesas);
                    finish();
                }else{
                    tv.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
