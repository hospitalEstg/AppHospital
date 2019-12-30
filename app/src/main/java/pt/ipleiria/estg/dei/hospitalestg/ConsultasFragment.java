package pt.ipleiria.estg.dei.hospitalestg;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.adaptadores.ConsultaAdaptor;
import pt.ipleiria.estg.dei.hospitalestg.listeners.ConsultaListener;
import pt.ipleiria.estg.dei.hospitalestg.modelo.Consulta;
import pt.ipleiria.estg.dei.hospitalestg.modelo.SingletonGestorHospital;
import pt.ipleiria.estg.dei.hospitalestg.utils.ConsultaJsonParser;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultasFragment extends Fragment implements ConsultaListener {
    private static final int EDIT = 2;
    private static final int ADD = 1;
    private ConsultaAdaptor consultaAdaptor;
    private ListView lvConsultas;
    private FloatingActionButton fab;
    private TextView tv_medico, tv_motivo, tv_data, tv_hora;
    private SearchView searchView;


    public ConsultasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consultas, container, false);


        setHasOptionsMenu(true);


        lvConsultas = view.findViewById(R.id.lvConsultas);
        fab = view.findViewById(R.id.fab);


        SingletonGestorHospital.getInstance(getContext()).setConsultaListener(this);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        //Pedido a api, vai buscar os livros todos
        SingletonGestorHospital.getInstance(getContext()).getAllConsultasAPI(getContext(), ConsultaJsonParser.isConnectionInternet(getContext()));
        if(searchView != null)
        {
            searchView.onActionViewCollapsed();

        }
    }

    @Override
    public void onRefreshConsulta(ArrayList<Consulta> consultas) {
        consultaAdaptor = new ConsultaAdaptor(getContext(), consultas);
        lvConsultas.setAdapter(consultaAdaptor);

    }

    @Override
    public void onUpdateConsulta(Consulta consulta, int operacao) {

    }
}




