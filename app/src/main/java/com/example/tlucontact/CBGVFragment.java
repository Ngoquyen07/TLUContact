package com.example.tlucontact;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class CBGVFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<CBGV> cbgvs;
    ArrayList<CBGV> foundcbgv;
    CBGVSearchViewModel cbgvSearchViewModel;


    public CBGVFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cbgv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvCBGV);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        cbgvSearchViewModel = new ViewModelProvider(requireActivity()).get(CBGVSearchViewModel.class);
        cbgvs = new ArrayList<>();

        cbgvs.add(new CBGV(R.drawable.male, "email1@example.com", "GV001", "Nguyễn Văn A", "0987654321", "Giáo viên", "Đại học Thủy Lợi"));
        cbgvs.add(new CBGV(R.drawable.female, "email2@example.com", "GV002", "Trần Thị B", "0971234567", "Giáo viên", "Đại học Thủy Lợi"));
        cbgvs.add(new CBGV(R.drawable.male, "email3@example.com", "GV003", "Lê Văn C", "0967890123", "Hiệu trưởng", "Đại học Thủy Lợi"));
        cbgvs.add(new CBGV(R.drawable.female, "email4@example.com", "GV004", "Phạm Thị D", "0912345678", "Phó hiệu trưởng", "Đại học Thủy Lợi"));
        cbgvs.add(new CBGV(R.drawable.male, "email5@example.com", "GV005", "Hoàng Văn E", "0923456789", "Tổ trưởng bộ môn", "Đại học Thủy Lợi"));
        cbgvs.add(new CBGV(R.drawable.female, "email6@example.com", "GV006", "Đặng Thị F", "0934567890", "Giáo viên", "Đại học Thủy Lợi"));
        cbgvs.add(new CBGV(R.drawable.male, "email7@example.com", "GV007", "Bùi Văn G", "0945678901", "Giáo viên", "Đại học Thủy Lợi"));
        cbgvs.add(new CBGV(R.drawable.female, "email8@example.com", "GV008", "Ngô Thị H", "0956789012", "Trợ giảng", "Đại học Thủy Lợi"));
        cbgvs.add(new CBGV(R.drawable.male, "email9@example.com", "GV009", "Dương Văn I", "0967890123", "Giáo viên", "Đại học Thủy Lợi"));
        cbgvs.add(new CBGV(R.drawable.female, "email10@example.com", "GV010", "Vũ Thị K", "0978901234", "Giáo viên", "Đại học Thủy Lợi"));
        foundcbgv = new ArrayList<>(cbgvs);
        adapter = new CBGVAdapter(getContext(), foundcbgv);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        cbgvSearchViewModel.getSearchCBGV().observe(getViewLifecycleOwner(), query -> {
            filterData(query);
        });
    }
    private void filterData(String query) {
        foundcbgv.clear(); // Xóa danh sách hiện tại
        if (query.isEmpty()) {
            foundcbgv.addAll(cbgvs); // Hiển thị toàn bộ nếu không nhập gì
        } else {
            boolean check = true;
            // Chuyển về chữ thường để tìm kiếm không phân biệt hoa/thường
            for (CBGV item : cbgvs) {
                if (item.getId().contains(query)) {
                    foundcbgv.add(item);
                    check = false;
                }
            }
            if(check){
                Toast.makeText(getContext(), "Không tìm thấy kết quả", Toast.LENGTH_SHORT).show();
            }
        }
        adapter.notifyDataSetChanged(); // Cập nhật RecyclerView
    }
}