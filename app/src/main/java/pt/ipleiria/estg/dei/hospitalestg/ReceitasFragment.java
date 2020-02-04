package pt.ipleiria.estg.dei.hospitalestg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.adaptadores.ReceitaAdaptor;
import pt.ipleiria.estg.dei.hospitalestg.listeners.ReceitaListener;
import pt.ipleiria.estg.dei.hospitalestg.modelo.Receita;
import pt.ipleiria.estg.dei.hospitalestg.modelo.SingletonGestorHospital;
import pt.ipleiria.estg.dei.hospitalestg.utils.ReceitaJsonParser;

public class ReceitasFragment extends Fragment implements ReceitaListener {

    private ReceitaAdaptor receitaAdaptor;
    private ListView lvReceita;
    private TextView tv_Prescricao, tv_DataReceita;
    private SearchView searchView;


    public ReceitasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receita, container, false);


        setHasOptionsMenu(true);


        lvReceita = view.findViewById(R.id.lvReceita);


        SingletonGestorHospital.getInstance(getContext()).setReceitaListener(this);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        //Pedido a api, vai buscar os livros todos
        SingletonGestorHospital.getInstance(getContext()).getAllReceitaAPI(getContext(), ReceitaJsonParser.isConnectionInternet(getContext()));
        if(searchView != null)
        {
            searchView.onActionViewCollapsed();

        }
    }

   /* @Override
    public void onRefreshReceita(ArrayList<Receita> receitas) {
        receitaAdaptor = new ReceitaAdaptor(getContext(), receitas);
        lvReceita.setAdapter(receitaAdaptor);

    }*/

    @Override
    public void onRefreshReceita(ArrayList<Receita> receitas) {
        receitaAdaptor = new ReceitaAdaptor(getContext(), receitas);
        lvReceita.setAdapter(receitaAdaptor);
    }

    @Override
    public void onUpdateReceita(Receita receitas, int operacao) {

    }



}
