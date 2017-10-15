package com.desafiolatam.prueba3.data;

import com.desafiolatam.prueba3.conection.CurrentUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
/**
 * Created by amuno on 15-10-2017.
 */

public class Nodes {


    private DatabaseReference root = FirebaseDatabase.getInstance().getReference();

    public DatabaseReference pokemons (){
        return root.child("pokemons");
    }

    public DatabaseReference favorites () {
        return root.child("favorites").child(new CurrentUser().getCurrentUser().getUid());
    }

}
