package noor.serry.alram.util.adapter.viewPagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {
    List<Fragment> TabFragments;
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> TabFragments) {
        super (fragmentActivity);
        this.TabFragments = TabFragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return TabFragments.get (position);
    }

    @Override
    public int getItemCount() {
        return TabFragments.size ();
    }
}
