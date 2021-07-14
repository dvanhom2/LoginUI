package com.example.loginbg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class Other extends AppCompatActivity {
    View daySky, nightSky;
    ImageView sun,moon,dayscape,nightscape;
    CardView setting, aboutme,caculator;
    DayNightSwitch dayNightSwitch;
    SlidrInterface sld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        sun =findViewById(R.id.sun);
        moon = findViewById(R.id.moon);
        dayscape =findViewById(R.id.day_landscape);
        nightscape =findViewById(R.id.night_landscape);
        daySky = findViewById(R.id.day_bg);
        nightSky =findViewById(R.id.night_bg);
        setting =findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anotherpage();
            }
        });
        aboutme =findViewById(R.id.aboutme);
        aboutme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anotherpage();
            }
        });
        caculator = findViewById(R.id.caculator);
        caculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anotherpage();
            }
        });
        sld = Slidr.attach(this);
        dayNightSwitch = findViewById(R.id.day_night_switch);
        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                if (is_night) {
                    sun.animate().translationX(300).setDuration(1300);
                    moon.animate().translationX(-5).setDuration(1300);
                    daySky.animate().alpha(0).setDuration(1300);
                } else {
                    moon.animate().translationX(300).setDuration(1300);
                    sun.animate().translationX(-10).setDuration(1300);
                    daySky.animate().alpha(1).setDuration(1300);
                }
            }
        });
    }

    private void    anotherpage (){
        Intent intent = new Intent(Other.this,Page.class);
        startActivity(intent);
    }
    }
