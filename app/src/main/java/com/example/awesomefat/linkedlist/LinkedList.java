package com.example.awesomefat.linkedlist;

import android.widget.LinearLayout;

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
        if(this.head == null)
        {
           System.out.println("Empty List");
        }
        else
        {
            //display the list in a reasonable format
        }
    }

    public void addFront(String value)
    {
        //this adds a new Node to the front of the list with payload == value
    }

    public Node removeFront()
    {
        //this removes and returns the Node that is currently sitting at the
        //front of the list.  The new front of the list, should be the old
        //second node or null in the event it was a 1-list
        return null;
    }
}
