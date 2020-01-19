package pt.ipleiria.estg.dei.hospitalestg.modelo;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pt.ipleiria.estg.dei.hospitalestg.listeners.ConsultaListener;
import pt.ipleiria.estg.dei.hospitalestg.listeners.FtecnicaListener;
import pt.ipleiria.estg.dei.hospitalestg.listeners.PedidoListener;
import pt.ipleiria.estg.dei.hospitalestg.listeners.PessoaListener;
import pt.ipleiria.estg.dei.hospitalestg.listeners.UserListener;
import pt.ipleiria.estg.dei.hospitalestg.utils.ConsultaJsonParser;
import pt.ipleiria.estg.dei.hospitalestg.utils.FtecnicaJsonParser;
import pt.ipleiria.estg.dei.hospitalestg.utils.PedidoJsonParser;


public class SingletonGestorHospital {

    private static final int ADICIONAR_BD = 1 ;
    private ArrayList<Pedido> pedidos;
    private final String mUrlAPIPedidos = "http://10.0.2.2/Projecto-master/backend/web/api/marc";
    private PedidoListener pedidoListener;


    private ArrayList<Consulta> consultas;
    private static SingletonGestorHospital instance = null;
    private ConsultaBDHelper consultasBD;
    private final String mUrlAPIConsultas = "http://10.0.2.2/Projecto-master/backend/web/api/cons?access-token=003qFCHhsW0Qn5lSi4Hu0-ZR15WNkOch";
    private static RequestQueue volleyQueue;
    private ConsultaListener consultaListener;

    private ArrayList<Ftecnica> fTecnica;
    private final String mUrlAPIFtecnica = "http://10.0.2.2/Projecto-master/backend/web/api/ftec";
    private FtecnicaListener ftecnicaListener;


    private ArrayList<Pessoa> pessoas;
   
    private final String mUrlAPIPessoa = "http://10.0.2.2/Projecto-master/backend/web/api/pess?access-token=003qFCHhsW0Qn5lSi4Hu0-ZR15WNkOch";
    private PessoaListener pessoaListener;

/
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

        pedidos = new ArrayList<>();

        fTecnica = new ArrayList<>();



    }

     public void setPedidoListener(PedidoListener pedidoListener) {
        this.pedidoListener = pedidoListener;
     }



     public Pedido getPedido(int idpedido){
        for (Pedido I: pedidos) {
            if(I.getIdPedido() == idpedido) {
                return I;
            }
        }
        return null;
     }

     public void setFtecnicaListener (FtecnicaListener ftecnicaListener) {
        this.ftecnicaListener = ftecnicaListener;
     }

     public Ftecnica getFtecnica (int  idftecnica){
        for (Ftecnica I: fTecnica) {
            if(I.getIdFtecnica() == idftecnica) {
                return I;
            }
        }
        return null;
     }


    public void setConsultaListener(ConsultaListener consultaListener) {
        this.consultaListener = consultaListener;
    }

    public void setPessoaListener(PessoaListener pessoaListener) {
        this.pessoaListener = pessoaListener;
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



    // *****************************************API************************************************************************

    public void getAllConsultasAPI(final Context context, boolean isConnected) {
        if (!isConnected) {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
            consultas = consultasBD.getAllConsultasDB();


            if (consultaListener != null)
                consultaListener.onRefreshConsulta(consultas);
        } else {
            JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, mUrlAPIConsultas+"api/cons?acess-token="+tokenAPI, null, new Response.Listener<JSONArray>() {
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


    public void getAllPedidosAPI(final Context context, boolean isConnected) {
        if (!isConnected) {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();


            if (pedidoListener != null)
               pedidoListener.onRefreshPedido(pedidos);
        } else {
            JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, mUrlAPIPedidos, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    pedidos = PedidoJsonParser.parserJsonPedidos(response, context);

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

    public void adicionarPedidoAPI(final Pedido pedido,final Context context) {
        StringRequest req = new StringRequest(Request.Method.POST, mUrlAPIPedidos, new Response.Listener<String>() {
           @Override
            public void onResponse(String response) {
              //  onUpdatePedido(PedidoJsonParser.parserJsonPedidos(response, context), ADICIONAR_BD);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {


            @Override
            protected Map<String, String> getParams()  {
                //chave valor MAP
                Map<String, String> params = new HashMap<>();
                //pode se ter nos headers
                //params.put("token", tokenAPI);
                params.put("idMarcacao_Consulta", pedido.getIdPedido()+"");
                params.put("Descricao", pedido.getDescricao());
                params.put("Urgente", pedido.isUrgente()+"");

                return params;
            }


        };
        volleyQueue.add(req);
    }

    public void getAllFtecnicasAPI(final Context context, boolean isConnected){
        if(!isConnected){
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();


            if(ftecnicaListener !=null)
                ftecnicaListener.onRefreshFtecnica(fTecnica);
        }
        else {
            JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, mUrlAPIFtecnica, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    fTecnica = FtecnicaJsonParser.parserJsonFtecnica(response,context);

                    if(ftecnicaListener!=null)
                        ftecnicaListener.onRefreshFtecnica(fTecnica);
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

    public void adicionarUserAPI(final User user,final Context context) {

        StringRequest req = new StringRequest(Request.Method.POST, mUrlAPIUser, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //  onUpdatePedido(PedidoJsonParser.parserJsonPedidos(response, context), ADICIONAR_BD);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {


            @Override
            protected Map<String, String> getParams()  {
                //chave valor MAP
                Map<String, String> params = new HashMap<>();
                //pode se ter nos headers
                //params.put("token", tokenAPI);
                params.put("username", user.getUsername()+"");
                params.put("email", user.getEmail());


                return params;
            }


        };
        volleyQueue.add(req);
    }


    public void adicionarPessoaAPI(final Pessoa pessoa,final Context context) {

        StringRequest req = new StringRequest(Request.Method.POST, mUrlAPIPessoa, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // onUpdatePessoa(PedidoJsonParser.parserJsonPedidos(response, context));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {


            @Override
            protected Map<String, String> getParams()  {

                Map<String, String> params = new HashMap<>();

                params.put("Nome", pessoa.getNome()+"");
                params.put("DataNascimento", pessoa.getDatanascimento()+"");
                params.put("Morada", pessoa.getMorada()+"");
                params.put("NumUtenteSaude", pessoa.getNumutentesaude()+"");
                params.put("NumIDCivil", pessoa.getNumidcivil()+"");
                params.put("TipoUtilizador", pessoa.getTipoutilizador()+"");
                params.put("idUser", "1");

                return params;
            }


        };
        volleyQueue.add(req);
    }



}