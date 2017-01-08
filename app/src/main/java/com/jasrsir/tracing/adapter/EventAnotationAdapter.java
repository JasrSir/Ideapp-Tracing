package com.jasrsir.tracing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.pojo.pojoevent.Anotation;

import java.util.List;

/**
 * Adapter to Anotation event
 */

public class EventAnotationAdapter extends ArrayAdapter<Anotation> {

    private Context context;

    /**
     * Constructor to Anotation Adapter
     * @param context the aplicattion context
     */
    public EventAnotationAdapter(Context context, List<Anotation> mList) {
        super(context, R.layout.event_anotation_card ,mList);
        this.context = context;
    }

    /**
     * Class to Holder that contains a link event.
     */
    static class AnotationViewHolder {
        private TextView mTitle;
        private TextView mSummary;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        AnotationViewHolder anotationViewHolder;

        if (item == null) {
            LayoutInflater inflater =  (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            item = inflater.inflate(R.layout.event_anotation_card, null);
            anotationViewHolder = new AnotationViewHolder();

            anotationViewHolder.mTitle = (TextView) item.findViewById(R.id.txvAnotationTitle);
            anotationViewHolder.mSummary = (TextView) item.findViewById(R.id.txvAnotationSummary);

            item.setTag(anotationViewHolder);

        } else {
            anotationViewHolder = (AnotationViewHolder) item.getTag();

            anotationViewHolder.mTitle.setText(getItem(position).getTitle());
            anotationViewHolder.mSummary.setText(getItem(position).getSummary());
        }

        return item;
    }
}
