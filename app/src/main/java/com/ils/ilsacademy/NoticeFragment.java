package com.ils.ilsacademy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ils.ilsacademy.RecycleViewFragment.NoticeFragmentAdapter;
import com.ils.ilsacademy.models.NoticeDataModel;

import java.util.ArrayList;

public class NoticeFragment extends Fragment {

    private RecyclerView recyclerView;
    private NoticeFragmentAdapter noticeFragmentAdapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice, container, false);

        recyclerView = view.findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        initData();

        return view;
    }

    private void initData() {

        ArrayList<NoticeDataModel> noticelist = new ArrayList<>();
        noticelist.add(new NoticeDataModel("Title", "description"));
        noticelist.add(new NoticeDataModel("Holiday", "hello student tomorrow holiday in college due to online exam"));
        noticelist.add(new NoticeDataModel("Assignments", "student submit your assignment and collect your result"));
        noticelist.add(new NoticeDataModel("Lecture", "today's leacture over "));

        noticeFragmentAdapter = new NoticeFragmentAdapter(getContext(), noticelist);
        recyclerView.setAdapter(noticeFragmentAdapter);
    }
}