package com.example.tlucontact;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ButtonFragment extends Fragment {

    Button btnDBDV, btnCBGV;
    EditText etSearch;
    Button btnSearch, btnRefesh;
    TextView tvState;
    private Btnclick  btnclick;
    FragmentCurrentViewModel viewModel;
    CBGVSearchViewModel cbgvSearchViewModel;

    DBDVSearchViewModel dbdvSearchViewModel;
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
        viewModel = new ViewModelProvider(requireActivity()).get(FragmentCurrentViewModel.class);
        cbgvSearchViewModel = new ViewModelProvider(requireActivity()).get(CBGVSearchViewModel.class);
        dbdvSearchViewModel = new ViewModelProvider(requireActivity()).get(DBDVSearchViewModel.class);

        viewModel.setCurrentFragmentId(R.id.btnDBDV);
        btnCBGV = view.findViewById(R.id.btnCBGV);
        btnDBDV = view.findViewById(R.id.btnDBDV);
        tvState = view.findViewById(R.id.tvState);
        etSearch = view.findViewById(R.id.etSearch);
        btnSearch = view.findViewById(R.id.btnSearch);
        btnRefesh = view.findViewById(R.id.btnRefesh);

        btnCBGV.setOnClickListener(v ->{
            btnclick.onBtnclick(R.id.btnCBGV);
            tvState.setText("Danh bạ giảng viên");
            viewModel.setCurrentFragmentId(R.id.btnCBGV);
        });
        btnDBDV.setOnClickListener(v ->{
            btnclick.onBtnclick(R.id.btnDBDV);
            tvState.setText("Danh bạ đơn vị");
            viewModel.setCurrentFragmentId(R.id.btnDBDV);
        });
        btnSearch.setOnClickListener(v ->{
            String searchText = etSearch.getText().toString().toUpperCase();
            int currentFragmentId = viewModel.getCurrentFragmentId().getValue();
            if(currentFragmentId == R.id.btnCBGV){
                cbgvSearchViewModel.setSearchCBGV(searchText);
            }
            else if(currentFragmentId == R.id.btnDBDV) {
                dbdvSearchViewModel.setSearchDBDV(searchText);
            }
        });
        btnRefesh.setOnClickListener(v -> {
            int currentFragmentId = viewModel.getCurrentFragmentId().getValue();
            if (currentFragmentId == R.id.btnCBGV) {
                cbgvSearchViewModel.setSearchCBGV(""); // Reset tìm kiếm giảng viên
            } else if (currentFragmentId == R.id.btnDBDV) {
                dbdvSearchViewModel.setSearchDBDV(""); // Reset tìm kiếm đơn vị
            }
            etSearch.setText(""); // Xóa nội dung trong ô tìm kiếm
        });
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        btnclick = (Btnclick) context;
    }
}