package com.example.awesomefat.linkedlist;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StackActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);

        TOHCore.tower1 = new TowerFragment();
        TOHCore.tower2 = new TowerFragment();
        TOHCore.tower3 = new TowerFragment();
        this.getSupportFragmentManager().beginTransaction().add(R.id.tower1, TOHCore.tower1).commit();
        this.getSupportFragmentManager().beginTransaction().add(R.id.tower2, TOHCore.tower2).commit();
        this.getSupportFragmentManager().beginTransaction().add(R.id.tower3, TOHCore.tower3).commit();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        TOHCore.tower1.addDisk(4);
        TOHCore.tower1.addDisk(7);
        TOHCore.tower1.addDisk(10);
    }
}

