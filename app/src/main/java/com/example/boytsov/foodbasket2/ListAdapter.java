package com.example.boytsov.foodbasket2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Boytsov on 27.08.2015.
 */
public class ListAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Product> objects;

    ListAdapter(Context context, ArrayList<Product> products) {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.myitem, parent, false);
        }
        Product p = getProduct(position);
        ((TextView) view.findViewById(R.id.tvDescr)).setText(p.name_product);
        if(p.IsStrikeout()) {

            ((TextView) view.findViewById(R.id.tvDescr)).setPaintFlags(16);
            ((TextView) view.findViewById(R.id.tvDescr)).setBackgroundColor(Color.parseColor("#77dd77"));

        }
        else{

            ((TextView) view.findViewById(R.id.tvDescr)).setPaintFlags(0);
            ((TextView) view.findViewById((R.id.tvDescr))).setBackgroundColor(Color.TRANSPARENT);

        }

        return view;
    }
    // товар по позиции
    Product getProduct(int position) {
        return ((Product) getItem(position));
    }

}
