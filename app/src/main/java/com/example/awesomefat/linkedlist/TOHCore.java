package com.example.awesomefat.linkedlist;

import android.view.View;

/**
 * Created by awesomefat on 2/23/16.
 */
public class TOHCore
{
    static TowerFragment tower1 = null;
    static TowerFragment tower2 = null;
    static TowerFragment tower3 = null;
    static View poppedDisk = null;

    static void resetTowerButtons()
    {
        TowerFragment[] towerCollection = {tower1, tower2, tower3};
        for(TowerFragment tower : towerCollection)
        {
            tower.setButtonText("POP");
        }
    }

    static void toggleTowerButtons(TowerFragment sourceTower)
    {
        TowerFragment[] towerCollection = {tower1, tower2, tower3};
        sourceTower.setButtonText("SOURCE");
        for(TowerFragment tower : towerCollection)
        {
            if(tower != sourceTower)
            {
                tower.setButtonText("PUSH");
            }
        }
    }
}
