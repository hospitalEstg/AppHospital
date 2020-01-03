package pt.ipleiria.estg.dei.hospitalestg.listeners;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.modelo.Ftecnica;

public interface FtecnicaListener {

    void onRefreshFtecnica (ArrayList<Ftecnica> fTecnica);
    void onUpdateFtecnica (Ftecnica fTecnica, int operacao);
}
