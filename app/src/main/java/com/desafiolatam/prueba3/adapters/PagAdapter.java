package com.desafiolatam.prueba3.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.desafiolatam.prueba3.PokemonFavoritesFragment;
import com.desafiolatam.prueba3.PokemonsFragment;

/**
 * Created by amuno on 20-10-2017.
 */

public class PagAdapter extends FragmentPagerAdapter {
    public PagAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
     switch (position) {
         case 0:
             return PokemonsFragment.newInstance();
         case 1:
             return PokemonFavoritesFragment.newInstance();
         default:
             return PokemonsFragment.newInstance();

     }
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "GeneralON 1";
            case 1:
                return "SFFFECTION 2";
            default:
                return "GeneralON 1";
        }

    }
}
