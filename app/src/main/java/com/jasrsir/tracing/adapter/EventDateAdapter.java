package com.jasrsir.tracing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.pojo.pojoevent.Date;

import java.util.ArrayList;

/**
 * Adapter to Date event
 */

public class EventDateAdapter extends ArrayAdapter<Date> {

    private Context  context;
    static ArrayList<Date> mListDate;

    /**
     * Constructor to Date Adapter
     * @param context the aplicattion context
     */
    public EventDateAdapter(Context context) {
        super(context, R.layout.event_date_card );
        this.context = context;
    }

    /**
     * Class to Holder that contains a date event.
     */
    static class DateViewHolder{
        private TextView mTitle;
        private TextView mSummary;
        private TextView mDate;
        private TextView mHourStart;
        private TextView mHourEnd;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        DateViewHolder dateViewHolder;

        if (item == null) {
            LayoutInflater inflater =  (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            item = inflater.inflate(R.layout.event_date_card, null);
            dateViewHolder = new DateViewHolder();

            dateViewHolder.mTitle = (TextView) item.findViewById(R.id.txvDateTitle);
            dateViewHolder.mSummary = (TextView) item.findViewById(R.id.txvDateSummary);
            dateViewHolder.mDate = (TextView) item.findViewById(R.id.txvDateDaySelect);
            dateViewHolder.mHourStart = (TextView) item.findViewById(R.id.txvDateHourStart);
            dateViewHolder.mHourEnd = (TextView) item.findViewById(R.id.txvDateHourEnd);

            item.setTag(dateViewHolder);

        } else {
            dateViewHolder = (DateViewHolder) item.getTag();

            dateViewHolder.mTitle.setText(getItem(position).getTitle());
            dateViewHolder.mSummary.setText(getItem(position).getSummary());
            dateViewHolder.mDate.setText(getItem(position).getDate());
            dateViewHolder.mHourStart.setText(getItem(position).getHourStart());
            dateViewHolder.mHourEnd.setText(getItem(position).getHourEnd());
        }

        return item;
    }
}
