package com.example.elder.tarefas.Cadastro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.elder.tarefas.Cadastro.CadastroUsuario;
import com.example.elder.tarefas.DAO.DAOUsuarios;
import com.example.elder.tarefas.Modelo.Usuario;
import com.example.elder.tarefas.R;

/**
 * Criado por Elder em 08/06/2018.
 */

public class CadastroUsuarioActivity extends AppCompatActivity {

    private CadastroUsuario cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        cadastro = new CadastroUsuario(this);
    }

    public void cadastre(View view) {

        EditText campoUsr = findViewById(R.id.cadastro_usuario);
        EditText senha = findViewById(R.id.cadastro_senha);
        EditText confirmaSenha = findViewById(R.id.cadastro_confirma_senha);

        String validaUsuario = campoUsr.getText().toString();
        String validaSenha = senha.getText().toString();
        String validaSenha2 = confirmaSenha.getText().toString();

        DAOUsuarios daoUsuarios = new DAOUsuarios(this);
        int verifica = daoUsuarios.verificaSeUsuarioExiste(validaUsuario);

        if (verifica != 0) {
            campoUsr.setError("Usuário já está cadastrado!");
            return;
        } else if (TextUtils.isEmpty(validaUsuario)) {
            campoUsr.setError("Usuário não pode ser vazio!");
            return;

        } else if (TextUtils.isEmpty(validaSenha)) {
            senha.setError("Senha não pode ser vazia!");
            return;

        } else if (TextUtils.isEmpty(validaSenha2)) {
            confirmaSenha.setError("Senha não pode ser vazia!");
            return;

        } else if (TextUtils.isEmpty(validaSenha) && TextUtils.isEmpty(validaSenha2)) {
            senha.setError("Senha não pode estar vazia!");
            confirmaSenha.setError("Senha não pode estar vazia!");
            return;

        } else if (validaSenha.equals(validaSenha2)) {
            Usuario usuario = cadastro.bancoUsuario();
            DAOUsuarios dao = new DAOUsuarios(this);
            dao.cadastra(usuario);
            //dao.close();
            Toast.makeText(this, "Usuário Cadastrado com exito!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "ish!", Toast.LENGTH_SHORT).show();
            senha.setError("Senhas não coincidem!");
            confirmaSenha.setError("Senhas não coincidem!");
            return;
        }
    }
}
