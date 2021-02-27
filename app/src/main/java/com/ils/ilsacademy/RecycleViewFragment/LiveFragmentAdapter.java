package com.ils.ilsacademy.RecycleViewFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ils.ilsacademy.R;
import com.ils.ilsacademy.models.LiveDataModel;

import java.util.ArrayList;

public class LiveFragmentAdapter extends RecyclerView.Adapter<LiveFragmentAdapter.ViewHolder> {

    private static final String TAG = "com.ils.ilsacademy.RecycleViewFragment.LiveFragmentAdapter";
    private final Context lContext;
    private ArrayList<LiveDataModel> dataModelArrayList = new ArrayList<>();

    public LiveFragmentAdapter(Context context, ArrayList<LiveDataModel> mDataArrayList) {

        dataModelArrayList = mDataArrayList;
        lContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.livelist, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        LiveDataModel liveDataModel = dataModelArrayList.get(position);
        holder.lvTitle.setText(liveDataModel.getTitle());
        holder.lvdes.setText(liveDataModel.getDes());
        holder.lvlink.setText(liveDataModel.getLink());


    }


    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView lvTitle;
        TextView lvdes;
        TextView lvlink;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lvTitle = itemView.findViewById(R.id.lvTitle);
            lvdes = itemView.findViewById(R.id.lvdes);
            lvlink = itemView.findViewById(R.id.lvlink);
        }
    }
}
