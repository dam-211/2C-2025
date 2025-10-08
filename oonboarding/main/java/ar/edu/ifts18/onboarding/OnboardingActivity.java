package ar.edu.ifts18.onboarding;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class OnboardingActivity extends AppCompatActivity {

    static final String PREFS = "prefs_onboarding";
    static final String KEY_FINALIZADO = "onboarding_done";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        if(savedInstanceState == null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.onboardingContainer, new OnboardingStep1Fragment())
                    .commit();
        }
    }

    void onBoardingPaso2() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.onboardingContainer, new OnboardingStep2Fragment())
                .addToBackStack(null)
                .commit();

    }

    void finalizarOnboarding() {

        SharedPreferences sp = getSharedPreferences(PREFS, MODE_PRIVATE);
        sp.edit().putBoolean(KEY_FINALIZADO, true).apply();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
