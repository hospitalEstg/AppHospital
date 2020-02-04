package pt.ipleiria.estg.dei.hospitalestg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.adaptadores.PedidosAdaptor;
import pt.ipleiria.estg.dei.hospitalestg.listeners.ConsultaListener;
import pt.ipleiria.estg.dei.hospitalestg.listeners.PedidoListener;
import pt.ipleiria.estg.dei.hospitalestg.modelo.Consulta;
import pt.ipleiria.estg.dei.hospitalestg.modelo.Pedido;
import pt.ipleiria.estg.dei.hospitalestg.modelo.SingletonGestorHospital;
import pt.ipleiria.estg.dei.hospitalestg.utils.PedidoJsonParser;

public class PedidosFragment extends Fragment implements PedidoListener {
    public ListView lvPedidos;
    private SearchView searchView;
    private PedidosAdaptor pedidosAdaptor;

    PedidosFragment(){


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pedidos, container, false);
        setHasOptionsMenu(true);
        lvPedidos= view.findViewById(R.id.lvPedidos);


        SingletonGestorHospital.getInstance(getContext()).setPedidoListener(this);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        //Pedido a api, vai buscar os livros todos
        SingletonGestorHospital.getInstance(getContext()).getAllPedidosAPI(getContext(), PedidoJsonParser.isConnectionInternet(getContext()));
        if(searchView != null)
        {
            searchView.onActionViewCollapsed();

        }
    }

    @Override
    public void onRefreshPedido(ArrayList<Pedido> pedidos) {
        pedidosAdaptor = new PedidosAdaptor(getContext(), pedidos );
        lvPedidos.setAdapter(pedidosAdaptor);
    }

    @Override
    public void onUpdatePedido(Pedido Pedido, int operacao) {

    }
}
