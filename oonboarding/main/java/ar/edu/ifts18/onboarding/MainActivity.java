 package ar.edu.ifts18.onboarding;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    static final String PREFS = "prefs_onboarding";
    static final String KEY_FINALIZADO = "onboarding_done";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp = getSharedPreferences(PREFS, MODE_PRIVATE);
        boolean done = sp.getBoolean(KEY_FINALIZADO, false);

        if(!done){
            startActivity(new Intent(this, OnboardingActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_main);
    }
}