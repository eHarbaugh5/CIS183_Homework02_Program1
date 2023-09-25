package com.example.homework02_program1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter
{


    Context context;
    ArrayList<Color> listOfColors;

    public ColorListAdapter(Context c, ArrayList<Color> ls)
    {
        //  overloaded constructor
        context = c;
        listOfColors = ls;

    }


    @Override
    public int getCount() {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfColors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null)
        {
            //  find the custom_cell
            LayoutInflater mInflator = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflator.inflate(R.layout.custom_cell, null);

        }

        //  find the GUI elements in custom_cell   view. accesses functions for the view
        TextView redValue = view.findViewById(R.id.tv_v_c_red);
        TextView greenValue = view.findViewById(R.id.tv_v_c_green);
        TextView blueValue = view.findViewById(R.id.tv_v_c_blue);


        //  get the information you want from listOfColors.get(i);
        Color color = listOfColors.get(i);

        //  .setText("") with that information
        redValue.setText("Red: " + color.getRed());
        greenValue.setText("Green: " + color.getGreen());
        blueValue.setText("Blue: " + color.getBlue());

        //  then return the view we created
        return view;
    }



}
