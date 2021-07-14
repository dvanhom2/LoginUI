package com.example.loginbg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class MainActivity extends AppCompatActivity {
View daySky, nightSky;
ImageView sun,moon,dayscape,nightscape;
Button login,signup;
DayNightSwitch dayNightSwitch;
TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sun =findViewById(R.id.sun);
        moon = findViewById(R.id.moon);
        dayscape =findViewById(R.id.day_landscape);
        nightscape =findViewById(R.id.night_landscape);
        daySky = findViewById(R.id.day_bg);
        nightSky =findViewById(R.id.night_bg);
        welcome =findViewById(R.id.welcome);
        login =findViewById(R.id.login);
        signup =findViewById(R.id.signup);
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
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v  ) {
                    Intent i = new Intent(MainActivity.this , Login.class);
                    startActivity(i);
                }
            });
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a = new Intent(MainActivity.this,SignUp.class);
                    startActivity(a);
                }
            });
    }
}