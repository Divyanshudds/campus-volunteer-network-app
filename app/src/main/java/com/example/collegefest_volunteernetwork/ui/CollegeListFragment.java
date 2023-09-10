package com.example.collegefest_volunteernetwork.ui;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.collegefest_volunteernetwork.R;
import com.example.collegefest_volunteernetwork.adapter.CollegeAdapter;
import com.example.collegefest_volunteernetwork.college_database.CollegefestDatabase;
import com.example.collegefest_volunteernetwork.model_class.InformationModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollegeListFragment extends Fragment implements CollegeAdapter.OnDeleteClickListener {
    private RecyclerView recyclerView;
    private CollegeAdapter adapter;
    List<InformationModel> modelList = new ArrayList<>();
    Context context;

    public CollegeListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_collegefest_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.donatorRecycler);
        modelList = CollegefestDatabase.getInstance(context).getCollegeDao().getAllDonationList();
        Collections.reverse(modelList);
        adapter = new CollegeAdapter(context, modelList, this);
        GridLayoutManager glm = new GridLayoutManager(context, 1);
        recyclerView.setLayoutManager(glm);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnDeleteClickListener(InformationModel modelList) {
        
    }
}
