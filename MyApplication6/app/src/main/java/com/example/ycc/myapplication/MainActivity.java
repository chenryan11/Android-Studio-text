package com.example.ycc.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {
    String Red,Green,Blue;
    int R1,G1,B1=0;
    SeekBar Redsb,Greensb,Bluesb;
    TextView Redv,Greenv,Bluev;
    TextView tvcolor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvcolor = (TextView)findViewById(R.id.tvcolor);

        Redv = (TextView)findViewById(R.id.Redv);
        Greenv = (TextView)findViewById(R.id.Greenv);
        Bluev = (TextView)findViewById(R.id.Bluev);

        Redsb = (SeekBar)findViewById(R.id.Redsb);
        Greensb = (SeekBar)findViewById(R.id.Greensb);
        Bluesb = (SeekBar)findViewById(R.id.Bluesb);

        tvcolor.setBackgroundColor(Color.rgb(R1,G1,B1));

        //Red
        Redsb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser)
            {
                // TODO Auto-generated method stub
                Redv.setText("Value:"+String.valueOf(progress));
                Red = Integer.toString(progress);
                R1 = Integer.parseInt(Red);
                Change();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                // TODO Auto-generated method stub
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                // TODO Auto-generated method stub
            }
        });
        //Green
        Greensb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser)
            {
                // TODO Auto-generated method stub
                Greenv.setText("Value:"+String.valueOf(progress));
                Green = Integer.toString(progress);
                G1 = Integer.parseInt(Green);
                Change();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                // TODO Auto-generated method stub
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                // TODO Auto-generated method stub
            }
        });
        //Blue
        Bluesb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser)
            {
                // TODO Auto-generated method stub
                Bluev.setText("Value:"+String.valueOf(progress));
                Blue = Integer.toString(progress);
                B1 = Integer.parseInt(Blue);
                Change();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                // TODO Auto-generated method stub
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                // TODO Auto-generated method stub
            }
        });
    }
    private void Change()
    {
        try
        {
            tvcolor.setBackgroundColor(Color.rgb(R1, G1, B1));
        }catch (Exception ex) { }
    }
}
