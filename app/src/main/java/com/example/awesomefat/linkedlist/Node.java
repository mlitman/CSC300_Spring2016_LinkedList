package com.example.awesomefat.linkedlist;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.List;

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
                //valueLabel.setVisibility(View.GONE);

                PopupMenu popup = new PopupMenu(ListCore.mainActivity, v);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        if (item.getTitle().equals("DELETE"))
                        {
                            ListCore.ll.removeAtIndex(ListCore.ll.indexOf(myself));
                            ListCore.ll.display();
                        }
                        else if (item.getTitle().equals("ADD ABOVE"))
                        {
                            int pos = ListCore.ll.indexOf(myself);
                            ListCore.ll.addAtIndex(ListCore.newValueEditText.getText().toString(), pos);
                            ListCore.ll.display();
                        }
                        else if (item.getTitle().equals("ADD BELOW"))
                        {
                            int pos = ListCore.ll.indexOf(myself);
                            ListCore.ll.addAtIndex(ListCore.newValueEditText.getText().toString(), pos+1);
                            ListCore.ll.display();
                        }
                        return true;
                    }
                });
                popup.show();//showing popup menu

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
