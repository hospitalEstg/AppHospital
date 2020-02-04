package pt.ipleiria.estg.dei.hospitalestg.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.modelo.Ftecnica;

public class FtecnicaJsonParser {

    public static ArrayList<Ftecnica> parserJsonFtecnica (JSONArray response, Context context) {

        ArrayList<Ftecnica> ftecnicas = new ArrayList<>();

        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject fTecnica = (JSONObject)response.get(i);
                int idFtecnica=fTecnica.getInt("idFichaClinica");
                String Ficheiro = fTecnica.getString("Ficheiro");
                String Observacoes=fTecnica.getString("Observacoes");


                Ftecnica auxfTecnica = new Ftecnica(idFtecnica, Ficheiro, Observacoes);
                ftecnicas.add(auxfTecnica);

            }
        }
        catch(JSONException e) {
            e.printStackTrace();
        }
        return ftecnicas;

    }

    public static Ftecnica parserJsonFtecnica (String response, Context context) {
        Ftecnica auxfTecnica = null;
        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject fTecnica = new JSONObject(response);
                int idFtecnica=fTecnica.getInt("idFichaClinica");
                String Ficheiro = fTecnica.getString("Ficheiro");
                String Observacoes=fTecnica.getString("Observacoes");


                auxfTecnica = new Ftecnica(idFtecnica, Ficheiro, Observacoes);

            }
        }
        catch(JSONException e) {
            e.printStackTrace();
        }
        return auxfTecnica;


    }
    public static String parserJsonLogin(String response, Context context) {
        String token =null;

        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject livro = new JSONObject(response);
        //TODO: mudar aqui e em todos quando passar o token do user
                token = livro.getString("token");



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
