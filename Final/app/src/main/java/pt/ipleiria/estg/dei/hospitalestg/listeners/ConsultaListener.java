package pt.ipleiria.estg.dei.hospitalestg.listeners;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.modelo.Consulta;

public interface ConsultaListener {
    void onRefreshConsulta(ArrayList<Consulta> consultas);
    void onUpdateConsulta(Consulta consulta, int operacao);
}
