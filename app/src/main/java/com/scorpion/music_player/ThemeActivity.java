package com.scorpion.music_player;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.pixplicity.easyprefs.library.Prefs;

public class ThemeActivity extends AppCompatActivity {
    private Button button;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        getSupportActionBar().setTitle("Themes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        String data = Prefs.getString("Theme", "");

        button = findViewById(R.id.Black);
        Button white = findViewById(R.id.White);
        if (data == "Night") {
            button.setText("Light Theme");
        } else {
            button.setText("Dark Theme");
        }

        white.setOnClickListener(v ->{
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        button.setOnClickListener(v -> {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }

    public void changeBg() {
        Intent intent = new Intent(this, PlayerActivity.class);
        startActivity(intent);
    }
}