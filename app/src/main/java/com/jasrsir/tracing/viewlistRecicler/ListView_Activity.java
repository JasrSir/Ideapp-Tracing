package com.jasrsir.tracing.viewlistRecicler;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.adapter.EventAdapterListView;
import com.jasrsir.tracing.adapter.Repository;
import com.jasrsir.tracing.pojo.pojoevent.EventPojo;

public class ListView_Activity extends ListActivity {

    //To create a ListView need.
    private ArrayAdapter<EventPojo> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mAdapter = new EventAdapterListView(ListView_Activity.this);
        getListView().setAdapter(mAdapter);
    }
}
