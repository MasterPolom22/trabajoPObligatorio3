package com.example.trabajoprcticoobligatorio3.data;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.trabajoprcticoobligatorio3.model.Producto;
public class ProductoRepository {


    private static ProductoRepository INSTANCE;

    private final List<Producto> backing = new ArrayList<>();
    private final MutableLiveData<List<Producto>> productosLive = new MutableLiveData<>(new ArrayList<>());

    private ProductoRepository() {
        // Seed de prueba (BORRAR luego)
        try {
            agregarProducto("A1", "Azúcar", 123.45);
            agregarProducto("C3", "Café", 999.99);
            agregarProducto("B2", "Arroz", 456.78);
        } catch (Exception ignored) { }
    }

    public static synchronized ProductoRepository getInstance() {
        if (INSTANCE == null) INSTANCE = new ProductoRepository();
        return INSTANCE;
    }

    public LiveData<List<Producto>> getProductos() {
        return productosLive;
    }

    public synchronized Producto buscarPorCodigo(String codigo) {
        if (codigo == null) return null;
        String needle = codigo.trim();
        if (needle.isEmpty()) return null;
        for (Producto p : backing) {
            if (p.getCodigo().equalsIgnoreCase(needle)) return p;
        }
        return null;
    }



    /**
     * Agrega validando:
     * - campos no vacíos
     * - precio > 0- se vio en la ultima clase las validaciones
     * - código único
     * Lanza IllegalArgumentException con mensaje para mostrar en UI.
     */
    public synchronized void agregarProducto(String codigo, String descripcion, double precio) {
        codigo = safe(codigo);
        descripcion = safe(descripcion);

        if (codigo.isEmpty()) throw new IllegalArgumentException("El código es obligatorio.");
        if (descripcion.isEmpty()) throw new IllegalArgumentException("La descripción es obligatoria.");
        if (precio <= 0) throw new IllegalArgumentException("El precio debe ser mayor que cero.");

        for (Producto p : backing) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                throw new IllegalArgumentException("Ya existe un producto con ese código.");
            }
        }

        backing.add(new Producto(codigo, descripcion, precio));
        // Ordenar por descripción (asc, case-insensitive)
        Collections.sort(backing, new Comparator<Producto>() {
            @Override public int compare(Producto a, Producto b) {
                return a.getDescripcion().compareToIgnoreCase(b.getDescripcion());
            }
        });

        productosLive.setValue(new ArrayList<>(backing)); // nueva lista para disparar observadores
    }

    private String safe(String s) { return s == null ? "" : s.trim(); }
}
