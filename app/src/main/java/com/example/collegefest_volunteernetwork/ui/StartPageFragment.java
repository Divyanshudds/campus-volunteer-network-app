package com.example.collegefest_volunteernetwork.ui;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.collegefest_volunteernetwork.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartPageFragment extends Fragment {
    RelativeLayout collegeOpt, volunteerOpt;
    private collegeVlounteerTransactionListener listener;
    private Context context;


    public StartPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        this.listener = (collegeVlounteerTransactionListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        collegeOpt = view.findViewById(R.id.collegeOpt);
        volunteerOpt = view.findViewById(R.id.volunteerOpt);

        //got d2 info fragment
        collegeOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.goToCollegeInfoPage();
            }
        });

        //goto volunteer fragment
        volunteerOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.goToVolunterLogin();
            }
        });
    }
    public interface collegeVlounteerTransactionListener {
        void goToCollegeInfoPage();
        void goToVolunterLogin();
    }
}
