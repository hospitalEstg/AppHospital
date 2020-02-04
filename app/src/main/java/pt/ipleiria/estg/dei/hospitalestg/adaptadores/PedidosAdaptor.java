package pt.ipleiria.estg.dei.hospitalestg.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.R;
import pt.ipleiria.estg.dei.hospitalestg.modelo.Consulta;
import pt.ipleiria.estg.dei.hospitalestg.modelo.Pedido;

public class PedidosAdaptor extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Pedido> pedidos;

    public PedidosAdaptor(Context context, ArrayList<Pedido> pedidos) {
        this.context = context;
        this.pedidos = pedidos;
    }
    @Override
    public int getCount() {
        return pedidos.size();
    }

    @Override
    public Object getItem(int position) {
        return pedidos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(layoutInflater == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(view == null){
            view = layoutInflater.inflate(R.layout.item_pedidos, null);
        }

        ViewHolderPedido viewHolder = (ViewHolderPedido) view.getTag();

        if(viewHolder == null){
            viewHolder = new ViewHolderPedido(view);
            view.setTag(viewHolder);
        }

        //viewHolderLista(view);
        viewHolder.update(position);

        return view;
    }



    private class ViewHolderPedido {
        private TextView tvUrgente, tvDescricao;

        public ViewHolderPedido (View view) {
            tvUrgente = view.findViewById(R.id.tv_urgente);
            tvDescricao = view.findViewById(R.id.tv_descricao);
        }


        public void update(int position) {
            Pedido pedido = pedidos.get(position);
            tvUrgente.setText(String.valueOf(pedido.getUrgente()));
            tvDescricao.setText(pedido.getDescricao());
        }
    }


}

