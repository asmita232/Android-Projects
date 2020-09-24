package com.example.uber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String KEYNAME = "keyname";
    public static final String KEYPWD = "keypwd";
    public static final String SHAREDPREF = "sharedpref";
    //    private static final String
    EditText nameEditText, passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.editTextPhone);
        passwordEditText = findViewById(R.id.editTextTextPassword);

    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    private void saveData() {
        //get data from edittext
        String name = nameEditText.getText().toString();
        String pwd = nameEditText.getText().toString();

        //create a file in shared preference named sharedpref
        SharedPreferences preferences = getSharedPreferences("sharedpref", MODE_PRIVATE);

        //open, write, save the file
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEYNAME,name);
        editor.putString(KEYPWD,pwd);
        editor.commit();

    }
    //the values from sharedpref should be visible in edittexts and even after hitting back button
    // we should be able to get back values
    private void restoreData() {
        SharedPreferences preferences = getSharedPreferences(SHAREDPREF, MODE_PRIVATE);
//        String name = preferences.getString(KEYNAME, defValue: "");
        String name = preferences.getString(KEYNAME,"");
        String password = preferences.getString(KEYPWD, "");
//        String password = preferences.getString(KEYPWD);
        nameEditText.setText(name);
        passwordEditText.setText(password);

    }

    public void clickListener(View view) {
        String name = nameEditText.getText().toString();
        Toast.makeText(this, "Welcome" + name + "to Uber", Toast.LENGTH_SHORT).show();
        Intent hIntent = new Intent(MainActivity.this, HomeActivity.class);
        hIntent.putExtra("studentName", name);
        startActivity(hIntent);
    }
}