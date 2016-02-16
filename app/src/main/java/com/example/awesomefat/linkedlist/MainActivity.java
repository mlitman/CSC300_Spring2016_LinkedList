package com.example.awesomefat.linkedlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button addFrontButton;
    private Button addEndButton;
    private Button removeFrontButton;
    private Button removeEndButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        //let ListCore know about me
        ListCore.mainActivity = this;

        //give ourselves programmatic access to the buttons and edit text
        this.addFrontButton = (Button)this.findViewById(R.id.addFrontButton);
        this.addEndButton = (Button)this.findViewById(R.id.addEndButton);
        this.removeFrontButton = (Button)this.findViewById(R.id.removeFrontButton);
        this.removeEndButton = (Button)this.findViewById(R.id.removeEndButton);
        ListCore.newValueEditText = (EditText)this.findViewById(R.id.newValueET);

        ListCore.inflater = this.getLayoutInflater();

        LinearLayout svLL = (LinearLayout)this.findViewById(R.id.scrollViewLL);
        ListCore.ll = new LinkedList(svLL);
        //ll.addFront("1");
        //ll.addFront("2");
        //ll.addFront("3");
        //ll.addFront("4");
        //ll.display();
        ListCore.ll.addEnd("6");
        ListCore.ll.addEnd("7");
        ListCore.ll.addEnd("8");
        ListCore.ll.display();

        /*
        View v;
        for(int i = 0; i < 10; i++)
        {
            v = this.getLayoutInflater().inflate(R.layout.node, null);
            TextView tf = (TextView) v.findViewById(R.id.theValueTF);
            tf.setText("" + i);
            svLL.addView(v);
        }
        */
    }

    public void stackButtonClicked(View sender)
    {
        Intent i = new Intent(this, StackActivity.class);
        this.startActivity(i);
    }

    public void aButtonClicked(View sender)
    {
        if(sender == this.addFrontButton)
        {
            System.out.println("**** add front button pressed");
            System.out.println("adding: " + ListCore.newValueEditText.getText());
            ListCore.ll.addFront(ListCore.newValueEditText.getText().toString());
        }
        else if(sender == this.addEndButton)
        {
            System.out.println("**** add end button pressed");
            System.out.println("adding: " + ListCore.newValueEditText.getText());
            ListCore.ll.addEnd(ListCore.newValueEditText.getText().toString());
        }
        else if(sender == this.removeFrontButton)
        {
            System.out.println("**** remove front button pressed");
            ListCore.ll.removeFront();
        }
        else if(sender == this.removeEndButton)
        {
            System.out.println("**** remove end button pressed");
            ListCore.ll.removeEnd();
        }
        ListCore.ll.display();
    }
}
