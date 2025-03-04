package com.example.tlucontact;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragmentCurrentViewModel extends ViewModel {
    private final MutableLiveData<Integer> currentFragmentId = new MutableLiveData<>();

    public void setCurrentFragmentId(int fragmentId) {
        currentFragmentId.setValue(fragmentId);
    }

    public LiveData<Integer> getCurrentFragmentId() {
        return currentFragmentId;
    }
}
