package ar.edu.ifts18.shred;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        textViewGreeting = findViewById(R.id.textViewGreeting);
        Button buttonBack = findViewById(R.id.buttonBack);

        loadData();

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.MY_PREFS, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(MainActivity.NAME_KEY, "Invitado");

        textViewGreeting.setText("Hola, " + name + "!");
    }
}
