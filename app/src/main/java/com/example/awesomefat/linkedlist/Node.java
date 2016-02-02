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
    private LinearLayout layout;

    public Node(String payload)
    {
        this.payload = payload;
        this.nextNode = null;

    }

    public void display(LinearLayout layout)
    {
        View v = ListCore.inflater.inflate(R.layout.node, null);
        TextView tf = (TextView) v.findViewById(R.id.theValueTF);
        tf.setText(this.payload);
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
