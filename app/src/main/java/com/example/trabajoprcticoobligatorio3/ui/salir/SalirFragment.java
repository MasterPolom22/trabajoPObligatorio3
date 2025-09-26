package com.example.trabajoprcticoobligatorio3.ui.salir;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.AlertDialog;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trabajoprcticoobligatorio3.databinding.FragmentSalirBinding;


public class SalirFragment extends Fragment {

    private FragmentSalirBinding binding;



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Layout vacío opcional; no es estrictamente necesario
            return new View(requireContext());
        }

        @Override
        public void onResume() {
            super.onResume();
            new AlertDialog.Builder(requireContext())
                    .setTitle("Salir")
                    .setMessage("¿Deseás cerrar la aplicación?")
                    .setPositiveButton("Sí, salir", (d, w) -> requireActivity().finishAffinity())
                    .setNegativeButton("Cancelar", (d, w) -> requireActivity().onBackPressed())
                    .setCancelable(true)
                    .show();
        }
}