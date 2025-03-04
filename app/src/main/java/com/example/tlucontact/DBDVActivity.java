package com.example.tlucontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DBDVActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbdvactivity);

        Toolbar toolbar = findViewById(R.id.toolbar_dbdv);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Hiện nút back
            getSupportActionBar().setTitle("Danh bạ đơn vị"); // Đặt tiêu đề
        }

        TextView tvId = findViewById(R.id.txt_id_dbdv);
        ImageView ivAvatar = findViewById(R.id.img_avatar_dbdv);
        TextView tvName = findViewById(R.id.txt_name_dbdv);
        TextView tvAddress = findViewById(R.id.txt_address_dbdv);
        TextView tvPhone = findViewById(R.id.txt_phone_dbdv);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String id = intent.getStringExtra("ID");
        String name = intent.getStringExtra("NAME");
        String address = intent.getStringExtra("ADDRESS");
        String phone = intent.getStringExtra("PHONE");
        int avatar = intent.getIntExtra("AVATAR", R.drawable.computer);

        // Hiển thị dữ liệu
        ivAvatar.setImageResource(avatar);
        tvId.setText("ID: " + id);
        tvName.setText("Tên đơn vị: " + name);
        tvAddress.setText("Địa chỉ: " + address);
        tvPhone.setText("Số điện thoại: " + phone);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Đóng Activity khi bấm back
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
