package com.jasrsir.tracing.activity;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.jasrsir.tracing.R;

public class NewEvent_Activity extends AppCompatActivity {


    //region variables
    private View view;
    //Variables para ocultar/mostrar
    private TextInputLayout mtilLink;
    private TextView mTextViewDater;
    private CalendarView mCalendarDate;
    private LinearLayout mLinLayTextStartEnd;
    private LinearLayout mLinLayPickerHourMin;

    //Variables para inicializar los numberPickers
    private NumberPicker mNumPickStartHour;
    private NumberPicker mNumPickStartMin;
    private NumberPicker mNumPickEndHour;
    private NumberPicker mNumPickEndMin;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        setWidgets(getIntent().getExtras());
    }

    private void setWidgets(Bundle eleccion) {
        mtilLink = (TextInputLayout) findViewById(R.id.tilNewEventLink);
        mTextViewDater = (TextView) findViewById(R.id.txvNewEventDate);
        mCalendarDate = (CalendarView) findViewById(R.id.calNewEventDate);
        mLinLayTextStartEnd =(LinearLayout) findViewById(R.id.linLayTime);
        mLinLayPickerHourMin = (LinearLayout) findViewById(R.id.linLayTimeHourMin);
        //-----------------------------------
        mNumPickStartHour = (NumberPicker) findViewById(R.id.numPickNewEventHourStart);
        mNumPickStartMin = (NumberPicker) findViewById(R.id.numPickNewEventMinStart);
        mNumPickEndHour = (NumberPicker) findViewById(R.id.numPickNewEventHourEnd);
        mNumPickEndMin = (NumberPicker) findViewById(R.id.numPickNewEventMinEnd);

        if (eleccion != null)
            switch (eleccion.getString("EVENT")) {
                case "date":
                    mTextViewDater.setVisibility(View.VISIBLE);

                    mLinLayTextStartEnd.setVisibility(View.VISIBLE);
                    mLinLayPickerHourMin.setVisibility(View.VISIBLE);
                    mNumPickStartHour.setMinValue(00);
                    mNumPickStartHour.setMaxValue(23);
                    mNumPickStartMin.setMinValue(00);
                    mNumPickStartMin.setMaxValue(59);
                    mNumPickEndHour.setMinValue(00);
                    mNumPickEndHour.setMaxValue(23);
                    mNumPickEndMin.setMinValue(00);
                    mNumPickEndMin.setMaxValue(59);
                    break;
                case "action":
                    mCalendarDate.setVisibility(View.GONE);
                    break;
                case "link":
                    mCalendarDate.setVisibility(View.GONE);
                    mtilLink.setVisibility(View.VISIBLE);
                    break;
                case "post":
                    mCalendarDate.setVisibility(View.GONE);
                    break;
            }
    }

    public void onClickAddEvent(View view) {

    }
}
