package com.example.trabajoprcticoobligatorio3.busqueda;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajoprcticoobligatorio3.data.ProductoRepository;
import com.example.trabajoprcticoobligatorio3.model.Producto;

public class BusquedaViewModel extends ViewModel {

    private final ProductoRepository repo = ProductoRepository.getInstance();

    private final MutableLiveData<String> _mensaje = new MutableLiveData<>();
    public LiveData<String> mensaje = _mensaje;

    private final MutableLiveData<Bundle> _argsDetalle = new MutableLiveData<>();
    public LiveData<Bundle> argsDetalle = _argsDetalle;

    public void buscarPorCodigo(String codigoInput) {
        String cod = codigoInput == null ? "" : codigoInput.trim();
        if (cod.isEmpty()) {
            _mensaje.setValue("Ingresá un código.");
            return;
        }
        Producto p = repo.buscarPorCodigo(cod);
        if (p == null) {
            _mensaje.setValue("No se encontró ningún producto con ese código.");
            return;
        }
        _mensaje.setValue("Producto encontrado.");
        // El VM arma los argumentos de navegación (el Fragment solo observa y navega)
        Bundle args = new Bundle();
        args.putString("codigo", p.getCodigo());
        _argsDetalle.setValue(args);
    }
}
