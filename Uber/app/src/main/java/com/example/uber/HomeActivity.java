package com.example.uber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String mName = getIntent().getExtras().getString("studentName");
        TextView nameTextView = findViewById(R.id.textView2);
        nameTextView.setText(mName);
    }
}