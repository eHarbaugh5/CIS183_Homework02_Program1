package com.example.homework02_program1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    Button btn_j_saveColor;
    SeekBar sb_j_redValue;
    SeekBar sb_j_greenValue;
    SeekBar sb_j_blueValue;
    ListView lv_j_colorsList;
    ArrayList<Color> listOfColors;
    ColorListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_j_red = findViewById(R.id.tv_v_red);
        tv_j_green = findViewById(R.id.tv_v_green);
        tv_j_blue = findViewById(R.id.tv_v_blue);
        btn_j_saveColor = findViewById(R.id.btn_v_saveColor);
        lv_j_colorsList = findViewById(R.id.lv_v_colorsList);
        sb_j_redValue = findViewById(R.id.sb_v_redValue);
        sb_j_greenValue = findViewById(R.id.sb_v_greenValue);
        sb_j_blueValue = findViewById(R.id.sb_v_blueValue);

        listOfColors = new ArrayList<Color>();



        buttonClickEventHandler();
        fillListView();

    }

    private void buttonClickEventHandler()
    {

        btn_j_saveColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                //Log.d("Button Clicked", " Clicked ");
                addColor();
                //displayListOfColors();
                adapter.notifyDataSetChanged();


            }
        });

    }

    private void addColor()
    {

        //  testing
        Color testColor = new Color();
        testColor.setRed(25);
        testColor.setGreen(50);
        testColor.setBlue(100);

        //  this worked



        //  get the values from the seekbars
        //Color newColor = new Color(sb_v_redValue.getSomething, sb_v_greenValue.getSomething, sb_v_blueValue.getSomething);

        listOfColors.add(testColor);

    }

    private void displayListOfColors()
    {

        for (int i = 0; i < listOfColors.size(); i++)
        {
            Log.d("Color at: " + i, " " + listOfColors.get(i).getRed());
        }

    }

    private void fillListView()
    {
        //  create the adapter with this as the context
        adapter = new ColorListAdapter(this, listOfColors);
        lv_j_colorsList.setAdapter(adapter);

    }




}