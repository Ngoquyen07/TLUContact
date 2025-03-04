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


public class DBDVFragment extends Fragment {


    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    DBDVSearchViewModel dbdvSearchViewModel;
    ArrayList<DBDV> dbdvs;
    ArrayList<DBDV> founddbdvs;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dbdv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvDBDV);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        dbdvSearchViewModel = new ViewModelProvider(requireActivity()).get(DBDVSearchViewModel.class);
        dbdvs = new ArrayList<>();
        dbdvs.add(new DBDV("Đại học Thủy Lợi", "DV01", "Khoa học máy tính", "0987654321", R.drawable.computer));
        dbdvs.add(new DBDV("Đại học Thủy Lợi", "DV02", "Cơ khí", "0971234567", R.drawable.cokhi));
        dbdvs.add(new DBDV("Đại học Thủy Lợi", "DV03", "Luật", "0967890123", R.drawable.law));
        dbdvs.add(new DBDV("Đại học Thủy Lợi", "DV04", "Tài nguyên nước", "0912345678", R.drawable.water));
        dbdvs.add(new DBDV("Đại học Thủy Lợi", "DV05", "Xây dựng", "0923456789", R.drawable.xaydung));
        founddbdvs = new ArrayList<>(dbdvs);
        adapter = new DBDVAdapter(getContext(),founddbdvs);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        dbdvSearchViewModel.getSearchDBDV().observe(getViewLifecycleOwner(), query -> {
            filterData(query);
        });


    }
    private void filterData(String query) {
        founddbdvs.clear(); // Xóa danh sách hiện tại
        if (query.isEmpty()) {
            founddbdvs.addAll(dbdvs); // Hiển thị toàn bộ nếu không nhập gì
        } else {
            boolean check = true;
            for (DBDV item : dbdvs) {
                if (item.getId().contains(query)) {
                    founddbdvs.add(item);
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