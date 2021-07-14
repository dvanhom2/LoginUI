package com.example.loginbg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class Login extends AppCompatActivity {
    View daySky, nightSky;
    ImageView sun,moon,dayscape,nightscape;
    Button login,signup;
    DayNightSwitch dayNightSwitch;
    CheckBox checkBox;
    EditText user, pass;
    SlidrInterface sld;
    DataBaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sun =findViewById(R.id.sun);
        moon = findViewById(R.id.moon);
        dayscape =findViewById(R.id.day_landscape);
        nightscape =findViewById(R.id.night_landscape);
        daySky = findViewById(R.id.day_bg);
        nightSky =findViewById(R.id.night_bg);
        login =findViewById(R.id.login);
        signup =findViewById(R.id.signup);
        user =findViewById(R.id.user);
        pass =findViewById(R.id.pass);
        sld = Slidr.attach(Login.this);
        myDB = new DataBaseHelper(Login.this);
        checkBox = findViewById(R.id.checkbox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        dayNightSwitch =findViewById(R.id.day_night_switch);
        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                if(is_night){
                    sun.animate().translationY(200).setDuration(1300);
                    moon.animate().translationY(-250).setDuration(1300);
                    dayscape.animate().alpha(0).setDuration(1300);
                    daySky.animate().alpha(0).setDuration(1300);
                }else{
                    moon.animate().translationY(200).setDuration(1300);
                    sun.animate().translationY(-20).setDuration(1300);
                    dayscape.animate().alpha(1).setDuration(1300);
                    daySky.animate().alpha(1).setDuration(1300);
                }
            }
        });
        loginUser();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a =  new Intent(Login.this , SignUp.class);
                startActivity(a);
            }
        });

    }
    private  void loginUser(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = user.getText().toString();
                String b = pass.getText().toString();
                if (a.isEmpty()||b.isEmpty()){
                    Toast.makeText(Login.this, "Không được để trống", Toast.LENGTH_SHORT).show();
                }else{
                    boolean c= myDB.checkUserPass(b,a);
                    if(c = true){
                        Intent d = new Intent(Login.this,Home.class);
                        Toast.makeText(Login.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                        startActivity(d);
                    }else{
                        Toast.makeText(Login.this,"Sai mật khẩu hoặc tên đăng nhập",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}