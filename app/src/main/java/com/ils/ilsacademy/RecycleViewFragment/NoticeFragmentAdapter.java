package com.ils.ilsacademy.RecycleViewFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ils.ilsacademy.R;
import com.ils.ilsacademy.models.NoticeDataModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class NoticeFragmentAdapter extends RecyclerView.Adapter<NoticeFragmentAdapter.ViewHolder> {


    private static final String TAG = "com.ils.ilsacademy.RecycleViewFragment.NoticeFragmentAdapter";
    private final Context mContext;
    private ArrayList<NoticeDataModel> noticeDataModelArrayList = new ArrayList<>();


    public NoticeFragmentAdapter(Context context, ArrayList<NoticeDataModel> mnoticeDataModelArrayList) {

        noticeDataModelArrayList = mnoticeDataModelArrayList;
        mContext = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.noticelist, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        NoticeDataModel noticeDataModel = noticeDataModelArrayList.get(position);
        holder.title.setText(noticeDataModel.getTitle());
//        holder.des.setText(noticeDataModel.getDescription());
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM,dd yyyy hh:mm a", Locale.getDefault());
        String date = sdf.format(calendar.getTime());
        holder.date.setText(date);
    }


    @Override

    public int getItemCount() {
        return noticeDataModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView des;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            des = itemView.findViewById(R.id.des);
            date = itemView.findViewById(R.id.date);
        }
    }
}
