package com.desafiolatam.prueba3.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.desafiolatam.prueba3.R;
import com.desafiolatam.prueba3.data.Nodes;
import com.desafiolatam.prueba3.models.Pokemon;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseError;

/**
 * Created by amuno on 15-10-2017.
 */

public class PokemonsAdapter extends FirebaseRecyclerAdapter<Pokemon, PokemonsAdapter.PokemonHolder> {

    public PokemonsAdapter() {
        super(Pokemon.class, R.layout.list_item_pokemons, PokemonHolder.class, new Nodes().pokemons());

    }


    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

    @Override
    protected void populateViewHolder(PokemonsAdapter.PokemonHolder viewHolder, Pokemon model, int position) {
        TextView textViewnumber = viewHolder.id;
        textViewnumber.setText(model.getId());
        TextView textView = viewHolder.name;
        textView.setText(model.getName());
    }


    public static class PokemonHolder extends RecyclerView.ViewHolder {
        private TextView id,name;

        public PokemonHolder(View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.idTv);
            name = (TextView) itemView.findViewById(R.id.nameTv);
        }
    }

}
