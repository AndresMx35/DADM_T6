/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea6;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 *
 * @author amoreno
 */
public class FragmentoUno extends Fragment{
    String [] tipos = {"Internet", "Televisión", "Radio"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view  = inflater.inflate(R.layout.fragmento_uno, null);
        ListView listTipos = (ListView)view.findViewById(R.id.listTipos);
        listTipos.setAdapter(new AdaptadorTipos(view.getContext(), R.layout.renglon_tipos, tipos) {
            @Override
            public void onDisplayRow(View view, final int pos) {
                TextView tv = (TextView) view.findViewById(R.id.textRenglonTipo);
                RadioButton radio = (RadioButton) view.findViewById(R.id.radioRenglonTipo);
                
                tv.setText(tipos[pos]);
                radio.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        pasarSeleccion(pos);
                    }
                });
            }
        });
        return view;
    }
    public void pasarSeleccion(int pos)
    {
        //
    }
}
