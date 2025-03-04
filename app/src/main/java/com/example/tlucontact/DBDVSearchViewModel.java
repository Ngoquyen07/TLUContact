package com.example.tlucontact;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DBDVSearchViewModel extends ViewModel {
    private MutableLiveData<String> searchDBDV = new MutableLiveData<>();
    public void setSearchDBDV(String query) {
        searchDBDV.setValue(query);
    }
    public MutableLiveData<String> getSearchDBDV() {
        return searchDBDV;
    }
}
