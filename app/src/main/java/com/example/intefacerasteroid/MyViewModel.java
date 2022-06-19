package com.example.intefacerasteroid;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<User> User;
    private MutableLiveData<String> IpNumber;
    public LiveData<String> getIpNumber() {
        if (IpNumber == null) {
            IpNumber = new MutableLiveData<String>();
            populateIpList();
            return IpNumber;
        }
        return IpNumber;
    }
    private void populateIpList() {
        IpNumber.setValue("192.34.56.7");
    }
    public LiveData<User> getUser() {
        if (User == null) {
            User = new MutableLiveData<User>();
            return User;
        }
        return User;
    }

}
