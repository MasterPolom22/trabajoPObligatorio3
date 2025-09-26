package com.example.trabajoprcticoobligatorio3.ui.salir;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SalirViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SalirViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el Fragment de salida jajaja  fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}