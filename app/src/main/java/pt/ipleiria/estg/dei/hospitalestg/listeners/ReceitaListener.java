package pt.ipleiria.estg.dei.hospitalestg.listeners;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.modelo.Receita;

public interface ReceitaListener {
    void onRefreshReceita(ArrayList<Receita> receitas);
    void onUpdateReceita(Receita receitas, int operacao);
}

