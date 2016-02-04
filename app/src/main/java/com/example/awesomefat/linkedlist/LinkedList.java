package com.example.awesomefat.linkedlist;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by awesomefat on 1/28/16.
 */
public class LinkedList
{
    private Node head;
    private LinearLayout layout;

    public LinkedList(LinearLayout layout)
    {
        this.head = null;
        this.layout = layout;
    }

    public void display()
    {
        //changed
        //this.layout.removeAllViews();
        if(this.head == null)
        {
            View v = ListCore.inflater.inflate(R.layout.node, null);
            TextView tf = (TextView) v.findViewById(R.id.theValueTF);
            tf.setText("Empty List");
            this.layout.addView(v);
        }
        else
        {
            //display the list in a reasonable format
            this.head.display(this.layout);
        }
        View v = ListCore.inflater.inflate(R.layout.node, null);
        TextView tf = (TextView) v.findViewById(R.id.theValueTF);
        tf.setText("_____________");
        this.layout.addView(v);
    }

    public void addFront(String value)
    {
        //this adds a new Node to the front of the list with payload == value
        Node n = new Node(value);
        n.setNextNode(this.head);
        this.head = n;
    }

    public Node removeFront()
    {
        //this removes and returns the Node that is currently sitting at the
        //front of the list.  The new front of the list, should be the old
        //second node or null in the event it was a 1-list
        Node nodeToReturn = this.head;
        if(this.head != null)
        {
            this.head = this.head.getNextNode();
        }
        nodeToReturn.setNextNode(null);
        return nodeToReturn;
    }
}
