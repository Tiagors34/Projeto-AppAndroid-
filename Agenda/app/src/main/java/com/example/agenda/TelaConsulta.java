package com.example.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaConsulta extends AppCompatActivity {

    EditText et_nome,et_telefone;
    Button btn_anterior,btn_proximo,btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_consulta);

        et_nome=(EditText) findViewById(R.id.et_nome_consulta);
        et_telefone=(EditText) findViewById(R.id.et_telefone_consulta);
        btn_anterior=(Button) findViewById(R.id.btn_anterior);
        btn_proximo=(Button) findViewById(R.id.btn_proximo);
        btn_voltar=(Button) findViewById(R.id.btn_voltar_consulta);
    }

    public void fechar_tela(View v){
        this.finish();
    }
}