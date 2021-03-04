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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

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
        holder.mtTitle.setText(liveDataModel.getTitle());
     //   holder.lvdes.setText(liveDataModel.getDes());
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM,dd yyyy hh:mm a", Locale.getDefault());
        String date = sdf.format(calendar.getTime());
        holder.mtDate.setText(date);
      //  holder.link.setText(liveDataModel.getLink());


    }


    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mtTitle;
        TextView mtDate;
        TextView mtDes;
        TextView link;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mtTitle = itemView.findViewById(R.id.mtTitle);
            mtDate = itemView.findViewById(R.id.mtDate);
            mtDes = itemView.findViewById(R.id.mtDes);
            link = itemView.findViewById(R.id.link);
        }
    }
}
