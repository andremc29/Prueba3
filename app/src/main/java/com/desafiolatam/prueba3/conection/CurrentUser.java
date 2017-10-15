package com.desafiolatam.prueba3.conection;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by amuno on 15-10-2017.
 */

public class CurrentUser {
    private FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

    public FirebaseUser getCurrentUser() {
        return currentUser;
    }
}
