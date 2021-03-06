package com.desafiolatam.prueba3.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.desafiolatam.prueba3.R;
import com.desafiolatam.prueba3.data.Nodes;
import com.desafiolatam.prueba3.models.Pokemon;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by amuno on 15-10-2017.
 */

public class PokemonsFavoritesAdapter extends FirebaseRecyclerAdapter <Pokemon,PokemonsFavoritesAdapter.PokemonHolder> {
    private Pokemon pokemon;
    private Context context;
    private String key;

    public PokemonsFavoritesAdapter(DatabaseReference favorites, Context context) {
        super(Pokemon.class, R.layout.list_item_pokemons_favorites, PokemonHolder.class, new Nodes().favorites());

    }


    @Override
    protected void populateViewHolder(final PokemonsFavoritesAdapter.PokemonHolder viewHolder, Pokemon model, int position) {
      //  viewHolder.idf.setText(model.getId());
        viewHolder.namef.setText(model.getName());
        TextView textView = viewHolder.namef;
        textView.setText(model.getName());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pokemon = getItem(viewHolder.getAdapterPosition());
                key = pokemon.getName().replace(" ", "").toLowerCase();
                DatabaseReference dbref = new Nodes().favorites().child(key);
                dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Pokemon pm = dataSnapshot.getValue(Pokemon.class);
                        if (pm == null) {
                            new Nodes().favorites().child(key).setValue(pokemon);
                            Toast.makeText(context, "Agrega a Favoritos", Toast.LENGTH_SHORT).show();
                        } else {
                            new Nodes().favorites().child(key).removeValue();
                            Toast.makeText(context, "Removido de Favoritos", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    public static class PokemonHolder extends RecyclerView.ViewHolder {
        private TextView namef;

        public PokemonHolder(View itemView) {
            super(itemView);

            namef = (TextView) itemView.findViewById(R.id.namefTv);
        }
    }

}