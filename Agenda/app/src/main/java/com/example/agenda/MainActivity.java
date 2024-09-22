package com.example.agenda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.database.sqlite.SQLiteDatabase; // Banco de Dados
import android.database.Cursor; // Navegar entre os registros
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText et_nome,et_telefone;
    Button btn_gravar,btn_consultar,btn_fechar;

    SQLiteDatabase db=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_nome=(EditText) findViewById(R.id.et_nome);
        et_telefone=(EditText) findViewById(R.id.et_telefone);
        btn_gravar=(Button) findViewById(R.id.btn_gravar);
        btn_consultar=(Button) findViewById(R.id.btn_consultar);
        btn_fechar=(Button) findViewById(R.id.btn_fechar);

        criarAbrirDB();


    }

    public void criarAbrirDB(){
        try{
            db=openOrCreateDatabase("bancoAgenda",MODE_PRIVATE,null);
        }catch (Exception ex){
            msg("Erro ao abrir ou criar banco de dados");
        }
        try{
            db.execSQL("CREATE TABLE IF NOT EXISTS contatos(id INTEGER PRIMARY KEY,nome TEXT,fone Text);");
        }catch (Exception ex){
            msg("Erro ao criar tabela");
        }finally {
            msg("Tabela contatos criada com sucesso");
        }
    }
    
    public void abrir_tela_consulta(View v){
        Intent it_tela_consulta=new Intent(this,TelaConsulta.class);
        startActivity(it_tela_consulta);
    }
    public void fechar_tela(View v){
        this.finish();
    }
    public void msg(String txt){
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setMessage(txt);
        adb.setNeutralButton("OK",null);
        adb.show();
    }
}