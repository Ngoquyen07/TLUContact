package com.example.tlucontact;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CBGVSearchViewModel extends ViewModel {
    private MutableLiveData<String> searchCBGV = new MutableLiveData<>();
    public void setSearchCBGV(String query) {
        searchCBGV.setValue(query);
    }
    public MutableLiveData<String> getSearchCBGV() {
        return searchCBGV;
    }
}
