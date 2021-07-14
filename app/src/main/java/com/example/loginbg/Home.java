package com.example.loginbg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class Home extends AppCompatActivity {
    View daySky, nightSky;
    ImageView sun,moon,dayscape,nightscape;
    CardView logout,admin,other;
    DayNightSwitch dayNightSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sun =findViewById(R.id.sun);
        moon = findViewById(R.id.moon);
        dayscape =findViewById(R.id.day_landscape);
        nightscape =findViewById(R.id.night_landscape);
        daySky = findViewById(R.id.day_bg);
        nightSky =findViewById(R.id.night_bg);
        logout =findViewById(R.id.logout);
        admin   = findViewById(R.id.admin);
        other =findViewById(R.id.other);
        dayNightSwitch =findViewById(R.id.day_night_switch);
        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                if(is_night){
                    sun.animate().translationY(200).setDuration(1300);
                    moon.animate().translationY(-230).setDuration(1300);
                    dayscape.animate().alpha(0).setDuration(1300);
                    daySky.animate().alpha(0).setDuration(1300);
                }else{
                    moon.animate().translationY(200).setDuration(1300);
                    sun.animate().translationY(-10).setDuration(1300);
                    dayscape.animate().alpha(1).setDuration(1300);
                    daySky.animate().alpha(1).setDuration(1300);
                }
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,MainActivity.class);
                startActivity(i);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Home.this,Admin.class);
                startActivity(x);
            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z = new Intent(Home.this,Other.class);
                startActivity(z);
            }
        });
    }
}