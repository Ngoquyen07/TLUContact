package com.example.tlucontact;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DBDVAdapter extends RecyclerView.Adapter<DBDVAdapter.DBDVViewHolder> {
    private final ArrayList<DBDV> dbdvs;

    public DBDVAdapter(Context context , ArrayList<DBDV> dbdvs) {
        this.dbdvs = dbdvs;
    }

    public static class DBDVViewHolder extends RecyclerView.ViewHolder {
        ImageView ivDVSymbol;
        TextView tvDVName, tvDVAddress, tvDVId;  // Thêm TextView ID

        public DBDVViewHolder(View itemView) {
            super(itemView);
            ivDVSymbol = itemView.findViewById(R.id.ivDVSymbol);
            tvDVName = itemView.findViewById(R.id.tvDVName);
            tvDVAddress = itemView.findViewById(R.id.tvDVAddress);
            tvDVId = itemView.findViewById(R.id.tvDVId);  // Ánh xạ ID

            itemView.setOnClickListener(v -> {
                DBDV dbdv = (DBDV) v.getTag();
                Intent intent = new Intent(v.getContext(), DBDVActivity.class);
                intent.putExtra("ID", dbdv.getId());  // Truyền ID sang Activity
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dbdv_item, parent, false);
        return new DBDVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DBDVViewHolder holder, int position) {
        DBDV dbdv = dbdvs.get(position);
        holder.itemView.setTag(dbdv);
        holder.ivDVSymbol.setImageResource(dbdv.getSymbolImage());
        holder.tvDVName.setText(dbdv.getName());
        holder.tvDVAddress.setText(dbdv.getAddress());
        holder.tvDVId.setText(dbdv.getId());  // Gán giá trị ID vào TextView
    }

    @Override
    public int getItemCount() {
        return dbdvs.size();
    }
}
