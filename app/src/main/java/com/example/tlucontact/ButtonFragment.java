package com.example.tlucontact;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ButtonFragment extends Fragment {

    Button btnDBDV, btnCBGV;
    TextView tvState;
    private Btnclick  btnclick;
    public interface Btnclick{
        void onBtnclick(int fragmentId);
    }
    public ButtonFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_button, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCBGV = view.findViewById(R.id.btnCBGV);
        btnDBDV = view.findViewById(R.id.btnDBDV);
        tvState = view.findViewById(R.id.tvState);
        btnCBGV.setOnClickListener(v ->{
            btnclick.onBtnclick(R.id.btnCBGV);
            tvState.setText("Danh bạ giảng viên");
        });
        btnDBDV.setOnClickListener(v ->{
            btnclick.onBtnclick(R.id.btnDBDV);
            tvState.setText("Danh bạ đơn vị");
        });
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        btnclick = (Btnclick) context;
    }
}