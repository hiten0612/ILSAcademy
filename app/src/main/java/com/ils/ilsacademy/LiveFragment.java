package com.ils.ilsacademy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ils.ilsacademy.RecycleViewFragment.LiveFragmentAdapter;
import com.ils.ilsacademy.models.LiveDataModel;

import java.util.ArrayList;


public class LiveFragment extends Fragment {

    private RecyclerView recyclerView1;
    private LiveFragmentAdapter lIveFragmentAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_live, container, false);

        recyclerView1 = view.findViewById(R.id.recyclerView1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView1.setLayoutManager(linearLayoutManager);
        live();

        return view;


    }

    private void live()
    {
        ArrayList<LiveDataModel> dataList = new ArrayList();

        dataList.add(new LiveDataModel("title","description","link"));


        dataList.add(new LiveDataModel("holiday","hello student tomorrow holiday in college due to online exam","Link"));

        dataList.add(new LiveDataModel("assignment","student submit your assignment and collect your result","Link"));


        dataList.add(new LiveDataModel("leacture","today's leacture over","Link"));


        lIveFragmentAdapter = new LiveFragmentAdapter(getContext(), dataList);
        recyclerView1.setAdapter(lIveFragmentAdapter);
    }
}