package com.example.teste1.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.teste1.fragmentos.ContatosFragment;
import com.example.teste1.fragmentos.ConversasFragment;

public class TabAdapter extends FragmentStatePagerAdapter {

    private String [] titulosAbas = {"CONVERSAS", "CONTATOS"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragmento = null;

        switch (position){
            case 0:
                fragmento = new ConversasFragment();
                break;
            case 1:
                fragmento = new ContatosFragment();
                break;
        }

        return fragmento;
    }

    @Override
    public int getCount() {
        return titulosAbas.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titulosAbas[position];
    }
}
