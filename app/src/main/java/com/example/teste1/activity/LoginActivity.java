package com.example.teste1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teste1.R;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class LoginActivity extends AppCompatActivity {

    private Button btnEntrar;
    private EditText nome;
    private EditText codPais;
    private EditText telefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnEntrar = (Button) findViewById(R.id.bt_EntrarId);
        nome = (EditText) findViewById(R.id.edit_nomeId);
        codPais = (EditText) findViewById(R.id.edit_codAreaId);
        telefone = (EditText) findViewById(R.id.edit_TeleId);

        //Mascara Pais
        SimpleMaskFormatter mascodPais = new SimpleMaskFormatter("+NN");
        MaskTextWatcher mascaraPais = new MaskTextWatcher(codPais, mascodPais);
        codPais.addTextChangedListener(mascaraPais);

        // Mascara Telefone
        SimpleMaskFormatter masTelefone = new SimpleMaskFormatter("(NN) N NNNN-NNNN");
        MaskTextWatcher mascaraTelefone = new MaskTextWatcher(telefone, masTelefone);
        telefone.addTextChangedListener(mascaraTelefone);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // mudando de tela
                startActivity(new Intent(LoginActivity.this, MainActivity.class));

            }
        });
    }
}
