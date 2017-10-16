package com.desafiolatam.prueba3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

public class PokemonsAdapter extends FirebaseRecyclerAdapter<Pokemon,PokemonsAdapter.PokemonHolder> {

    private Context context;
    private Pokemon pokemon;
    private String id;

    public PokemonsAdapter(DatabaseReference ref, Context context) {
        super(Pokemon.class, R.layout.fragment_item_list, PokemonHolder.class, ref);
        this.context = context;
    }

    @Override
    protected void populateViewHolder(final PokemonHolder viewHolder, Pokemon model, int position) {
        TextView textView = viewHolder.content;
        textView.setText(model.getContent());
        TextView textViewnumber = viewHolder.id;
        textViewnumber.setText(model.getId());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pokemon = getItem(viewHolder.getAdapterPosition());
                id = pokemon.getContent().replace(" ", "").toLowerCase();
                final DatabaseReference dbref = new Nodes().favorites().child(id);
                dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Pokemon poke = dataSnapshot.getValue(Pokemon.class);
                        if (poke == null || poke.toString().trim().length()==0) {
                            new Nodes().favorites().child(id).setValue(pokemon);
                            Toast.makeText(context, "Agrega a favorito " + dbref, Toast.LENGTH_SHORT).show();
                        } else {
                            new Nodes().favorites().child(id).removeValue();
                            Toast.makeText(context, "Elimina de favorito " + dbref, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }

    public static class PokemonHolder extends RecyclerView.ViewHolder{

private TextView content,id;

        public PokemonHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.idTv);
            content = (TextView) itemView.findViewById(R.id.contentTv);
        }
    }

}
