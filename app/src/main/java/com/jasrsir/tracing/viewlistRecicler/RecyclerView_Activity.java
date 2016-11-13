package com.jasrsir.tracing.viewlistRecicler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.adapter.EventAdapterRecyclerView;

public class RecyclerView_Activity extends AppCompatActivity {

    //region variables
    private RecyclerView mRcvEvent;
    private EventAdapterRecyclerView mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mAdapter = new EventAdapterRecyclerView(this);
        mRcvEvent = (RecyclerView) findViewById(R.id.recViewAdapter);
        mRcvEvent.setLayoutManager(new LinearLayoutManager(this));
        mRcvEvent.setAdapter(mAdapter);
    }
}
