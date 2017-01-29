package com.jasrsir.tracing.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.adapter.EventLinkAdapter;
import com.jasrsir.tracing.interfaces.EventPojoPresenter;
import com.jasrsir.tracing.listeners.SimpleMultiCloiceModeListener;
import com.jasrsir.tracing.pojo.pojoevent.EventPojo;
import com.jasrsir.tracing.pojo.pojoevent.Link;
import com.jasrsir.tracing.presenter.EventPojoPresenterImpl;
import com.jasrsir.tracing.presenter.MultiChoicePresenter;
import com.jasrsir.tracing.database.LinkRepositoryImpl;


public class LinkFragment extends Fragment implements EventPojoPresenter.View {

    private ListView mListLink;
    private ImageView mImageEmpty;
    private EventLinkAdapter mAdapter;
    private EventPojoPresenterImpl mPresenter;
    static Context mConext;


    private OnFragmentInteractionListener mListener;

    public LinkFragment() {
        // Required empty public constructor
    }
    public static LinkFragment newInstance(Bundle args, Context context) {
        LinkFragment fragment = new LinkFragment();
        fragment.setArguments(args);
        mConext = context;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new EventLinkAdapter(mConext, LinkRepositoryImpl.getInstance().getEvents());
        mPresenter = new EventPojoPresenterImpl(this);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        //deberiamos leer el archivo y hacer que se realice
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_link, container, false);
        mListLink = (ListView) view.findViewById(R.id.listVLink);
        mImageEmpty = (ImageView) view.findViewById(R.id.imageEmptyLink);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mListLink.setAdapter(mAdapter);

        mListLink.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        mListLink.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        SimpleMultiCloiceModeListener simpleMultiCloiceModeListener = new SimpleMultiCloiceModeListener(mConext, mListLink.getTouchables(),getActivity().getActionBar(), new MultiChoicePresenter(mPresenter));
        mListLink.setMultiChoiceModeListener(simpleMultiCloiceModeListener);
        mListLink.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                int posSelected = mListLink.getCheckedItemPosition();
                mListLink.setItemChecked(i,posSelected == i);
                return true;
            }
        });
        if (mListLink.getCount() == 0)
            showEmptyState(true);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        //todo inflater.inflate(R.menu.ORDENAR);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     /*   switch (item.getItemId()) {
            case R.id.action_sort_alphabetically:
                adapter.sortAllProduct();
                break;
        }*/
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onFragmentInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //rootView = null;
        //((CoordinatorLayout)rootView).removeViews(R.layout.fragment_list_product,0);
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(getView(),message,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showEvent() {
        mAdapter.notifyDataSetChanged();
    }

    private  void hideList(boolean hide){
        mListLink.setVisibility(hide ? View.GONE : View.VISIBLE);
        mImageEmpty.setVisibility(hide ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showEmptyState(boolean show){
        hideList(show);
    }

    @Override
    public void showMessageDelete(final EventPojo event) {
        Snackbar.make(getView(),"deshacer borrado ",Snackbar.LENGTH_LONG).setAction(R.string.action_undo, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.add((Link) event);

            }
        }).show();
        //SETCALLBACK: Hace una llamada a un método calback de un snackbar,
        // incluuso despues de que se haya eliminado mediante un swipe
        /*.setCallback(new Snackbar.Callback(){
            @Override
            public void onDismissed(Snackbar snackbar, int event) {
                super.onDismissed(snackbar, event);

                if(event!=DISMISS_EVENT_SWIPE){
                    presenter.deleteProduct(product);
                }
            }

            @Override
            public void onShown(Snackbar snackbar) {
                super.onShown(snackbar);
            }
        }).show();*///Esto sería en el caso de que quisiesemos hacerlo con un callback del snackbar

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction();
    }
}
