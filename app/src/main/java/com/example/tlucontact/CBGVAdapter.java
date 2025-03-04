package com.example.tlucontact;

import android.content.Context;
import android.content.Intent;
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
        TextView tvGVId;
        TextView tvGVName;
        TextView tvGVAddress;
        public CBGVViewHolder(View itemView){
            super(itemView);
            ivGVAvatar = itemView.findViewById(R.id.ivGVAvatar);
            tvGVId = itemView.findViewById(R.id.tvGVId);
            tvGVName = itemView.findViewById(R.id.tvGVName);
            tvGVAddress = itemView.findViewById(R.id.tvGVAddress);
            itemView.setOnClickListener(v ->{
                CBGV cbgv = (CBGV) v.getTag();
                Intent intent = new Intent(v.getContext(), CBGVActivity.class);
                intent.putExtra("ID", cbgv.getId());
                intent.putExtra("NAME", cbgv.getName());
                intent.putExtra("EMAIL", cbgv.getEmail());
                intent.putExtra("PHONE", cbgv.getPhoneNumber());
                intent.putExtra("POSITION", cbgv.getPosition());
                intent.putExtra("WORD_UNIT", cbgv.getWordUnit());
                intent.putExtra("AVATAR", cbgv.getAvatarImage());

                v.getContext().startActivity(intent);
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
        holder.tvGVId.setText(cbgv.getId());
        holder.tvGVName.setText(cbgv.getName());
        holder.tvGVAddress.setText(cbgv.getEmail());
    }

    @Override
    public int getItemCount() {
        return cbgvs.size();
    }


}
