package com.example.bttl_buoi7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Boolean saved;
    private  int mCount = 0;
    private String sharedPrefFile = "com.example.sharedprefs";

    private Button resetBtn;
    int backgroundColor = Color.WHITE;
    private int textColor = Color.WHITE;

//    private SharedPreferences sharedPreferences;
//    private static final String SHARED_PREF_NAME = "my_shared_pref";
//    private static final String COUNTER_KEY = "counter";

    private String BACKGROUND_COLOR_KEY = "background_color";
    private String TEXT_COLOR_KEY = "text_color";

    LinearLayout layout;
    Button buttonBlack, buttonRed, buttonBlue, buttonGreen, buttonCounter;
    TextView textView;

    //App Settting
    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        saved = sharedPreferences.getBoolean("remember_choice", false);
        System.out.println("Save your choice: "+saved);
        if(saved == true){
            SharedPreferences mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
            SharedPreferences.Editor preferencesEditor = mPreferences.edit();
            preferencesEditor.putInt("count", mCount);
            preferencesEditor.putInt("color", backgroundColor);
            preferencesEditor.clear();
            preferencesEditor.apply();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }
//settingsBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, MySettingsActivity.class);
//                startActivity(i);
//            }
//        });
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(MainActivity.this, MySettingsActivity.class);
        switch (item.getItemId()){
            case R.id.item_preferences:
                intent.putExtra("setting", "setting");
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        layout = findViewById(R.id.layout);
        layout.setBackgroundColor(Color.WHITE);

        buttonRed = findViewById(R.id.btn_red);
        buttonRed.setBackgroundColor(Color.RED);

        buttonBlue = findViewById(R.id.btn_blue);
        buttonBlue.setBackgroundColor(Color.BLUE);

        buttonBlack = findViewById(R.id.btn_black);
        buttonBlack.setBackgroundColor(Color.BLACK);

        buttonGreen = findViewById(R.id.btn_green);
        buttonGreen.setBackgroundColor(Color.GREEN);

        buttonCounter = findViewById(R.id.btn_count);
        buttonCounter.setBackgroundColor(Color.TRANSPARENT);
        buttonCounter.setTextColor(Color.BLACK);

        textView = findViewById(R.id.txt_count);
        textView.setText(String.valueOf(mCount));
        textView.setTextColor(textColor);

        resetBtn = findViewById(R.id.btn_reset);

        //App Settings
        SharedPreferences mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        if (savedInstanceState == null){
            mCount = mPreferences.getInt("count", mCount);
            textView.setText(String.valueOf(mCount));
            backgroundColor = mPreferences.getInt("color", backgroundColor);
            layout.setBackgroundColor(backgroundColor);
        }

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCount = 0;
                textView.setText(String.valueOf(mCount));
                layout.setBackgroundColor(Color.GRAY);
            }
        });

        //App Settings
//        settingsBtn = findViewById(R.id.idBtnSettings);
//        settingsBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, MySettingsActivity.class);
//                startActivity(i);
//            }
//        });



        //SharedPreferences
        //PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

//        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
//        int counter = sharedPreferences.getInt(COUNTER_KEY, 0); // Lấy giá trị của biến đếm, mặc định là 0 nếu không có giá trị
//
//
//        if (sharedPreferences.contains(BACKGROUND_COLOR_KEY)) {
//            backgroundColor = sharedPreferences.getInt(BACKGROUND_COLOR_KEY, Color.WHITE);
//        }
//
//        if (sharedPreferences.contains(TEXT_COLOR_KEY)) {
//            textColor = sharedPreferences.getInt(TEXT_COLOR_KEY, Color.BLACK);
//        }

        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor = Color.GREEN;
                textColor = Color.WHITE;
                layout.setBackgroundColor(backgroundColor);
                textView.setTextColor(textColor);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putInt(BACKGROUND_COLOR_KEY, backgroundColor);
//                editor.putInt(TEXT_COLOR_KEY, textColor);
//                editor.apply();
            }
        });

        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor = Color.RED;
                textColor = Color.WHITE;
                layout.setBackgroundColor(backgroundColor);
                textView.setTextColor(textColor);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putInt(BACKGROUND_COLOR_KEY, backgroundColor);
//                editor.putInt(TEXT_COLOR_KEY, textColor);
//                editor.apply();
            }
        });
        buttonBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor = Color.BLACK;
                textColor = Color.WHITE;
                layout.setBackgroundColor(backgroundColor);
                textView.setTextColor(textColor);
                textView.setTextColor(Color.WHITE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putInt(BACKGROUND_COLOR_KEY, backgroundColor);
//                editor.putInt(TEXT_COLOR_KEY, textColor);
//                editor.apply();
            }
        });
        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor = Color.BLUE;
                textColor = Color.WHITE;
                layout.setBackgroundColor(backgroundColor);
                textView.setTextColor(textColor);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putInt(BACKGROUND_COLOR_KEY, backgroundColor);
//                editor.putInt(TEXT_COLOR_KEY, textColor);
//                editor.apply();
            }
        });


        buttonCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int counter = sharedPreferences.getInt(COUNTER_KEY, 0);
                //counter++;
                mCount++;
                textView.setText(String.valueOf(mCount));
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putInt(COUNTER_KEY, counter);
//                editor.apply();
            }
        });

    }

}