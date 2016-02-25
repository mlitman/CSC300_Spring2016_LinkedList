package com.example.awesomefat.linkedlist;

import android.widget.LinearLayout;

/**
 * Created by awesomefat on 2/16/16.
 */
public class StringStack extends StringLinkedList
{
    public StringStack(LinearLayout layout)
    {
        super(layout);
    }

    public Node peek()
    {
        return this.getAtIndex(0);
    }

    public Node pop()
    {
        return this.removeFront();
    }

    public void push(String value)
    {
        this.addFront(value);
    }
}
