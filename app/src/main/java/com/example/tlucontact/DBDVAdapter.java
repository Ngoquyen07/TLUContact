package com.example.tlucontact;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Adapter là cầu nối giữa ArrayList và RecyclerView
public class DBDVAdapter extends RecyclerView.Adapter<DBDVAdapter.DBDVViewHolder> {
    // Danh sách đơn vị cần truyền cho Adapter
    private final ArrayList<DBDV> dbdvs;

    // Constructor nhận danh sách đơn vị
    public DBDVAdapter(ArrayList<DBDV> dbdvs) {
        this.dbdvs = dbdvs;
    }

    // ViewHolder giúp ánh xạ trực tiếp item trong layout vào RecyclerView
    public static class DBDVViewHolder extends RecyclerView.ViewHolder {
        // Khai báo các component trong một CardView
        ImageView ivDVSymbol;
        TextView tvDVName, tvDVAddress, tvDVId;  // Thêm TextView ID

        // Hàm khởi tạo ViewHolder
        public DBDVViewHolder(View itemView) {
            super(itemView);
            // Ánh xạ các component từ layout
            ivDVSymbol = itemView.findViewById(R.id.ivDVSymbol);
            tvDVName = itemView.findViewById(R.id.tvDVName);
            tvDVAddress = itemView.findViewById(R.id.tvDVAddress);
            tvDVId = itemView.findViewById(R.id.tvDVId);  // Ánh xạ ID

            // Xử lý sự kiện click
            itemView.setOnClickListener(v -> {
                // Xác định đối tượng được click và gửi nó sang Activity tương ứng thông qua intent
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

    // Tạo ViewHolder và ánh xạ nó vào dbdv_item.xml
    @NonNull
    @Override
    public DBDVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dbdv_item, parent, false);
        return new DBDVViewHolder(view);
    }

    // Gắn dữ liệu vào ViewHolder
    @Override
    public void onBindViewHolder(@NonNull DBDVViewHolder holder, int position) {
        // Lấy đối tượng đơn vị ở vị trí hiện tại
        DBDV dbdv = dbdvs.get(position);
        holder.itemView.setTag(dbdv);  // Gán đối tượng cho itemView để xử lý sự kiện click

        // Gán dữ liệu từ đối tượng vào các thành phần giao diện
        holder.ivDVSymbol.setImageResource(dbdv.getSymbolImage());
        holder.tvDVName.setText(dbdv.getName());
        holder.tvDVAddress.setText(dbdv.getAddress());
        holder.tvDVId.setText(dbdv.getId());  // Gán giá trị ID vào TextView
    }

    // Trả về số lượng phần tử trong danh sách
    @Override
    public int getItemCount() {
        return dbdvs.size();
    }
}
