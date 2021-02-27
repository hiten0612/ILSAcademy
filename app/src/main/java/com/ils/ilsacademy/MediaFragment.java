package com.ils.ilsacademy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ils.ilsacademy.RecycleViewFragment.MediaFragmentAdapter;
import com.ils.ilsacademy.models.MediaDatamodel;

import java.util.ArrayList;


public class MediaFragment extends Fragment {

    private RecyclerView recyclerView2;
    private MediaFragmentAdapter mediaFragmentAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_media, container, false);

        recyclerView2 = view.findViewById(R.id.recycleView2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView2.setLayoutManager(linearLayoutManager);
        media();

        return view;


    }

    private void media() {
        ArrayList<MediaDatamodel> dataList = new ArrayList();

        dataList.add(new MediaDatamodel("title", "description", "link"));


        dataList.add(new MediaDatamodel("holiday", "hello student tomorrow holiday in college due to online exam", "Link"));

        dataList.add(new MediaDatamodel("assignment", "student submit your assignment and collect your result", "Link"));


        dataList.add(new MediaDatamodel("leacture", "today's leacture over", "Link"));


        mediaFragmentAdapter = new MediaFragmentAdapter(getContext(), dataList);
        recyclerView2.setAdapter(mediaFragmentAdapter);

    }
}