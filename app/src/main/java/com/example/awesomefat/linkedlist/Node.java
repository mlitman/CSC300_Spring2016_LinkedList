package com.example.awesomefat.linkedlist;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by awesomefat on 1/28/16.
 */
public class Node
{
    private String payload;
    private Node nextNode;
    private TextView valueLabel;
    private LinearLayout theLayout;

    public Node(String payload)
    {
        this.payload = payload;
        this.nextNode = null;

    }

    public void textClicked(View v)
    {
        System.out.println("***** Text Was Clicked: " + this.payload);
    }

    public void display(LinearLayout layout)
    {
        final Node myself = this;
        this.theLayout = layout;
        View v = ListCore.inflater.inflate(R.layout.node, null);
        this.valueLabel = (TextView) v.findViewById(R.id.theValueTF);
        this.valueLabel.setText(this.payload);
        this.valueLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Right now, we "hide" this text label and prove that we can find "myself"
                //in the Linked List.  Update this to remove myself from the linked list
                //and then ask the list to display itself, which should update the entire
                //view.  That is to say, we will no longer need to hide ourself.
                System.out.println("***** Text Was Clicked: " + payload);
                valueLabel.setVisibility(View.GONE);
                System.out.println("**** Position = " + ListCore.ll.indexOf(myself));

            }
        });
        layout.addView(v);

        if(this.nextNode != null)
        {
            this.nextNode.display(layout);
        }
    }

    public String getPayload()
    {
        return payload;
    }

    public void setPayload(String payload)
    {
        this.payload = payload;
    }

    public Node getNextNode()
    {
        return nextNode;
    }

    public void setNextNode(Node nextNode)
    {
        this.nextNode = nextNode;
    }
}
