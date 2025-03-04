package com.example.tlucontact;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//ViewModel nhận và gửi ID giảng viên can tìm
public class CBGVSearchViewModel extends ViewModel {
    private MutableLiveData<String> searchCBGV = new MutableLiveData<>();
    //Gửi ID
    public void setSearchCBGV(String query) {
        searchCBGV.setValue(query);
    }
    //Nhận ID
    public MutableLiveData<String> getSearchCBGV() {
        return searchCBGV;
    }
}
