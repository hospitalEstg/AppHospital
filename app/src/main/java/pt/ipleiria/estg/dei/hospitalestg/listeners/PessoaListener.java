package pt.ipleiria.estg.dei.hospitalestg.listeners;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.modelo.Pessoa;

public interface PessoaListener {
    void onRefreshPessoa(ArrayList<Pessoa> pessoa);
    void onUpdatePessoa(Pessoa user, int operacao);
}
