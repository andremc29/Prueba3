package com.desafiolatam.prueba3;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private PokemonsAdapter pokemonsAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pokemonsAdapter = new PokemonsAdapter(getSupportFragmentManager());


        // Set up the ViewPager with the sections adapter.
        viewPager = (ViewPager) findViewById(R.id.containerMain);
        viewPager.setAdapter(pokemonsAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }



}
