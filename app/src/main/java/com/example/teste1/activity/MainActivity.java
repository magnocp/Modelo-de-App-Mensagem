package com.example.teste1.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.teste1.Adapter.TabAdapter;
import com.example.teste1.R;
import com.example.teste1.implementacao.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private SlidingTabLayout alinhaAbas;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar_principal);
        toolbar.setTitle("Bem-Vindo");
        setSupportActionBar(toolbar);

        alinhaAbas = (SlidingTabLayout) findViewById(R.id.stl_abas);
        viewPager = (ViewPager) findViewById(R.id.vp_pagina);

        // configurando slider
        alinhaAbas.setDistributeEvenly(true);
        alinhaAbas.setSelectedIndicatorColors(ContextCompat.getColor(this, R.color.corAbaixo));

        //configurando adapter
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);

        alinhaAbas.setViewPager(viewPager);

    }

    // colocando o menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    //escolhendo as opções do menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.item_sair:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                return true;
            case R.id.item_settings:
                return true;
            case R.id.item_adicionar:
                abrirCadastroContato();
                return true;
             default:
                 return super.onOptionsItemSelected(item);
        }

    }

    private void abrirCadastroContato(){

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Dialog);
        // condigurando
        alertDialog.setTitle("Novo contato");
        alertDialog.setMessage("Telefone do novo contato");
        alertDialog.setCancelable(false);

        EditText editText = new EditText(MainActivity.this);
        alertDialog.setView(editText);

        alertDialog.setPositiveButton("Cadastrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.create();
        alertDialog.show();


    }

}
