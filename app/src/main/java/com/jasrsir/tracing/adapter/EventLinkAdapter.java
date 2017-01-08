package com.jasrsir.tracing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.pojo.pojoevent.Link;

import java.util.List;


/**
 * Adapter to Link event
 */

public class EventLinkAdapter extends ArrayAdapter<Link> {

    private Context context;

    /**
     * Constructor to Link Adapter
     * @param context the aplicattion context
     */
    public EventLinkAdapter(Context context,List<Link> mList) {
        super(context, R.layout.event_link_card,mList );
        this.context = context;
    }

    /**
     * Class to Holder that contains a link event.
     */
    static class LinkViewHolder {
        private TextView mTitle;
        private TextView mSummary;
        private TextView mLink;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        LinkViewHolder linkViewHolder;

        if (item == null) {
            LayoutInflater inflater =  (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            item = inflater.inflate(R.layout.event_link_card, null);
            linkViewHolder = new LinkViewHolder();

            linkViewHolder.mTitle = (TextView) item.findViewById(R.id.txvLinkTitle);
            linkViewHolder.mSummary = (TextView) item.findViewById(R.id.txvLinkSummary);
            linkViewHolder.mLink = (TextView) item.findViewById(R.id.txvLinkLink);


            item.setTag(linkViewHolder);

        } else {
            linkViewHolder = (LinkViewHolder) item.getTag();

            linkViewHolder.mTitle.setText(getItem(position).getTitle());
            linkViewHolder.mSummary.setText(getItem(position).getSummary());
            linkViewHolder.mLink.setText(getItem(position).getLink());
        }

        return item;
    }
}
