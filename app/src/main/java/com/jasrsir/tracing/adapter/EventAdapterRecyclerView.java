package com.jasrsir.tracing.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.pojo.pojoevent.EventPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasrsir on 13/11/16.
 */

public class EventAdapterRecyclerView extends RecyclerView.Adapter<EventAdapterRecyclerView.ProductViewHolder> {

    private List<EventPojo> mEvents;
    private Context context;

    public EventAdapterRecyclerView(Context context) {
        this.context = context;
        mEvents = new ArrayList<EventPojo>(((Repository)context.getApplicationContext()).getListEvent());
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event, parent, false);
        return new ProductViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.mImgUser.setImageResource(R.drawable.ic_bug_report_black_48dp);
        holder.mTxvName.setText(mEvents.get(position).getCodeSender());
        holder.mTxvTitle.setText(mEvents.get(position).getTitle());
        holder.mTxvSummary.setText(mEvents.get(position).getSummary());

    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }


    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        //Variables
        ImageView mImgUser;
        TextView mTxvName;
        TextView mTxvTitle;
        TextView mTxvSummary;

        public ProductViewHolder(View item) {
            super(item);
            mImgUser = (ImageView) item.findViewById(R.id.imgEventPhotoSender);
            mTxvName = (TextView) item.findViewById(R.id.txvEventNameSender);
            mTxvTitle = (TextView) item.findViewById(R.id.txvEventTitle);
            mTxvSummary = (TextView) item.findViewById(R.id.txvEventSummary);
        }
    }

    public void getAllProduct() {
        mEvents.clear();
        mEvents.addAll(((Repository)context.getApplicationContext()).getListEvent());
        notifyDataSetChanged();

    }

    //RecyclerVier debe tener
    //- Un constructor que reciba el contexto
    //- NO TIENE colección interna en forma de copia. de hecho.
    //TODO RecyclerView DEBEMOS crear objetos con la colección de datos.
    //TODO Implementaremos onCreateViewHolder(), inflamos el XML y devolvemos el objeto View
    // Vinculamos unos datos con otros con TODO onBindViewHolder e implementamos el
    //ArrayAdapter tiene métodos para añadir, borrar, etc. TODO RecyclerView debemos escribirlos nosotros.

}