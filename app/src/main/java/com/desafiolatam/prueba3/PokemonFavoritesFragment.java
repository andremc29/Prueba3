package com.desafiolatam.prueba3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desafiolatam.prueba3.adapters.PokemonsFavoritesAdapter;


public class PokemonFavoritesFragment extends Fragment {
    private PokemonsFavoritesAdapter adapter;

    public  static PokemonFavoritesFragment newInstance(){
        return PokemonFavoritesFragment.newInstance();
    }

    public PokemonFavoritesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_pokemons, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.pokemonsfRv);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);


        recyclerView.setAdapter(adapter);


        return view;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
      //  void onListFragmentInteraction(PokemonItem item);
    }
}
