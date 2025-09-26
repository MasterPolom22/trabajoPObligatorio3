package com.example.trabajoprcticoobligatorio3.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.trabajoprcticoobligatorio3.databinding.ItemProductoBinding;
import com.example.trabajoprcticoobligatorio3.model.Producto;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.VH> {
    private final List<Producto> items = new ArrayList<>();
    private final DecimalFormat df = new DecimalFormat("#,##0.00");

    public void setItems(List<Producto> nuevos) {
        items.clear();
        if (nuevos != null) items.addAll(nuevos);
        notifyDataSetChanged();
    }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductoBinding b = ItemProductoBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new VH(b);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        Producto p = items.get(position);
        h.tvCodigo.setText(p.getCodigo());
        h.tvDescripcion.setText(p.getDescripcion());
        h.tvPrecio.setText("$ " + df.format(p.getPrecio()));
    }

    @Override
    public int getItemCount() { return items.size(); }

    static class VH extends RecyclerView.ViewHolder {
        TextView tvCodigo, tvDescripcion, tvPrecio;
        VH(ItemProductoBinding b) {
            super(b.getRoot());
            tvCodigo = b.tvCodigo;
            tvDescripcion = b.tvDescripcion;
            tvPrecio = b.tvPrecio;
        }
    }
}
