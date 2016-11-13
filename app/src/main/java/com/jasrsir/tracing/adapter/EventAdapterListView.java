package com.jasrsir.tracing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.pojo.pojoevent.EventPojo;

/**
 * ADAPTER to ListView
 * Esta clase hay que formatearla y adaptarla.
 */

public class EventAdapterListView extends ArrayAdapter<EventPojo>{

    private Context mcontext;

    //Class to content a view
    class CardViewHolder {
        ImageView mImageUser;
        TextView mTxvName;
        TextView mTxvTitle;
        TextView mTxvSummary;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Variables vista y contenedor de la vista
        View item = convertView;
        CardViewHolder cardViewHolder;

        //Preguntamos si la vista es nula, si es nula ya lo inicializamos
        if (item == null) {
            //Creamos un objeto inflater que inicializamos al LayoutInflater del contexto
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // Inflar la vista, crear en memoria el objeto VIew   que contiene los widgets del XML
            item = inflater.inflate(R.layout.card_event, null);
            cardViewHolder = new CardViewHolder();

            // Asignamos a las vbariables los widgets mediante el metodo findViewById
            cardViewHolder.mImageUser = (ImageView) item.findViewById(R.id.imgEventPhotoSender);
            cardViewHolder.mTxvName = (TextView) item.findViewById(R.id.txvEventNameSender);
            cardViewHolder.mTxvTitle = (TextView) item.findViewById(R.id.txvEventTitle);
            cardViewHolder.mTxvSummary = (TextView) item.findViewById(R.id.txvEventSummary);


            item.setTag(cardViewHolder);
        } else
            cardViewHolder = (CardViewHolder)item.getTag();
        // Asignamos los datos del adapter a los widgets
        cardViewHolder.mImageUser.setImageResource(R.drawable.ic_bug_report_black_48dp);
        cardViewHolder.mTxvName.setText(getItem(position).getCodeSender());
        cardViewHolder.mTxvTitle.setText(getItem(position).getTitle());
        cardViewHolder.mTxvSummary.setText(getItem(position).getSummary());
        return item;
    }

    public EventAdapterListView(Context context) {
        super(context, R.layout.card_event, ((Repository)context.getApplicationContext()).getListEvent());
        this.mcontext = context;
    }




}
