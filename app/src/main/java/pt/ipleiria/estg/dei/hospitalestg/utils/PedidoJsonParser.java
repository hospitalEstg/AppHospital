package pt.ipleiria.estg.dei.hospitalestg.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.modelo.Pedido;

public class PedidoJsonParser {

    public static ArrayList<Pedido> parserJsonPedidos (JSONArray response, Context context) {

            ArrayList<Pedido> pedidos = new ArrayList<>();
            try {
                for(int i=0; i< response.length(); i++){
                    JSONObject pedido = (JSONObject)response.get(i);
                    int idPedido = pedido.getInt("idMarcacao_Consulta");
                    String descricao = pedido.getString("Descricao");
                    Boolean urgente = pedido.getBoolean("Urgente");

                    Pedido auxPedido = new Pedido (idPedido, descricao, urgente);
                    pedidos.add(auxPedido);

                }

            }
            catch(JSONException e) {
                e.printStackTrace();
            }
        return pedidos;
    }

    public static Pedido parserJsonPedidos (String response, Context context) {
            Pedido auxPedido = null;
            try {
                for(int i=0; i< response.length(); i++) {
                    JSONObject pedido = new JSONObject(response);
                    int idPedido = pedido.getInt("idMarcacao_Consulta");
                    String descricao = pedido.getString("Descricao");
                    Boolean urgente = pedido.getBoolean("Urgente");

                    auxPedido = new Pedido (idPedido, descricao, urgente);
                }

            }
            catch(JSONException e) {
                e.printStackTrace();
            }
        return auxPedido;


    }

    public static String parserJsonLogin(String response, Context context) {
        String token =null;

        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject pedido = new JSONObject(response);

                token = pedido.getString("token");



            }
        }
        catch(JSONException e) {
            e.printStackTrace();
        }
        return token;

    }

    public static boolean isConnectionInternet(Context context) {
        ConnectivityManager cm =(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cm.getActiveNetworkInfo();

        return nInfo!=null && nInfo.isConnected();
    }

}
