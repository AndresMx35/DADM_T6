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
public abstract class AdaptadorTipos extends BaseAdapter{
    Context context;
    int resourceUI;
    String [] tipos;

    public AdaptadorTipos(Context context, int resourceUI, String[] tipos) {
        this.context = context;
        this.resourceUI = resourceUI;
        this.tipos = tipos;
    }
    
    public int getCount() {
        return tipos.length;
    }

    public Object getItem(int position) {
        return tipos[position];
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
