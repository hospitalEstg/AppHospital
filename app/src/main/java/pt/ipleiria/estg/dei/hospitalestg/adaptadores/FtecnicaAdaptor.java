package pt.ipleiria.estg.dei.hospitalestg.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.hospitalestg.R;
import pt.ipleiria.estg.dei.hospitalestg.modelo.Ftecnica;

public class FtecnicaAdaptor extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Ftecnica> fTecnica;

    public FtecnicaAdaptor(Context context, ArrayList<Ftecnica> fTecnica) {
        this.context=context;
        this.fTecnica= fTecnica;
    }

    @Override
    public int getCount() {
        return fTecnica.size();
    }

    @Override
    public Object getItem(int position) {
        return fTecnica.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(layoutInflater == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(view == null){
            view = layoutInflater.inflate(R.layout.item_ftecnica, null);
        }

        ViewHolderFtecnica viewHolder = (ViewHolderFtecnica) view.getTag();

        if(viewHolder == null){
            viewHolder = new ViewHolderFtecnica(view);
            view.setTag(viewHolder);
        }

        //viewHolderLista(view);
        viewHolder.update(position);

        return view;
    }

    private class ViewHolderFtecnica {
        private TextView tvAssunto, tvObservacoes;

        public ViewHolderFtecnica(View view) {
          tvAssunto   = view.findViewById(R.id.tv_Assunto);
          tvObservacoes   = view.findViewById(R.id.tv_Observacoes);


        }

        public void update (int position) {
            Ftecnica ftecnica = fTecnica.get(position);
            tvAssunto.setText(ftecnica.getFicheiro());
            tvObservacoes.setText(ftecnica.getObservacoes());
        }
    }
}
