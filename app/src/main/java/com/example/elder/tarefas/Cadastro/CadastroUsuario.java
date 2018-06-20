package com.example.elder.tarefas.Cadastro;
import android.widget.EditText;

import com.example.elder.tarefas.Modelo.Usuario;
import com.example.elder.tarefas.R;

/**
 * Criado por Elder em 08/06/2018.
 */

public class CadastroUsuario {

    private final EditText campoUsuario;
    private final EditText campoSenha;



    public CadastroUsuario(CadastroUsuarioActivity activity) {
        campoUsuario = activity.findViewById(R.id.cadastro_usuario);
        campoSenha = activity.findViewById(R.id.cadastro_senha);
    }




    public Usuario bancoUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUsuario(campoUsuario.getText().toString());
        usuario.setSenha(campoSenha.getText().toString());
        return usuario;
    }
}
