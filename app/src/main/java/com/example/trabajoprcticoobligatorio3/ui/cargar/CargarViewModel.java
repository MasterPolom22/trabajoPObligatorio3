package com.example.trabajoprcticoobligatorio3.ui.cargar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.trabajoprcticoobligatorio3.data.ProductoRepository;
public class CargarViewModel extends ViewModel {



    private final ProductoRepository repo = ProductoRepository.getInstance();


    private final MutableLiveData<String> _mensaje = new MutableLiveData<>();
    public LiveData<String> mensaje = _mensaje;

    public void agregar(String codigo, String descripcion, String precioStr) {
        try {
            double precio = Double.parseDouble(precioStr.replace(",", "."));
            repo.agregarProducto(codigo, descripcion, precio);
            _mensaje.setValue("Producto agregado correctamente.");
        } catch (NumberFormatException e) {
            _mensaje.setValue("El precio debe ser numérico.");
        } catch (IllegalArgumentException e) {
            _mensaje.setValue(e.getMessage());
        }
    }
}