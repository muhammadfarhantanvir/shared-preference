package com.example.sharedpreferenceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    TextView tvResult;
    Button btnSubmit;

    public final static String MY_PREF_FILENAME = "com.example.sharedpreferenceexample.Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        tvResult = findViewById(R.id.tvResult);
        btnSubmit = findViewById(R.id.btnSubmit);

        SharedPreferences pref = getSharedPreferences(MY_PREF_FILENAME, MODE_PRIVATE);
        String user = pref.getString("user", null);

        tvResult.setText("Welcome to my App! " + user);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                tvResult.setText("Welcome to my App! " + name);

                SharedPreferences.Editor editor = getSharedPreferences(MY_PREF_FILENAME, MODE_PRIVATE).edit();
                editor.putString("user", name);
                editor.commit();



            }
        });
    }
}
