package com.example.trabajoprcticoobligatorio3.busqueda;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.example.trabajoprcticoobligatorio3.data.ProductoRepository;
import com.example.trabajoprcticoobligatorio3.model.Producto;

public class DetalleViewModel extends ViewModel {

    private final ProductoRepository repo = ProductoRepository.getInstance();
    private final MutableLiveData<Producto> _producto = new MutableLiveData<>();
    public LiveData<Producto> producto = _producto;

    public DetalleViewModel(SavedStateHandle savedStateHandle) {
        String codigo = savedStateHandle.get("codigo");
        _producto.setValue(codigo != null ? repo.buscarPorCodigo(codigo) : null);
    }
}
