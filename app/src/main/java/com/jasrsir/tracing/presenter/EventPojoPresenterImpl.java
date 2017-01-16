package com.jasrsir.tracing.presenter;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.adapter.EventDateAdapter;
import com.jasrsir.tracing.fragments.AnotationFragment;
import com.jasrsir.tracing.fragments.DateFragment;
import com.jasrsir.tracing.fragments.LinkFragment;
import com.jasrsir.tracing.interfaces.EventPojoPresenter;
import com.jasrsir.tracing.pojo.pojoevent.Action;
import com.jasrsir.tracing.pojo.pojoevent.Anotation;
import com.jasrsir.tracing.pojo.pojoevent.Date;
import com.jasrsir.tracing.pojo.pojoevent.EventPojo;
import com.jasrsir.tracing.pojo.pojoevent.Link;
import com.jasrsir.tracing.repository.ActionRepositoryImpl;
import com.jasrsir.tracing.repository.AnotationRepositoryImpl;
import com.jasrsir.tracing.repository.DateRepositoryImpl;
import com.jasrsir.tracing.repository.LinkRepositoryImpl;

/**
 * Created by jasrsir on 6/01/17.
 */

public class EventPojoPresenterImpl implements EventPojoPresenter.Presenter {

    private EventPojoPresenter.View view;
    private DateRepositoryImpl repositoryDate;
    private ActionRepositoryImpl repositoryAction;
    private LinkRepositoryImpl repositoryLink;
    private AnotationRepositoryImpl repositoryAnotation;
    private EventDateAdapter mAdapterDate;

    //private Repositorio repository;
    public EventPojoPresenterImpl(EventPojoPresenter.View view) {
        this.view = view;

            this.repositoryDate = DateRepositoryImpl.getInstance();
            this.repositoryLink = LinkRepositoryImpl.getInstance();
            this.repositoryAnotation = AnotationRepositoryImpl.getInstance();

         /*else if (view instanceof Action) {
             this.repositoryAction = ActionRepositoryImpl.getInstance();
        }*/
    }

    @Override
    public void addEvent(EventPojo event) {

        if (event instanceof Date) {
            repositoryDate.addDate((Date) event);
            mAdapterDate.notifyDataSetChanged();
        } else if (event instanceof Anotation) {
            repositoryAnotation.addAnotation((Anotation) event);
        } else if (event instanceof Link) {
            repositoryLink.addLink((Link) event);
        } else if (event instanceof Action) {
            repositoryAction.addAction((Action) event);
        }
        view.showMessage("Añadido nuevo Evento");

    }

    @Override
    public void updateEvent(EventPojo event) {
        if (event instanceof Date) {
            repositoryDate.updateDate((Date) event);
        } else if (event instanceof Anotation) {
            repositoryAnotation.updateAnotation((Anotation) event);
        } else if (event instanceof Link) {
            repositoryLink.updateLink((Link) event);
        } else if (event instanceof Action) {
            repositoryAction.updateAction((Action) event);
        }
    }

    @Override
    public void deleteEvent(EventPojo event) {
        if (event instanceof Date) {
            repositoryDate.deleteDate((Date) event);
        } else if (event instanceof Anotation) {
            repositoryAnotation.deleteAnotation((Anotation) event);
        } else if (event instanceof Link) {
            repositoryLink.deleteLink((Link) event);
        } else if (event instanceof Action) {
            repositoryAction.deleteAction((Action) event);
        }
    }

    @Override
    public void onDestroy() {
        view = null;
        repositoryDate = null;
        repositoryAction = null;
        repositoryAnotation = null;
        repositoryLink = null;
    }

    @Override
    public void onAddToCardButtonClicked() {

    }

    @Override
    public EventPojo getEventPojo(long id) {
        return null;
    }

    @Override
    public void onDeleteEventButtonClicked(EventPojo event) {
        deleteEvent(event);
    }
}
