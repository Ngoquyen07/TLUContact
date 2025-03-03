package com.example.tlucontact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CBGVAdapter extends RecyclerView.Adapter<CBGVAdapter.CBGVViewHolder> {
    private ArrayList<CBGV> cbgvs;
    public CBGVAdapter(Context context , ArrayList<CBGV> cbgvs){
        this.cbgvs = cbgvs;
    }

    static public class CBGVViewHolder extends RecyclerView.ViewHolder{
        ImageView ivGVAvatar;
        TextView tvGVName;
        TextView tvGVAddress;
        public CBGVViewHolder(View itemView){
            super(itemView);
            ivGVAvatar = itemView.findViewById(R.id.ivGVAvatar);
            tvGVName = itemView.findViewById(R.id.tvGVName);
            tvGVAddress = itemView.findViewById(R.id.tvGVAddress);
            itemView.setOnClickListener(v ->{
                CBGV cbgv = (CBGV) v.getTag();
            });
        }
    }

    @NonNull
    @Override
    public CBGVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.cbgv_item, null);
        return new CBGVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CBGVViewHolder holder, int position) {
        holder.itemView.setTag(cbgvs.get(position));
        CBGV cbgv = cbgvs.get(position);
        holder.ivGVAvatar.setImageResource(cbgv.getAvatarImage());
        holder.tvGVName.setText(cbgv.getName());
        holder.tvGVAddress.setText(cbgv.getEmail());
    }

    @Override
    public int getItemCount() {
        return cbgvs.size();
    }


}
