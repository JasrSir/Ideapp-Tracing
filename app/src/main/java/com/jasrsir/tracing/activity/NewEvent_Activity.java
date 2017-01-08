package com.jasrsir.tracing.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.interfaces.EventPojoPresenter;
import com.jasrsir.tracing.pojo.pojoevent.Action;
import com.jasrsir.tracing.pojo.pojoevent.Anotation;
import com.jasrsir.tracing.pojo.pojoevent.Date;
import com.jasrsir.tracing.pojo.pojoevent.EventPojo;
import com.jasrsir.tracing.pojo.pojoevent.Link;
import com.jasrsir.tracing.presenter.EventPojoPresenterImpl;

import java.text.SimpleDateFormat;

public class NewEvent_Activity extends AppCompatActivity implements EventPojoPresenter.View {


    //region variables
    private View view;
    private String mEventPojo;
    private FloatingActionButton mFabAddEvent;
    private EditText medtNewEventTitle;
    private EditText medtNewEventSummary;
    private EditText medtNewEventLink;
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

    private EventPojoPresenterImpl presenter;
    //endregion

    //region Functions

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        setWidgets(getIntent().getExtras());
        presenter = new EventPojoPresenterImpl(this);
        mFabAddEvent = (FloatingActionButton) findViewById(R.id.fabNewEventAdd);
        mFabAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEventValid()) {
                    setNewEvent();
                } else
                    showMessage(getString(R.string.newEventErrorEmpty));

            }
        });
    }

    private void setWidgets(Bundle eleccion) {
        mtilLink = (TextInputLayout) findViewById(R.id.tilNewEventLink);
        mTextViewDater = (TextView) findViewById(R.id.txvNewEventDate);
        mCalendarDate = (CalendarView) findViewById(R.id.calNewEventDate);
        mLinLayTextStartEnd =(LinearLayout) findViewById(R.id.linLayTime);
        mLinLayPickerHourMin = (LinearLayout) findViewById(R.id.linLayTimeHourMin);
        medtNewEventTitle = (EditText) findViewById(R.id.edtNewEventTitle);
        medtNewEventSummary = (EditText) findViewById(R.id.edtNewEventSummary);
        medtNewEventLink = (EditText) findViewById(R.id.edtNewEventLink);
        //-----------------------------------
        mNumPickStartHour = (NumberPicker) findViewById(R.id.numPickNewEventHourStart);
        mNumPickStartMin = (NumberPicker) findViewById(R.id.numPickNewEventMinStart);
        mNumPickEndHour = (NumberPicker) findViewById(R.id.numPickNewEventHourEnd);
        mNumPickEndMin = (NumberPicker) findViewById(R.id.numPickNewEventMinEnd);

        if (eleccion != null)
            mEventPojo = eleccion.getString("EVENT");
        switch (mEventPojo) {
            case "date":
                //getActionBar().setTitle(R.string.ActionBarNewEventDate);
                mTextViewDater.setVisibility(View.VISIBLE);
                mCalendarDate.setMinDate(new java.util.Date().getTime());
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
                //getActionBar().setTitle(R.string.ActionBarNewEventAction);
                mCalendarDate.setVisibility(View.GONE);
                break;
            case "link":
                //getActionBar().setTitle(R.string.ActionBarNewEventLink);
                mCalendarDate.setVisibility(View.GONE);
                mtilLink.setVisibility(View.VISIBLE);
                break;
            case "post":
                //getActionBar().setTitle(R.string.ActionBarNewEventPost);
                mCalendarDate.setVisibility(View.GONE);
                break;
        }
    }

    private boolean isEventValid() {
        switch (mEventPojo) {
            case "date":
                if (medtNewEventTitle.getText().equals("") || medtNewEventSummary.getText().equals("") ||
                        mNumPickStartHour.getValue() == 0 || mNumPickEndHour.getValue() == 0 )
                    return false;
                break;
            case "action":
                return false;

            case "link":
                if (medtNewEventTitle.getText().equals("") || medtNewEventSummary.getText().equals("") ||
                        medtNewEventLink.getText().equals(""))
                    return false;
                break;
            case "post":
                if (medtNewEventTitle.getText().equals("") || medtNewEventSummary.getText().equals(""))
                    return false;
                break;
        }
        return true;
    }

    private void setNewEvent() {
        EventPojo newEvent= null;
        switch (mEventPojo) {
            case "date":
                newEvent = new Date("sender","receiver",
                                medtNewEventTitle.getText().toString(),
                                medtNewEventSummary.getText().toString(),
                                new SimpleDateFormat("dd-MM-yyyy").format(mCalendarDate.getDate()),
                                String.valueOf(mNumPickStartHour.getValue()+ ":" + mNumPickStartMin.getValue()),
                                String.valueOf(mNumPickEndHour.getValue()+ ":" + mNumPickEndMin.getValue()));
                break;
            case "action":
                //Action
            break;
            case "link":
                newEvent = new Link("sender","receiver",
                        medtNewEventTitle.getText().toString(),
                        medtNewEventSummary.getText().toString(),
                        medtNewEventLink.getText().toString());
                break;
            case "post":
                newEvent = new Anotation("sender","receiver",
                        medtNewEventTitle.getText().toString(),
                        medtNewEventSummary.getText().toString());
                break;
        }
        presenter.addEvent(newEvent);
        finish();

    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(findViewById(R.id.activity_new_event),message,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showEvent() {

    }

    @Override
    public void showEmptyState(boolean show) {

    }

    @Override
    public void showMessageDelete(EventPojo event) {

    }

    //endregion
}
