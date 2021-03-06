package com.example.modernartui;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;

import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    SeekBar sb = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*TextView View[] = {(TextView) findViewById(R.id.purplebox)
                , (TextView) findViewById(R.id.redbox)
                , (TextView) findViewById(R.id.whitebox)
                , (TextView) findViewById(R.id.bluebox)
                , (TextView) findViewById(R.id.pinkbox)};*/
        TextView cyanbox = (TextView) findViewById(R.id.cyanbox);
        TextView redbox = (TextView) findViewById(R.id.redbox);
        TextView whitebox = (TextView) findViewById(R.id.whitebox);
        TextView bluebox = (TextView) findViewById(R.id.bluebox);
        TextView pinkbox = (TextView) findViewById(R.id.pinkbox);

        sb = (SeekBar) findViewById(R.id.slider);
        sb.setMax(100);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                int[] redArray = {255, 0, 0};
                int[] blueArray = {0, 0, 255};
                int[] greenArray = {0, 255, 0};

                redArray[0] = redArray[0] - (255/100)*progress;
                redArray[1] = redArray[1] + (229/100)*progress;
                redArray[2] = redArray[2] + (238/100)*progress;
                blueArray[0] = blueArray[0] + (255/100)*progress;
                blueArray[1] = blueArray[1] + (102/100)*progress;
                blueArray[2] = blueArray[2] - (255/100)*progress;
                greenArray[0] = greenArray[0] - (125/100)*progress;
                greenArray[1] = greenArray[1] - (255/100)*progress;
                greenArray[2] = greenArray[2] + (130/100)*progress;


                cyanbox.setBackgroundColor(Color.rgb(blueArray[0],greenArray[1],blueArray[2]));
                redbox.setBackgroundColor(Color.rgb(redArray[0],redArray[1],redArray[2]));
                whitebox.setBackgroundColor(Color.rgb(redArray[0],greenArray[1],blueArray[2]));
                bluebox.setBackgroundColor(Color.rgb(blueArray[0],blueArray[1],blueArray[2]));
                pinkbox.setBackgroundColor(Color.rgb(redArray[0],blueArray[1],blueArray[2]));
                /*for (int j = 0; j < View.length; j++) {
                    TextView text = View[j];
                    if (!text.getTag().toString().equals("#FFFFFF")||!text.getTag().toString().equals("#FF0000")) {
                            text.setBackgroundColor(getColorbyProgress(progress,text));
                    }
                }*/
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public int getColorbyProgress(int progress,TextView textView) {
        int startColor = Color.parseColor(textView.getTag().toString());

        int start_red = Color.red(startColor);
        int start_green = Color.green(startColor);
        int start_blue = Color.blue(startColor);

        int progress_red = start_red + (255-start_red)/100*progress;
        int progress_green = start_green +(255-start_green)/100* progress;
        int progress_blue = start_blue + (255-start_blue)/100*progress;

        int progress_color = Color.rgb(progress_red, progress_green, progress_blue);
        return progress_color;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI..
                new dialog().showDialog(this);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}