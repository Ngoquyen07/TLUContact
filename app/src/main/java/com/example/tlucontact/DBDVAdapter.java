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

public class DBDVAdapter extends RecyclerView.Adapter<DBDVAdapter.DBDVViewHolder> {
    private ArrayList<DBDV> dbdvs;
    public DBDVAdapter(Context context , ArrayList<DBDV> dbdvs){
        this.dbdvs = dbdvs;
    }

    static public class DBDVViewHolder extends RecyclerView.ViewHolder{
        ImageView ivDVSymbol;
        TextView tvDVName;
        TextView tvDVAddress;
        public DBDVViewHolder(View itemView){
            super(itemView);
            ivDVSymbol = itemView.findViewById(R.id.ivDVSymbol);
            tvDVName = itemView.findViewById(R.id.tvDVName);
            tvDVAddress = itemView.findViewById(R.id.tvDVAddress);
            itemView.setOnClickListener(v ->{
                DBDV dbdv = (DBDV) v.getTag();
                Intent intent = new Intent(v.getContext(), DBDVActivity.class);
                intent.putExtra("NAME", dbdv.getName());
                intent.putExtra("ADDRESS", dbdv.getAddress());
                intent.putExtra("PHONE", dbdv.getPhoneNumber());
                intent.putExtra("AVATAR", dbdv.getSymbolImage());
                v.getContext().startActivity(intent);

            });
        }
    }

    @NonNull
    @Override
    public DBDVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.dbdv_item, null);
        return new DBDVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DBDVViewHolder holder, int position) {
        holder.itemView.setTag(dbdvs.get(position));
        DBDV dbdv = dbdvs.get(position);
        holder.ivDVSymbol.setImageResource(dbdv.getSymbolImage());
        holder.tvDVName.setText(dbdv.getName());
        holder.tvDVAddress.setText(dbdv.getAddress());
    }

    @Override
    public int getItemCount() {
        return dbdvs.size();
    }
}
