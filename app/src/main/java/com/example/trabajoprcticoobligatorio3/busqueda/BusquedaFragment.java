package com.example.trabajoprcticoobligatorio3.busqueda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import com.example.trabajoprcticoobligatorio3.R;

import com.example.trabajoprcticoobligatorio3.databinding.FragmentBusquedaBinding;

public class BusquedaFragment extends Fragment{
    private FragmentBusquedaBinding binding;
    private BusquedaViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBusquedaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(BusquedaViewModel.class);

        binding.btnBuscar.setOnClickListener(v ->
                viewModel.buscarPorCodigo(binding.etCodigoBuscar.getText().toString())
        );

        viewModel.mensaje.observe(getViewLifecycleOwner(), msg ->
                binding.tvMensajeBusqueda.setText(msg == null ? "" : msg)
        );

        viewModel.argsDetalle.observe(getViewLifecycleOwner(), args -> {
            if (args == null) return;
            NavHostFragment.findNavController(this)
                    .navigate(R.id.nav_detalle, args);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
