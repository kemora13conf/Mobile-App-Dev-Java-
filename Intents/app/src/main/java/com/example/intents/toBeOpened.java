package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class toBeOpened extends AppCompatActivity {
    TextView t = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_be_opened);
        t = (TextView) findViewById(R.id.text1);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String name = b.getString("name");
        t.setText("Hello Mr. "+name);
    }
    public void goBack(View v){
        Intent newIntent = new Intent(this, MainActivity.class);
        startActivity(newIntent);
    }
}