package com.example.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.intents.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open(View v){
        Intent i = new Intent(this, toBeOpened.class);
        i.putExtra("name", "Abdelghani");
        startActivity(i);
    }
    public void GetName(View v){
        Uri telephone = Uri.parse("mailto:abdo@gmail.com");
        Intent i = new Intent(Intent.ACTION_SENDTO, telephone);
        startActivity(i);

    }

    public void gotoGoogle(View v){
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intent);
    }
}