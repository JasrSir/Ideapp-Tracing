package com.jasrsir.tracing.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jasrsir.tracing.R;
import com.jasrsir.tracing.adapter.EventDateAdapter;
import com.jasrsir.tracing.interfaces.EventPojoPresenter;
import com.jasrsir.tracing.pojo.pojoevent.Date;
import com.jasrsir.tracing.pojo.pojoevent.EventPojo;
import com.jasrsir.tracing.repository.DateRepositoryImpl;

import java.util.List;


public class DateFragment extends Fragment implements EventPojoPresenter.View {

    private ListView mListDate;
    private EventDateAdapter mAdapter;
    static Context mConext;


    private OnFragmentInteractionListener mListener;

    public DateFragment() {
        // Required empty public constructor
    }


    public static DateFragment newInstance(Bundle args, Context context) {
        DateFragment fragment = new DateFragment();
        fragment.setArguments(args);
        mConext = context;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        //deberiamos leer el archivo y hacer que se realice
        if (getArguments() != null) {

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_date, container, false);
        mListDate = (ListView) view.findViewById(R.id.listVDate);
        mAdapter = new EventDateAdapter(mConext, DateRepositoryImpl.getInstance().getEvents());
        mListDate.setAdapter(mAdapter);
        getActivity().getActionBar().setTitle("Citas");
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
    public void showMessage(String message) {

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
