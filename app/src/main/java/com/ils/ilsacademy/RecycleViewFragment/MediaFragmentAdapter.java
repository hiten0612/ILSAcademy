package com.ils.ilsacademy.RecycleViewFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ils.ilsacademy.R;
import com.ils.ilsacademy.models.MediaDatamodel;

import java.util.ArrayList;

public class MediaFragmentAdapter extends RecyclerView.Adapter<MediaFragmentAdapter.ViewHolder> {

    private static final String TAG = "com.ils.ilsacademy.RecycleViewFragment.MediaFragmentAdapter";
    private final Context mContext;
    private ArrayList<MediaDatamodel> mediaDatamodelArrayList = new ArrayList<>();

    public MediaFragmentAdapter(Context context, ArrayList<MediaDatamodel> tmediaDatamodelArrayList) {

        mediaDatamodelArrayList = tmediaDatamodelArrayList;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medialist, parent, false);
        MediaFragmentAdapter.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MediaFragmentAdapter.ViewHolder holder, int position) {

        MediaDatamodel mediaDatamodel = mediaDatamodelArrayList.get(position);
//        holder.lvTitle.setText(mediaDatamodel.getTitle());
//        holder.lvdes.setText(mediaDatamodel.getDes());
//        holder.lvlink.setText(mediaDatamodel.getLink());

    }

    @Override
    public int getItemCount() {
        return mediaDatamodelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView lvTitle;
        TextView lvdes;
        TextView lvlink;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            lvTitle = itemView.findViewById(R.id.lvTitle);
//            lvdes = itemView.findViewById(R.id.lvdes);
//            lvlink = itemView.findViewById(R.id.lvlink);
        }
    }

}


