package com.example.loginbg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.accounts.Account;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Admin extends AppCompatActivity {
    View daySky, nightSky;
    ImageView sun,moon;
    DayNightSwitch dayNightSwitch;
    SlidrInterface sld;
    ArrayList<UserAccount> listItem;
    DataBaseHelper myDB;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        daySky = findViewById(R.id.day_bg);
        nightSky = findViewById(R.id.night_bg);
        sun = findViewById(R.id.sun);
        moon = findViewById(R.id.moon);
        sld = Slidr.attach(Admin.this);
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(Admin.this));
        recyclerView.setHasFixedSize(true);
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
        DataBaseHelper myDB = new DataBaseHelper(Admin.this);
        List<UserAccount> account = myDB.getAccountList();

        if (account.size()>0){
            RecycleAdapter adapter = new RecycleAdapter(account,Admin.this);

        }else {
            Toast.makeText(this,"Ko co data",Toast.LENGTH_SHORT).show();
        }
    }
}