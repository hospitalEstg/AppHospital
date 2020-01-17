package pt.ipleiria.estg.dei.hospitalestg.listeners;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.modelo.Pessoa;

public interface PessoaListener {
    void onRefreshPedido(ArrayList<Pessoa> pessoa);
    void onUpdatePedido(Pessoa user, int operacao);
}
