package com.desafiolatam.prueba3.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.desafiolatam.prueba3.R;
import com.desafiolatam.prueba3.data.Nodes;
import com.desafiolatam.prueba3.models.Pokemon;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

/**
 * Created by amuno on 15-10-2017.
 */

public class PokemonsFavoritesAdapter extends FirebaseRecyclerAdapter <Pokemon,PokemonsFavoritesAdapter.PokemonHolder> {

    public PokemonsFavoritesAdapter() {
        super(Pokemon.class, R.layout.list_item_pokemons_favorites, PokemonHolder.class, new Nodes().favorites());

    }


    @Override
    protected void populateViewHolder(PokemonsFavoritesAdapter.PokemonHolder viewHolder, Pokemon model, int position) {
        viewHolder.idf.setText(model.getId());
        viewHolder.namef.setText(model.getName());

    }

    public static class PokemonHolder extends RecyclerView.ViewHolder {
        private TextView idf,namef;

        public PokemonHolder(View itemView) {
            super(itemView);

          //  idf = (TextView) itemView.findViewById(R.id.idfTv);
            namef = (TextView) itemView.findViewById(R.id.namefTv);
        }
    }

}