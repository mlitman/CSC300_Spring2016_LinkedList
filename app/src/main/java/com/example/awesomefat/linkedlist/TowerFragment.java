package com.example.awesomefat.linkedlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.*;

public class TowerFragment extends Fragment
{
    private Button theButton;
    private TowerFragment myself;
    private View towerView;
    private LinearLayout towerLayout;
    private ViewGroup towerGroup;
    private LayoutInflater theInflater;
    private LinkedList<View> theDisks = new LinkedList<View>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        this.myself = this;
        this.towerGroup = container;
        this.theInflater = inflater;

        // Inflate the layout for this fragment
        this.towerView = inflater.inflate(R.layout.fragment_tower, container, false);
        this.towerLayout = (LinearLayout)this.towerView.findViewById(R.id.tower);

        this.theButton = (Button)this.towerView.findViewById(R.id.theButton);
        this.theButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Button b = (Button)v;
                if(b.getText().toString().equalsIgnoreCase("POP"))
                {
                    popDisk();
                    TOHCore.toggleTowerButtons(myself);
                }
                else
                {
                    pushDisk(TOHCore.poppedDisk);
                    TOHCore.poppedDisk = null;
                    TOHCore.resetTowerButtons();
                }

            }
        });
        return this.towerView;
    }

    public void setButtonText(String s)
    {
        this.theButton.setText(s);
    }

    public void popDisk()
    {
        if(this.theDisks.size() > 0)
        {
            View diskToPop = this.theDisks.removeLast();
            this.towerLayout.removeView(diskToPop);
            TOHCore.poppedDisk = diskToPop;
        }
    }

    public void pushDisk(View disk)
    {
        this.theDisks.addLast(disk);
        this.towerLayout.addView(disk, 0);
    }

    public void addDisk(int size)
    {
        View disk = this.theInflater.inflate(R.layout.disk, this.towerGroup, false);
        TextView diskLabel = (TextView) disk.findViewById(R.id.diskLabel);
        String text = "";
        for(int i = 0; i < size; i++)
        {
            text += "_";
        }
        diskLabel.setText(text);
        this.towerLayout.removeView(this.theButton);
        this.towerLayout.addView(disk);
        this.towerLayout.addView(this.theButton);
        this.theDisks.push(disk);
    }
}
