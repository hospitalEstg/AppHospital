package pt.ipleiria.estg.dei.hospitalestg.listeners;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.modelo.Pedido;

public interface PedidoListener {
    void onRefreshPedido(ArrayList<Pedido> pedido);
    void onUpdatePedido(Pedido pedido, int operacao);
}
