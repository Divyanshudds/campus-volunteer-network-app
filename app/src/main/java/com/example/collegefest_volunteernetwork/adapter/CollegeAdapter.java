    package com.example.collegefest_volunteernetwork.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegefest_volunteernetwork.R;
import com.example.collegefest_volunteernetwork.model_class.InformationModel;

import java.util.List;

public class CollegeAdapter extends RecyclerView.Adapter<CollegeAdapter.CollegeListViewHolder> {
    public void setOnDeleteClickListener(CollegeAdapter.OnDeleteClickListener onDeleteClickListener) {
        OnDeleteClickListener = onDeleteClickListener;
    }
// Added changes done
    public interface OnDeleteClickListener{
         void OnDeleteClickListener(InformationModel modelList);
    }
    Context context;
    List<InformationModel> modelList;
    //added changes done
    OnDeleteClickListener OnDeleteClickListener;

    public CollegeAdapter(Context context, List<InformationModel> modelList, OnDeleteClickListener listener) {
        this.context = context;
        this.modelList = modelList;
        //Added changes done
        this.OnDeleteClickListener = listener;
    }

    @NonNull
    @Override
    public CollegeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.college_list_row, parent, false);
        return new CollegeListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollegeListViewHolder holder, int position) {
        final InformationModel model = modelList.get(position);
        holder.collegename.setText(modelList.get(position).getDonatorName());
        holder.festNaame.setText(modelList.get(position).getFoodName());
        holder.nQtn.setText(modelList.get(position).getQuantity());
        holder.cDate.setText(modelList.get(position).getDate());
        holder.cTime.setText(modelList.get(position).getTime());
        holder.dAddress.setText(modelList.get(position).getAdress());
        holder.dMobile.setText(modelList.get(position).getPhone());
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public  class CollegeListViewHolder extends RecyclerView.ViewHolder {
        TextView collegename,festNaame, nQtn, cDate, cTime, dAddress,dMobile;

        ToggleButton applybtn;

        int mposition;

        public CollegeListViewHolder(@NonNull View itemView) {
            super(itemView);
            collegename= itemView.findViewById(R.id.collegeNameTV);
            festNaame = itemView.findViewById(R.id.festNameTV);
            nQtn = itemView.findViewById(R.id.novolunteerqTV);
            cDate = itemView.findViewById(R.id.collectionDateTv);
            cTime = itemView.findViewById(R.id.collectionTimeTv);
            dAddress = itemView.findViewById(R.id.addressTV);
            dMobile = itemView.findViewById(R.id.MobileTV);
            applybtn = itemView.findViewById(R.id.applybtn);
        }

        public void setData(int position){
            mposition = position;
        }
        public void setListeners() {
             applybtn.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if(OnDeleteClickListener != null){
                         OnDeleteClickListener.OnDeleteClickListener(modelList.get(mposition));
                     }
                 }
             });

        }

    }
}
