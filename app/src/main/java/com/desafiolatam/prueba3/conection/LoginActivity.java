package com.desafiolatam.prueba3.conection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.desafiolatam.prueba3.MainActivity;
import com.desafiolatam.prueba3.R;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ResultCodes;

import java.util.Arrays;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LoginActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 144;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        if (new CurrentUser().getCurrentUser() != null) {
            logged();
        } else {
            signUp();
        }
    }

    private void signUp() {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setProviders(Arrays.asList(
                                new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build()
                        ))
                        .build(),
                RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (RC_SIGN_IN == requestCode) {
            if (ResultCodes.OK == resultCode) {
                logged();
            }

        }

    }

    private void logged() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
