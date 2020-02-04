package pt.ipleiria.estg.dei.hospitalestg.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.R;
import pt.ipleiria.estg.dei.hospitalestg.modelo.Receita;

public class ReceitaAdaptor extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Receita> receitas;

    public ReceitaAdaptor(Context context, ArrayList<Receita> receitas) {
        this.context = context;
        this.receitas = receitas;
    }

    @Override
    public int getCount() {
        return receitas.size();
    }

    @Override
    public Object getItem(int position) {
        return receitas.get(position);
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
            view = layoutInflater.inflate(R.layout.item_receitas, null);
        }

        ViewHolderReceita viewHolder = (ViewHolderReceita) view.getTag();

        if (viewHolder == null) {
            viewHolder = new ViewHolderReceita(view);
            view.setTag(viewHolder);
        }

        //viewHolderLista(view);
        viewHolder.update(position);

        return view;

    }

    private class ViewHolderReceita {

        private TextView tvPrescricao, tvDataReceita;

        public ViewHolderReceita(View view){
            tvPrescricao = view.findViewById(R.id.tv_Prescricao);
            tvDataReceita = view.findViewById(R.id.tv_DataReceita);
            //medicamento tvMedicamento = view.findViewById(R.id.tv_Medicamento);

        }

        public void update (int position){
            Receita receita = receitas.get(position);
            tvPrescricao.setText(receita.getPrescricao());
            tvDataReceita.setText(receita.getDataReceita());
            // tvPrescricao.setText("brufen");
             //tvDataReceita.setText("2020-02-02");


        }
    }
}