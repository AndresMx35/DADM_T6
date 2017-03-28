/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea6;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
public class FragmentoDos extends Fragment{
    String [] internet = {"15 Días -> $1,000", "3 Meses -> $5,000","9 Meses -> $12,000", "12 Meses -> $22,000"};
    String [] television = {"15 Días -> $6,000", "3 Meses -> $10,000","9 Meses -> $17,000", "12 Meses -> $27,000"};
    String [] radio = {"15 Días -> $4,000", "3 Meses -> $6,000","9 Meses -> $13,000", "12 Meses -> $18,000"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View vista = inflater.inflate(R.layout.fragmento_dos, null);
        TextView tvTipoElegido = (TextView)vista.findViewById(R.id.tipoElegido);
        actualizaPaquetes(null, vista);
        
        tvTipoElegido.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            public void afterTextChanged(Editable s) {
                actualizaPaquetes(s.toString(), vista);
            }
        });
        return vista;
    }
    public void actualizaPaquetes(String tipo, View vista)
    {
        final String paquetes[];
        if(tipo != null)
        {
            if(tipo.toLowerCase().contains("internet"))
            {
                paquetes = internet;
            }else if(tipo.toLowerCase().contains("television"))
            {
                paquetes = television;
            }else if(tipo.toLowerCase().contains("radio"))
            {
                paquetes = radio;
            }
        }
        else
        {
            paquetes = internet;
        }
        ListView listPaquetes = (ListView) vista.findViewById(R.id.listPaquetes);
        listPaquetes.setAdapter(new AdaptadorPaquetes(vista.getContext(), R.layout.renglon_paquetes, paquetes) {
            @Override
            public void onDisplayRow(View view, final int pos) {
                TextView tv = (TextView) view.findViewById(R.id.textRenglonPaquetes);
                RadioButton radio = (RadioButton) view.findViewById(R.id.radioRenglonPaquetes);
                
                tv.setText(paquetes[pos]);
                radio.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        pasarActivity(paquetes[pos]);
                    }
                });
            }
        });
    }
    private void pasarActivity(String paquete)
    {
        TextView textActivity = (TextView) this.getActivity().findViewById(R.id.textActivity);
        textActivity.setText("Paquete elegido: "+ paquete);
    }
}
