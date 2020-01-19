package pt.ipleiria.estg.dei.hospitalestg.listeners;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.modelo.User;

public interface UserListener {
    void onRefreshPedido(ArrayList<User> user);
    void onUpdatePedido(User user, int operacao);
}
