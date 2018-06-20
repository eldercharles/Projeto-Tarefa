package com.example.elder.tarefas.Cadastro;

import android.widget.EditText;

import com.example.elder.tarefas.Modelo.Tarefas;
import com.example.elder.tarefas.R;

public class CadastraTarefas {


    private final EditText campoDescricao;



    CadastraTarefasActivity lista;



    public CadastraTarefas(CadastraTarefasActivity activity) {
        lista = activity;
        campoDescricao = activity.findViewById(R.id.cadastra_tarefas_descricao);
    }


    public Tarefas bancoUsuario() {
        Tarefas tarefas = new Tarefas();
        tarefas.setIdUsuario(lista.carregaIdUsuario());
        tarefas.setDescricao(campoDescricao.getText().toString());

        return tarefas;
    }
}
