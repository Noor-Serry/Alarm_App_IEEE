package noor.serry.alram.util.adapter.viewPagerAdapter;









import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;


import com.google.android.material.tabs.TabLayout;

import noor.serry.alram.R;

public class CustomOnTabSelectedListener implements TabLayout.OnTabSelectedListener {
    Drawable defultIcon;
    @SuppressLint("RestrictedApi")
    public CustomOnTabSelectedListener (Drawable defultIcon){
        this.defultIcon = defultIcon;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        defultIcon = tab.getIcon ();
        selectTheTabSelected (tab);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
      tab.setIcon (defultIcon);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) { }

    public void selectTheTabSelected(TabLayout.Tab tab){
        int position = tab.getPosition ();
        switch (position){
            case 0: tab.setIcon (R.drawable.alarm_2);break;
            case 1: tab.setIcon (R.drawable.clock_2);break;
            case 2: tab.setIcon (R.drawable.counter_2);break;
            case 3: tab.setIcon (R.drawable.hourglass_2);
        }
    }
}
