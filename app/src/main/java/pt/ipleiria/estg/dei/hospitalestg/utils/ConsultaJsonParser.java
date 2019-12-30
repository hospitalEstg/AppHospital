package pt.ipleiria.estg.dei.hospitalestg.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.modelo.Consulta;

public class ConsultaJsonParser {

    public static ArrayList<Consulta> parserJsonConsultas (JSONArray response, Context context) {
        ArrayList<Consulta> consultas = new ArrayList<>();
        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject cons = (JSONObject)response.get(i);
                int id=cons.getInt("idConsulta");
                String medico= cons.getString("idMedico");
                System.out.println("-----------------------------------------------------------"+medico);
                String motivo= cons.getString("Descricao");
                String data=cons.getString("DataConsulta");
                String hora=cons.getString("TipoConsulta");


                Consulta auxConsulta = new Consulta(id, medico, motivo ,data ,hora);
                consultas.add(auxConsulta);


            }
        }
        catch(JSONException e) {
            e.printStackTrace();
        }
        return consultas;
    }

    public static Consulta parserJsonConsultas (String response, Context context) {
        Consulta auxConsulta = null;
        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject cons = new JSONObject(response);
                int id=cons.getInt("idConsulta");
                String medico= cons.getString("idMedico");
                String motivo=cons.getString("Descricao");
                String data=cons.getString("DataConsulta");
                String hora = cons.getString("TipoConsulta");

                auxConsulta = new Consulta(id, medico,motivo,data,hora);

            }
        }
        catch(JSONException e) {
            e.printStackTrace();
        }
        return auxConsulta;


    }

    public static String parserJsonLogin(String response, Context context) {
        String token =null;

        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject consulta = new JSONObject(response);

                token = consulta.getString("token");



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
