package com.jasrsir.tracing.listeners;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.pojo.pojoevent.Action;
import com.jasrsir.tracing.presenter.MultiChoicePresenter;

import java.util.ArrayList;

/**
 * Created by jasrsir on 8/01/17.
 */

public class SimpleMultiCloiceModeListener implements AbsListView.MultiChoiceModeListener {

    //region propierties
    private Context mContext;
    private MultiChoicePresenter multiChoicePresenter;
    private int statusBarColor;
    private int cont;
    private ArrayList<View> mListView;
    private ActionBar actionBar;
    //endregion


    public SimpleMultiCloiceModeListener(Context mContext, ArrayList<View> mListView,ActionBar actionBar, MultiChoicePresenter multiChoicePresenter) {
        this.mContext = mContext;
        this.mListView = mListView;
        this.multiChoicePresenter = multiChoicePresenter;
        this.actionBar = actionBar;
        this.cont = 0;
    }

    /**
     *
     * @param actionMode Es la barra de menu que se superpone a la toolbar
     * @param position posicion del elemento en la lista
     * @param id
     * @param checked
     */
    @Override
    public void onItemCheckedStateChanged(ActionMode actionMode, int position, long id, boolean checked) {
        actionBar.hide();
        if (checked) {
            cont++;
            multiChoicePresenter.setNewSelection(position,checked);
        }else {
            cont--;
            multiChoicePresenter.removeSelection(position);

        }
       // actionMode.setTitle(cont);
    }

    /**
     * Se está creando el menu de acción
     * @param actionMode
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        actionMode.getMenuInflater().inflate(R.menu.delete_menu,menu);
        for (View v: mListView) {
            v.setVisibility(View.GONE);
        }
        return true;
    }

    /**
     * Cuando termina de crearse, o cuando se actualiza
     * @param actionMode
     * @param menu
     * @return
     */
    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            statusBarColor = ((Activity) mContext).getWindow().getStatusBarColor();
            ((Activity)mContext).getWindow().setStatusBarColor(ContextCompat.getColor(mContext,R.color.background_statusbar));
        }
        return true;
    }

    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.action_delete_product:
                multiChoicePresenter.deleteSelecterProduct();
                break;
        }
        actionMode.finish();
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode actionMode) {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            ((Activity)mContext).getWindow().setStatusBarColor(statusBarColor);
        }
        multiChoicePresenter.clearSelection();
        for (View v: mListView) {
            v.setVisibility(View.VISIBLE);

        }
        cont = 0;
        actionBar.show();
    }
}
