package com.example.awesomefat.linkedlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StackActivity extends AppCompatActivity
{
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);

        TextView title = (TextView)this.findViewById(R.id.stackTitle);
        title.setText("Count = " + count);
        this.count++;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        TextView title = (TextView)this.findViewById(R.id.stackTitle);
        title.setText("Count = " + count);
        this.count++;
    }
}
