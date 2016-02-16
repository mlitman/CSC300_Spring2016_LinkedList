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
    public int count;
    public LinkedList(LinearLayout layout)
    {
        this.head = null;
        this.layout = layout;
        this.count = 0;
    }

    public void addAtIndex(String value, int index)
    {
        //this guy should add a new Node to the list with payload = value at the specified
        //index assuming that index is a legal position in the list.
        if(index == 0)
        {
            this.addFront(value);
        }
        else if(index == this.count)
        {
            this.addEnd(value);
        }
        else
        {
            this.count++;
            Node n = new Node(value);
            Node nodeBefore = this.head;
            Node nodeAt;

            for(int i = 0; i < index-1; i++)
            {
                nodeBefore = nodeBefore.getNextNode();
            }
            nodeAt = nodeBefore.getNextNode();
            n.setNextNode(nodeAt);
            nodeBefore.setNextNode(n);
        }

    }

    public Node removeAtIndex(int index)
    {
        //is the index out of bounds?
        if(index < 0 || index >= this.count)
        {
            System.err.println("Linked List index out of bounds: " + index);
            return null;
        }
        else if(index == 0)
        {
            return this.removeFront();
        }
        else if(index == this.count-1)
        {
            return this.removeEnd();
        }
        else
        {
            this.count--;
            //we have work to do
            Node nodeBefore = head;
            Node nodeToRemove = null;
            Node nodeAfter = null;

            //position nodeBefore to the node before the node we want to remove
            for(int i = 0; i < index-1; i++)
            {
                nodeBefore = nodeBefore.getNextNode();
            }
            nodeToRemove = nodeBefore.getNextNode();
            nodeAfter = nodeToRemove.getNextNode();
            nodeBefore.setNextNode(nodeAfter);
            nodeToRemove.setNextNode(null);
            return nodeToRemove;
        }
    }

    public int indexOf(Node n)
    {
        if(this.head != null)
        {
            int pos = 0;
            Node currNode = this.head;
            do
            {
                if(currNode == n)
                {
                    return pos;
                }
                else
                {
                    pos++;
                    currNode = currNode.getNextNode();
                }
            }
            while(currNode != null);
        }
        return -1;
    }

    public void display()
    {
        this.layout.removeAllViews();
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

    public Node getAtIndex(int i)
    {
        return null;
    }

    //inefficient, but accurate
    public int count()
    {
        int count = 0;
        if(head != null)
        {
            count++;
            //at least one node in the list
            Node currNode = head;
            while(currNode.getNextNode() != null)
            {
                currNode = currNode.getNextNode();
                count++;
            }
        }
        return count;
    }

    public void addFront(String value)
    {
        //this adds a new Node to the front of the list with payload == value
        Node n = new Node(value);
        n.setNextNode(this.head);
        this.head = n;
        this.count++;
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
            nodeToReturn.setNextNode(null);
            this.count--;
        }

        return nodeToReturn;
    }

    public void addEnd(String value)
    {
        if(this.head == null)
        {
            this.addFront(value);
        }
        else
        {
            Node n = new Node(value);
            Node currNode = head;
            while(currNode.getNextNode() != null)
            {
                currNode = currNode.getNextNode();
            }
            //currNode is currently pointing at the last node in the list
            currNode.setNextNode(n);
            this.count++;
        }
    }

    public Node removeEnd()
    {
        if(head == null)
        {
            return head;
        }
        else
        {
            this.count--;
            Node nodeToReturn = head;
            //deal with the 1-list special case
            if(head.getNextNode() == null)
            {
                head = null;
                return nodeToReturn;
            }
            else
            {
                //there are at least 2 nodes in the list
                Node currNode = head;
                while (currNode.getNextNode() != null && currNode.getNextNode().getNextNode() != null)
                {
                    currNode = currNode.getNextNode();
                }
                //currNode points to the Node right before the last node in the list
                nodeToReturn = currNode.getNextNode();
                currNode.setNextNode(null);
                return nodeToReturn;
            }
        }
    }

}
