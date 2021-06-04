package com.streamliners.npta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     * For the status
     */
    private boolean isRunning;
    /**
     * For text view to show letters
     */
    private TextView tv;
    /**
     * For start stop button
     */
    private Button btn;
    /**
     * For the character
     */
    private char ch = 65;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the text view and button
        tv = findViewById(R.id.textView);
        btn = findViewById(R.id.button);

        // Set on click listener to the button
        btn.setOnClickListener(view -> {
            // Change the status
            isRunning = !isRunning;
            // Change the text of the button
            if (isRunning) btn.setText(R.string.title_btn_stop); else btn.setText(R.string.title_btn_start);
        });
        // Start the game
        play();
    }

    /**
     * To play the game
     */
    private void play() {
        // Declare new handler
        Handler handler = new Handler();

        // Start the handler
        handler.post(new Runnable() {
            @Override
            public void run() {
                // Check for the size of the characters in ASCII
                if (ch == 91) ch = 65;
                // Set the letter to the text view
                tv.setText(String.valueOf(ch));
                // Check the status and increase the character
                if (isRunning) ch++;

                // Do the time gap
                handler.postDelayed(this, 50);
            }
        });
    }
}