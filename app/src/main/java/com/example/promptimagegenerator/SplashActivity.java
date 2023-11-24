package com.example.promptimagegenerator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.promptimagegenerator.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView splashImageView = findViewById(R.id.splashImageView);
        Button nextButton = findViewById(R.id.nextButton);

        // Load the GIF using Glide
        Glide.with(this)
                .load(R.drawable.ai)
                .into(splashImageView);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the next activity when the button is clicked
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });

        // Delay for SPLASH_DELAY milliseconds and then move to the next activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                nextButton.setVisibility(View.VISIBLE); // Make the button visible after the delay
            }
        }, SPLASH_DELAY);
    }
}
