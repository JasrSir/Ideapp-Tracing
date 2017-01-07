package com.jasrsir.tracing.adapter;

import android.app.Application;

import com.jasrsir.tracing.pojo.pojoevent.EventPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * EXAMPLE class Event to RecyclerView and Listview
 */

public class Repository extends Application {

    private ArrayList<EventPojo> mEventList = new ArrayList<EventPojo>();


    @Override
    public void onCreate() {
        super.onCreate();
        saveEvent(new EventPojo("Juan Muñoz (Panadero)", "CODERECEIVER","Mañana a las 2", "María te recuerdo que me llego mañana para entregarte el pan"));
        saveEvent(new EventPojo("Alejandro Gomez (Frutero)", "CODERECEIVER","Fruta Caducada", "Al final no voy porque he pisado mi fruta, voy a arruinarme muahahahaha"));
        saveEvent(new EventPojo("María Pérez (Fisioterapeuta)", "CODERECEIVER","Cambio de planes", "He pensado que mañana tú me des el masaje a mí, OK?"));
        saveEvent(new EventPojo("Sócrates (filosofo)", "CODERECEIVER","Ser o no ser", "Espero que Shakespeare no me denuncie por usar su frase"));
        saveEvent(new EventPojo("Trump (shit president)", "CODERECEIVER","Notice to EE.UU", "GET AMERICA GREAT AGAIN"));
        saveEvent(new EventPojo("Hillary Clinton (loser)", "CODERECEIVER","I hate Trump", "Trump es una asquerosa persona, I kill you"));

    }

    private void saveEvent(EventPojo eventPojo) {
        mEventList.add(eventPojo);
    }

    public List<EventPojo> getListEvent() {
        return mEventList;
    }
}
