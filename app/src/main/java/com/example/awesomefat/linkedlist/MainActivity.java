package com.example.awesomefat.linkedlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        LinearLayout svLL = (LinearLayout)this.findViewById(R.id.scrollViewLL);
        LinkedList ll = new LinkedList(svLL);
        ll.display();

        /*

        View v;
        for(int i = 0; i < 1000; i++)
        {
            v = this.getLayoutInflater().inflate(R.layout.node, null);
            svLL.addView(v);
        }
        */
    }

    public void theButtonClicked(View sender)
    {
        //I want to change the text on my label
    }
}
