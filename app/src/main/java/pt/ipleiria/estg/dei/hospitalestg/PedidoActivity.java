package pt.ipleiria.estg.dei.hospitalestg;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import pt.ipleiria.estg.dei.hospitalestg.modelo.Consulta;
import pt.ipleiria.estg.dei.hospitalestg.modelo.Pedido;
import pt.ipleiria.estg.dei.hospitalestg.modelo.SingletonGestorHospital;
import pt.ipleiria.estg.dei.hospitalestg.utils.ConsultaJsonParser;
import pt.ipleiria.estg.dei.hospitalestg.utils.PedidoJsonParser;

public class PedidoActivity extends AppCompatActivity {
    private Pedido pedido;
    private EditText etDescricao;
    private boolean Urgente;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_consulta);
        //TODO: mandar o id da pessoa;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int idPedido = getIntent().getIntExtra("PEDIDO", 0);
        pedido = SingletonGestorHospital.getInstance(getApplicationContext()).getPedido(idPedido);
        fab = findViewById(R.id.fab);

        etDescricao = findViewById(R.id.et_Descricao);
        final CheckBox cbUrgente = (CheckBox) findViewById(R.id.checkBoxUrgente);
        if (cbUrgente.isChecked()) {
            cbUrgente.setChecked(false);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!PedidoJsonParser.isConnectionInternet(getApplicationContext()))
                    Toast.makeText(getApplicationContext(), "Internet not available", Toast.LENGTH_SHORT).show();
                else {
                    if (etDescricao.getText().length()!=0 && cbUrgente.getText().length()!=0) {
                        if (pedido == null) {
                            SingletonGestorHospital.getInstance(getApplicationContext()).adicionarPedidoAPI(adicionarPedido(), getApplicationContext());
                            setResult(Activity.RESULT_OK);
                            finish();
                        }
                    }
                }
            }

        });

    }

    private Pedido adicionarPedido(){

        //sao edittexts c o nome errado
        String Descricao=etDescricao.getText().toString();
        boolean cbUrgente = Urgente;

         Pedido pedido = new Pedido(0,Descricao,cbUrgente);

        return pedido;
    }

    private Pedido guardarPedido() {return pedido;}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(pedido!= null) {
            //TODO: menu pedido
            return super.onCreateOptionsMenu(menu);
        }
        return false;
    }

    //TODO: option item selected e dialog de se pretende add
}

