package com.desafiolatam.prueba3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by amuno on 15-10-2017.
 */

public class PokemonsAdapterPrincipal extends FragmentPagerAdapter {


    public PokemonsAdapterPrincipal(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PokemonsFragment.newInstance();
            case 1:
                return FavoriteFragment.newIntance();

            default:
                return PokemonsFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
