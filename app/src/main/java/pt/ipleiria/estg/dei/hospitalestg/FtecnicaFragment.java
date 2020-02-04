package pt.ipleiria.estg.dei.hospitalestg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.adaptadores.FtecnicaAdaptor;
import pt.ipleiria.estg.dei.hospitalestg.listeners.FtecnicaListener;
import pt.ipleiria.estg.dei.hospitalestg.modelo.Ftecnica;
import pt.ipleiria.estg.dei.hospitalestg.modelo.SingletonGestorHospital;
import pt.ipleiria.estg.dei.hospitalestg.utils.FtecnicaJsonParser;

public class FtecnicaFragment extends Fragment implements FtecnicaListener {

    private ListView lvFTecnica;
    private FtecnicaAdaptor fichaTecnicaAdaptor;

    public FtecnicaFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ftecnica, container, false);
        setHasOptionsMenu(true);

        lvFTecnica = view.findViewById(R.id.lvFtecnica);



        SingletonGestorHospital.getInstance(getContext()).setFtecnicaListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        SingletonGestorHospital.getInstance(getContext()).getAllFtecnicasAPI(getContext(), FtecnicaJsonParser.isConnectionInternet(getContext()));

    }

    @Override
    public void onRefreshFtecnica(ArrayList<Ftecnica> fTecnica) {

        fichaTecnicaAdaptor = new FtecnicaAdaptor(getContext(), fTecnica);
        lvFTecnica.setAdapter(fichaTecnicaAdaptor);
    }

    @Override
    public void onUpdateFtecnica(Ftecnica ftecnica, int operacao) {

    }
}
