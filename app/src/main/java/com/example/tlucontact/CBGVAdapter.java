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
public class CBGVAdapter extends RecyclerView.Adapter<CBGVAdapter.CBGVViewHolder> {
    // Danh sách giảng viên cần truyền cho Adapter
    private final ArrayList<CBGV> cbgvs;

    // Constructor nhận danh sách giảng viên
    public CBGVAdapter(ArrayList<CBGV> cbgvs) {
        this.cbgvs = cbgvs;
    }

    // ViewHolder giúp ánh xạ trực tiếp item trong layout vào RecyclerView
    static public class CBGVViewHolder extends RecyclerView.ViewHolder {
        // Khai báo các component trong một CardView
        ImageView ivGVAvatar;
        TextView tvGVId;
        TextView tvGVName;
        TextView tvGVAddress;

        // Hàm khởi tạo ViewHolder
        public CBGVViewHolder(View itemView) {
            super(itemView);
            // Ánh xạ các component từ layout
            ivGVAvatar = itemView.findViewById(R.id.ivGVAvatar);
            tvGVId = itemView.findViewById(R.id.tvGVId);
            tvGVName = itemView.findViewById(R.id.tvGVName);
            tvGVAddress = itemView.findViewById(R.id.tvGVAddress);

            // Xử lý sự kiện click
            itemView.setOnClickListener(v -> {
                // Xác định đối tượng được click và gửi nó sang Activity tương ứng thông qua intent
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

    // Tạo ViewHolder và ánh xạ nó vào cbgv_item.xml
    @NonNull
    @Override
    public CBGVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cbgv_item, parent, false);
        return new CBGVViewHolder(view);
    }

    // Gắn dữ liệu vào ViewHolder
    @Override
    public void onBindViewHolder(@NonNull CBGVViewHolder holder, int position) {
        // Lấy đối tượng giảng viên ở vị trí hiện tại
        CBGV cbgv = cbgvs.get(position);
        holder.itemView.setTag(cbgv);  // Gán đối tượng cho itemView để xử lý sự kiện click

        // Gán dữ liệu từ đối tượng vào các thành phần giao diện
        holder.ivGVAvatar.setImageResource(cbgv.getAvatarImage());
        holder.tvGVId.setText(cbgv.getId());
        holder.tvGVName.setText(cbgv.getName());
        holder.tvGVAddress.setText(cbgv.getEmail());
    }

    // Trả về số lượng phần tử trong danh sách
    @Override
    public int getItemCount() {
        return cbgvs.size();
    }
}
