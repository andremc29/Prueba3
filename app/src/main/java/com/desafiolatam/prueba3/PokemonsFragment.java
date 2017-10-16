package com.desafiolatam.prueba3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desafiolatam.prueba3.data.Nodes;

public class PokemonsFragment extends Fragment {
    private PokemonsAdapter adapter;
    private int estado = 0;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @SuppressLint("ValidFragment")
    public PokemonsFragment(int estado) {
        switch (this.estado = estado) {
        }
    }

    public PokemonsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemons, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.pokemonsRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        if (getEstado() == 0) {
            adapter = new PokemonsAdapter(new Nodes().pokemons(), getContext());
        } else if (getEstado() > 0) {
            adapter = new PokemonsAdapter(new Nodes().favorites(), getContext());
        }


        recyclerView.setAdapter(adapter);


    }

    public static Fragment newInstance(int tipo) {
        return new PokemonsFragment();
    }
}
