package com.example.tlucontact;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class DBDVFragment extends Fragment {


    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<DBDV> dbdvs;


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
        dbdvs = new ArrayList<>();
        dbdvs.add(new DBDV("Đại học Thủy Lợi","Khoa học máy tính",  "0987654321", R.drawable.computer));
        dbdvs.add(new DBDV("Đại học Thủy Lợi","Cơ khí",  "0971234567", R.drawable.cokhi));
        dbdvs.add(new DBDV("Đại học Thủy Lợi","Luật", "0967890123", R.drawable.law));
        dbdvs.add(new DBDV("Đại học Thủy Lợi","Tài nguyên nước", "0912345678", R.drawable.water));
        dbdvs.add(new DBDV("Đại học Thủy Lợi","Xây dựng",  "0923456789", R.drawable.xaydung));
        adapter = new DBDVAdapter(getContext(), dbdvs);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);





    }
}