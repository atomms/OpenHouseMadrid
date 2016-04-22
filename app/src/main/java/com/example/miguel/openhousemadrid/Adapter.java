package com.example.miguel.openhousemadrid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Santos on 12/04/2016.
 */
public class Adapter extends BaseAdapter implements Filterable{

    Context c;
    ArrayList<Edificio>edificios;
    ArrayList<Edificio>filterList;
    CustomFilter filter;

    public Adapter(Context ctx, ArrayList<Edificio> edificios) {
        this.c = ctx;
        this.edificios = edificios;
        this.filterList= edificios;
    }

    @Override
    public int getCount() {
        return edificios.size();
    }

    @Override
    public Object getItem(int pos) {
        return edificios.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return edificios.indexOf(getItem(pos));
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView==null){
            convertView=inflater.inflate(R.layout.model_edif, null);
        }

        TextView nameTxt= (TextView) convertView.findViewById(R.id.nombre_edif);
        ImageView edifImg= (ImageView) convertView.findViewById(R.id.imagen_edif);

        //SET DATA
        nameTxt.setText(edificios.get(pos).getNombre());
        edifImg.setImageResource(edificios.get(pos).getImg());

        return convertView;
    }

    @Override
    public Filter getFilter() {

        if(filter==null){
            filter=new CustomFilter();
        }
        return filter;
    }

    //INNER CLASS
    class CustomFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();

            if(constraint!=null&&constraint.length()>0){
                //TO UPPER
                constraint=constraint.toString().toUpperCase();
                ArrayList<Edificio>filters=new ArrayList<Edificio>();

                for (int i = 0; i<filterList.size();i++){
                    if(filterList.get(i).getNombre().toUpperCase().contains(constraint)){
                        Edificio e=new Edificio(
                                filterList.get(i).getNombre(),
                                filterList.get(i).getImg(),
                                filterList.get(i).getDescripción(),
                                filterList.get(i).getHorario(),
                                filterList.get(i).getDireccion(),
                                filterList.get(i).getComoLlegar(),
                                filterList.get(i).getTipoEdif(),
                                filterList.get(i).getConstruccion(),
                                filterList.get(i).getMinus(),
                                filterList.get(i).getInscrip(),
                                filterList.get(i).getWeb());
                        filters.add(e);
                    }

                }
                results.count=filters.size();
                results.values=filters;
            }else{
                results.count=filterList.size();
                results.values=filterList;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            edificios= (ArrayList<Edificio>)results.values;
            notifyDataSetChanged();

        }
    }

}
