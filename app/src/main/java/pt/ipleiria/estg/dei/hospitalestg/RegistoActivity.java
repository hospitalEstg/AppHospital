package pt.ipleiria.estg.dei.hospitalestg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pt.ipleiria.estg.dei.hospitalestg.modelo.SingletonGestorHospital;
import pt.ipleiria.estg.dei.hospitalestg.modelo.User;
import pt.ipleiria.estg.dei.hospitalestg.modelo.Pessoa;
import pt.ipleiria.estg.dei.hospitalestg.utils.PedidoJsonParser;

public class RegistoActivity extends AppCompatActivity {

    private User user;
    private Pessoa pessoa;
    private EditText et_username, et_password, et_email, et_nome, et_nrutente, et_nrcivil,et_morada, et_tipoutilizador, et_datanascimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registo);

        setTitle("Registar");

        et_nome = findViewById(R.id.et_RNome);
        et_password = findViewById(R.id.et_RPassword);
        et_email = findViewById(R.id.et_REmail);
        et_username = findViewById(R.id.et_RUsername);
        et_nrutente = findViewById(R.id.et_RNrUtente);
        et_nrcivil = findViewById(R.id.et_RNrCivil);
        et_morada = findViewById(R.id.et_RMorada);
        et_tipoutilizador = findViewById(R.id.et_RTipoUtilizador);
        et_datanascimento = findViewById(R.id.et_RDataNascimento);



    }

    public void onClickRegistar(View view) {
        if (!PedidoJsonParser.isConnectionInternet(getApplicationContext()))
            Toast.makeText(getApplicationContext(), "Internet not available", Toast.LENGTH_SHORT).show();
        else {
            if (et_nome.getText().length()!=0 && et_datanascimento.getText().length()!=0 && et_morada.getText().length()!=0 && et_nrutente.getText().length()!=0 && et_nrcivil.getText().length()!=0 && et_tipoutilizador.getText().length()!=0) {
                if (pessoa == null) {
                    SingletonGestorHospital.getInstance(getApplicationContext()).adicionarPessoaAPI(adicionarPessoa(), getApplicationContext());
                    setResult(Activity.RESULT_OK);
                    finish();
                }
            }
        }

    }

    /*private User adicionarUser(){

        String username = et_username.getText().toString();
        String email = et_email.getText().toString();
        String password = et_password.getText().toString();

        User user = new User(username, email, password);

        return user;
    }*/
    private Pessoa adicionarPessoa(){

        String nome = et_nome.getText().toString();
        String datanascimento = et_datanascimento.getText().toString();
        String morada = et_morada.getText().toString();
        String numutentesaude = et_nrutente.getText().toString();
        String numidcivil = et_nrcivil.getText().toString();
        String tipoutilizador = et_tipoutilizador.getText().toString();

        Pessoa pessoa = new Pessoa(nome, datanascimento, morada, numutentesaude, numidcivil, tipoutilizador);

        return pessoa;
    }

}
