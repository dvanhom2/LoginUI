package com.example.loginbg;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.GestureDescription;
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
import android.widget.TextView;
import android.widget.Toast;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity {
    View daySky, nightSky;
    ImageView sun,moon,dayscape,nightscape;
    Button signup;
    DayNightSwitch dayNightSwitch;
    CheckBox checkBox;
    EditText user, pass ,email,id;
    SlidrInterface sld;
   public static DataBaseHelper myDB ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sun = findViewById(R.id.sun);
        moon = findViewById(R.id.moon);
        dayscape = findViewById(R.id.day_landscape);
        nightscape = findViewById(R.id.night_landscape);
        daySky = findViewById(R.id.day_bg);
        nightSky = findViewById(R.id.night_bg);
        signup = findViewById(R.id.signup);
        sld = Slidr.attach(SignUp.this);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        email = findViewById(R.id.email);
        id = findViewById(R.id.id);
        checkBox = findViewById(R.id.checkbox);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        dayNightSwitch = findViewById(R.id.day_night_switch);
        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                if (is_night) {
                    sun.animate().translationY(200).setDuration(1300);
                    moon.animate().translationY(-250).setDuration(1300);
                    dayscape.animate().alpha(0).setDuration(1300);
                    daySky.animate().alpha(0).setDuration(1300);
                } else {
                    moon.animate().translationY(200).setDuration(1300);
                    sun.animate().translationY(-20).setDuration(1300);
                    dayscape.animate().alpha(1).setDuration(1300);
                    daySky.animate().alpha(1).setDuration(1300);
                }
            }
        });
        myDB  = new DataBaseHelper(SignUp.this);
        insertUser();
    }
    private void insertUser() {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String q = id.getText().toString();
                String a = user.getText().toString();
                String b = pass.getText().toString();
                String c =  email.getText().toString();
                if (q.isEmpty()|| a.isEmpty()||b.isEmpty()||c.isEmpty()){
                    Toast.makeText(SignUp.this,"Không được để trống",Toast.LENGTH_SHORT).show();
                }else {
                    boolean var = myDB.checkID(q);
                    if(var == false){
                        boolean U = myDB.checkUsername(a);
                        if (U == false){
                            boolean add = myDB.registerUser(q,a,b,c);
                                if (add == true){
                                    Toast.makeText(SignUp.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(SignUp.this,Login.class);
                                    startActivity(i);
                                }else {
                                    Toast.makeText(SignUp.this,"Đăng ký thất bại",Toast.LENGTH_SHORT).show();
                                }
                        }else {
                            Toast.makeText(SignUp.this,"Đã có User này",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(SignUp.this,"Đã có ID này",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
      }
    }
