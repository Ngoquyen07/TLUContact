package com.example.tlucontact;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
// View model nhận và gửi ID đơn vị
public class DBDVSearchViewModel extends ViewModel {
    private MutableLiveData<String> searchDBDV = new MutableLiveData<>();
    // Gửi ID
    public void setSearchDBDV(String query) {
        searchDBDV.setValue(query);
    }
    // Nhận ID
    public MutableLiveData<String> getSearchDBDV() {
        return searchDBDV;
    }
}
