/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea6;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 *
 * @author amoreno
 */
public abstract class AdaptadorPaquetes extends BaseAdapter{
    private final Context context;
    private final int resourceUI;
    private final String [] paquetes;

    public AdaptadorPaquetes(Context context, int resourceUI, String[] paquetes) {
        this.context = context;
        this.resourceUI = resourceUI;
        this.paquetes = paquetes;
    }
    

    public int getCount() {
        return paquetes.length;
    }

    public Object getItem(int position) {
        return paquetes[position];
    }

    public long getItemId(int position) {
        return -1;
    }

    public View getView(int position, View view, ViewGroup parent) {
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resourceUI, null);
        }
        onDisplayRow(view, position);
        return view;
    }
    public abstract void onDisplayRow(View view, int pos);    
}
