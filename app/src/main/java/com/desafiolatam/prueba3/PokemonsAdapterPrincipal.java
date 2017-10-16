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
        return PokemonsFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 0;
    }
}
