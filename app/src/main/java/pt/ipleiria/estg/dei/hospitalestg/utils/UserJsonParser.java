package pt.ipleiria.estg.dei.hospitalestg.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.modelo.User;

public class UserJsonParser {
    public static ArrayList<User> parserJsonPedidos (JSONArray response, Context context) {

        ArrayList<User> pedidos = new ArrayList<>();
        try {
            for(int i=0; i< response.length(); i++){
                JSONObject user = (JSONObject)response.get(i);
                String username = user.getString("username");
                String password = user.getString("");
                String email = user.getString("email");


                User auxUser = new User (username, password, email);
                pedidos.add(auxUser);

            }

        }
        catch(JSONException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    public static User parserJsonPedidos (String response, Context context) {
        User auxUser = null;
        try {
            for(int i=0; i< response.length(); i++) {
                JSONObject user = new JSONObject(response);
                String username = user.getString("username");
                String password = user.getString("");
                String email = user.getString("email");

                auxUser = new User (username, password, email);
            }

        }
        catch(JSONException e) {
            e.printStackTrace();
        }
        return auxUser;


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
