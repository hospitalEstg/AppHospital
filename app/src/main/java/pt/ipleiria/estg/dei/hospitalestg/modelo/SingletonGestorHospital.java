package pt.ipleiria.estg.dei.hospitalestg.modelo;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.listeners.ConsultaListener;
import pt.ipleiria.estg.dei.hospitalestg.utils.ConsultaJsonParser;


public class SingletonGestorHospital {

    private ArrayList<Consulta> consultas;
    private static SingletonGestorHospital instance = null;
    private ConsultaBDHelper consultasBD;
    private final String mUrlAPIConsultas = "http://10.0.2.2/Projecto-master/backend/web/api/cons";
    private static RequestQueue volleyQueue;
    private ConsultaListener consultaListener;


    //  private ConsultaListener consultaListener;


    public static synchronized SingletonGestorHospital getInstance(Context context) {

        if (instance == null) {
            instance = new SingletonGestorHospital(context);

            volleyQueue = Volley.newRequestQueue(context);

        }

        return instance;
    }

    private SingletonGestorHospital(Context context) {
        consultas = new ArrayList<>();
        consultasBD = new ConsultaBDHelper(context);


    }

    public void setConsultaListener(ConsultaListener consultaListener) {
        this.consultaListener = consultaListener;
    }

    public Consulta getConsulta(int id) {
        for (Consulta I : consultas) {
            if (I.getId() == id) {
                return I;
            }
        }
        return null;
    }

    public ArrayList<Consulta> getConsultasDB() {
        consultas = consultasBD.getAllConsultasDB();
        return consultas;
    }

    // ***API****

    public void getAllConsultasAPI(final Context context, boolean isConnected) {
        if (!isConnected) {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
            consultas = consultasBD.getAllConsultasDB();


            if (consultaListener != null)
                consultaListener.onRefreshConsulta(consultas);
        } else {
            JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, mUrlAPIConsultas, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    consultas = ConsultaJsonParser.parserJsonConsultas(response, context);

                    if (consultaListener != null)
                        consultaListener.onRefreshConsulta(consultas);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            volleyQueue.add(req);
        }


    }




}