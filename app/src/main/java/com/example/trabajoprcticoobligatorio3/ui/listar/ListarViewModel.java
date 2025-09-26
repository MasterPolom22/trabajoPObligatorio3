package com.example.trabajoprcticoobligatorio3.ui.listar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;

import com.example.trabajoprcticoobligatorio3.data.ProductoRepository;
import com.example.trabajoprcticoobligatorio3.model.Producto;
public class ListarViewModel extends ViewModel {

    private final ProductoRepository repo = ProductoRepository.getInstance();
    public LiveData<List<Producto>> productos = repo.getProductos();
}