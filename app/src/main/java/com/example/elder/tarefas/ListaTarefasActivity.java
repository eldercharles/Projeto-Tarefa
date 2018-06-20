package com.example.elder.tarefas;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.elder.tarefas.Cadastro.CadastraTarefasActivity;
import com.example.elder.tarefas.DAO.DAOTarefas;
import com.example.elder.tarefas.Modelo.Tarefas;

import java.util.List;

/**
 * Criado por Elder em 08/06/2018.
 */

public class ListaTarefasActivity extends AppCompatActivity {

    public int carregaIdUsuario() {
        SharedPreferences preferencias = getSharedPreferences("preferencias_usuario", Activity.MODE_PRIVATE);
        return preferencias.getInt("id_usuario", 0);
    }

    private void carregaLista() {
        DAOTarefas dao = new DAOTarefas(this);
        List<Tarefas> tarefas = dao.buscaTarefas(Integer.toString(carregaIdUsuario()));
        //dao.close();

        ListView listaTarefas = findViewById(R.id.lista_tarefas);
        ArrayAdapter<Tarefas> adapter = new ArrayAdapter<Tarefas>(this,  android.R.layout.simple_list_item_1, tarefas);
        listaTarefas.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tarefas);

        carregaLista();
    }

    public void criarTarefa(View view) {
        Intent vaiProCadastro = new Intent(ListaTarefasActivity.this, CadastraTarefasActivity.class);
        startActivity(vaiProCadastro);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();

    }

}
