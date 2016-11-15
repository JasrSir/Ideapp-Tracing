package com.jasrsir.tracing.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jasrsir.tracing.R;

public class NewEvent_Activity extends AppCompatActivity {

    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        setWidgets();
    }

    private void setWidgets() {
    }

}
