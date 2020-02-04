package pt.ipleiria.estg.dei.hospitalestg.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.modelo.Ftecnica;
import pt.ipleiria.estg.dei.hospitalestg.modelo.Receita;

public class ReceitaJsonParser {

    public static ArrayList<Receita> parserJsonReceita (JSONArray response, Context context) {
        ArrayList<Receita> receitas = new ArrayList<>();

        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject rec = (JSONObject)response.get(i);
                int idReceita=rec.getInt("idReceita");
                String DataReceita = rec.getString("DataReceita");
                String Prescricao=rec.getString("Prescricao");
                int Consulta_idConsulta=rec.getInt("Consulta_idConsulta");



                Receita auxReceita = new Receita(idReceita, Prescricao, DataReceita, Consulta_idConsulta);
                receitas.add(auxReceita);

            }
        }
        catch(JSONException e) {
            e.printStackTrace();
        }
        return receitas;

      /*  ArrayList<Receita> receitas = new ArrayList<>();
        try {
            for (int i=0; i<response.length(); i++) {


                JSONObject rec = (JSONObject)response.get(i);
                int id=rec.getInt("idReceita");
                String DataReceita= rec.getString("DataReceita");

                String Prescricao= rec.getString("Prescricao");
               int Consulta_idConsulta=rec.getInt("Consulta_idConsulta");



                Receita auxReceita = new Receita(id, Prescricao, DataReceita, Consulta_idConsulta);
                receitas.add(auxReceita);


            }
        }
        catch(JSONException e) {
            e.printStackTrace();
        }
        return receitas;*/
    }

    public static Receita parserJsonReceita (String response, Context context) {
        Receita auxReceita = null;
        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject rec = new JSONObject(response);
                int idReceita=rec.getInt("idReceita");
                String DataReceita= rec.getString("DataReceita");
                String Prescricao= rec.getString("Prescricao");
                int Consulta_idConsulta=rec.getInt("Consulta_idConsulta");


                auxReceita = new Receita(idReceita,  Prescricao, DataReceita, Consulta_idConsulta);

            }
        }
        catch(JSONException e) {
            e.printStackTrace();
        }
        return auxReceita;


    }

    public static String parserJsonLogin(String response, Context context) {
        String token =null;

        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject rec = new JSONObject(response);

                token = rec.getString("token");



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
