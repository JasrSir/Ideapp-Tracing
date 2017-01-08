package com.jasrsir.tracing.presenter;

import com.jasrsir.tracing.interfaces.EventPojoPresenter;
import com.jasrsir.tracing.pojo.pojoevent.EventPojo;

import java.util.HashMap;

/**
 * Created by jasrsir on 16/12/16.
 */

public class MultiChoicePresenter {
    EventPojoPresenter.Presenter mPresent;
    HashMap<Integer,Boolean> mMap;

    public MultiChoicePresenter(EventPojoPresenter.Presenter presenter) {
        this.mPresent = presenter;
        mMap = new HashMap<>();
    }

    public boolean isPositiveChecked(int position){
        boolean result = mMap.get(position);
        return  result;
    }

    public void setNewSelection(int position, boolean checked) {
        mMap.put(position,checked);
    }

    public void removeSelection(int position) {
        mMap.remove(position);
    }

    public void clearSelection() {
        mMap.clear();
    }

    public void deleteSelecterProduct() {
        for (int i = 0; i < mMap.size(); i++) {
            if (mMap.get(i)) {

            }
                //mPresent.deleteEvent(mMap.get(i));
        }
    }
}
