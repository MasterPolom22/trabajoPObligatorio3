package com.example.trabajoprcticoobligatorio3.busqueda;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.text.DecimalFormat;

import com.example.trabajoprcticoobligatorio3.databinding.FragmentDetalleBinding;
import com.example.trabajoprcticoobligatorio3.model.Producto;

public class DetalleFragment extends Fragment{
    private FragmentDetalleBinding binding;
    private DetalleViewModel viewModel;
    private final DecimalFormat df = new DecimalFormat("#,##0.00");

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDetalleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(DetalleViewModel.class);

        // Fragment pasivo: solo observa y renderiza
        viewModel.producto.observe(getViewLifecycleOwner(), p -> {
            binding.tvDesc.setText("Descripción: " + (p != null ? p.getDescripcion() : ""));
            binding.tvCod.setText("Código: " + (p != null ? p.getCodigo() : ""));
            binding.tvPrecio.setText("Precio: " + (p != null ? "$ " + df.format(p.getPrecio()) : ""));
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
