package noor.serry.alram.ui.viewpager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;
import java.util.List;
import noor.serry.alram.ui.viewpager.timer.Timer;
import noor.serry.alram.ui.viewpager.viewClock.ViewClock;
import noor.serry.alram.ui.viewpager.counter.Counter;
import noor.serry.alram.ui.viewpager.viewMyAlarm.ViewMyAlarm;
import noor.serry.alram.util.adapter.viewPagerAdapter.CustomOnTabSelectedListener;
import noor.serry.alram.R;
import noor.serry.alram.util.adapter.viewPagerAdapter.ViewPagerAdapter;
import noor.serry.alram.databinding.FragmentViewPager2Binding;

public class ViewPager extends Fragment {
    FragmentViewPager2Binding binding;
    List<Integer> tabIcon ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentViewPager2Binding.inflate (inflater, container, false);
        return binding.getRoot ();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        setAdapetrForViewPager ();
        setListtabIcon ();
        connectTabLayourWithViewPager ();
        setTabLayoutListener ();
    }

   private void  setAdapetrForViewPager(){
       List<Fragment> TabFragments = new ArrayList<> (  );
       TabFragments.add(new ViewMyAlarm ());TabFragments.add (new ViewClock ());
       TabFragments.add (new Counter ());TabFragments.add (new Timer ());
       ViewPagerAdapter adapter = new ViewPagerAdapter (getActivity (),TabFragments);
       binding.Viewpager.setAdapter (adapter);

    }

    private void setListtabIcon(){
        tabIcon = new ArrayList<> (  );
        tabIcon.add (R.drawable.alarm_2);tabIcon.add (R.drawable.clock_1);
        tabIcon.add (R.drawable.counter_1);tabIcon.add (R.drawable.hourglass_1);
    }

    private void connectTabLayourWithViewPager(){
         new TabLayoutMediator (binding.tabLayout, binding.Viewpager,this::onConfigureTab)
                 .attach ();

    }

    private void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setIcon (tabIcon.get (position));
    }

    private void setTabLayoutListener(){
        Drawable defultIcon = getContext ().getDrawable (R.drawable.alarm_1);
        binding.tabLayout.addOnTabSelectedListener (new CustomOnTabSelectedListener (defultIcon));
    }

}




