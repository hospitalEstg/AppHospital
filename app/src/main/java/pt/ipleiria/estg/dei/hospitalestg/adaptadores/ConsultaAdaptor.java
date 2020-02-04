package pt.ipleiria.estg.dei.hospitalestg.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.R;
import pt.ipleiria.estg.dei.hospitalestg.modelo.Consulta;

public class ConsultaAdaptor extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Consulta> consultas;

    public ConsultaAdaptor(Context context, ArrayList<Consulta> consultas) {
        this.context = context;
        this.consultas = consultas;
    }

    @Override
    public int getCount() {
        return consultas.size();
    }

    @Override
    public Object getItem(int position) {
        return consultas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (layoutInflater == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_consultas, null);
        }

        ViewHolderConsulta viewHolder = (ViewHolderConsulta) view.getTag();

        if (viewHolder == null) {
            viewHolder = new ViewHolderConsulta(view);
            view.setTag(viewHolder);
        }

        //viewHolderLista(view);
        viewHolder.update(position);

        return view;

    }

    private class ViewHolderConsulta {

        private TextView tvMedico, tvMotivo, tvData, tvHora;

        public ViewHolderConsulta(View view){
            tvMedico = view.findViewById(R.id.tv_Medico);
            tvMotivo = view.findViewById(R.id.tv_Motivo);
            tvData = view.findViewById(R.id.tv_Data);
            tvHora = view.findViewById(R.id.tv_Hora);

        }

        public void update (int position){
            Consulta consulta = consultas.get(position);
            tvMedico.setText("Manel");
            tvMotivo.setText(consulta.getMotivo());
            tvData.setText(consulta.getData());
            tvHora.setText(consulta.getHora());

        }
    }
}
