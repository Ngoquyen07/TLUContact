package com.example.tlucontact;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
//ViewModel giúp xác dinh danh sách giảng viên hoặc đơn vị đang hiển thị
public class FragmentCurrentViewModel extends ViewModel {
    //nhận biết thông qua ID của button
    private final MutableLiveData<Integer> currentFragmentId = new MutableLiveData<>();

    // Cập nhật ID của button thực hiện thao tác nhấn
    public void setCurrentFragmentId(int fragmentId) {
        currentFragmentId.setValue(fragmentId);
    }
    // Lấy ra ID của button
    public LiveData<Integer> getCurrentFragmentId() {
        return currentFragmentId;
    }
}
