package com.desafiolatam.prueba3.conection;

import com.desafiolatam.prueba3.data.Nodes;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by amuno on 15-10-2017.
 */

public class UserValidation {

    public void init (String email){

        if(email.trim().length()>0){
            if(email.contains("@")){

                FirebaseUser currentEmail=new CurrentUser().getCurrentUser();//ojo decia email ejercises
                if(!email.equals(currentEmail)){
                findUser(email);

                }else{
                    callback.error("Error ingrese nuevamente");
                }
            }else{
                callback.error("Error ingrese nuevamente");

            }
        }else{
            callback.error("Error ingrese nuevamente");

        }
    }

    private void fibdUser(String email){
        new Nodes().toString().
    }
}
