package id.co.next_innovation.go_mik.ui.home;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomePagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> fragments;
    private final List<String> names;
//    private FragmentActivity activity;

    public HomePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
//        activity = fragmentActivity;
        fragments = new ArrayList<>();
        names = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragments(List<Fragment> mFragments, List<String> titles) {
        fragments.clear();
        names.clear();
        fragments.addAll(mFragments);
        names.addAll(titles);
        notifyDataSetChanged();
    }

    public void addFragment(Fragment fragment, String title) {
        fragments.add(fragment);
        names.add(title);
        notifyDataSetChanged();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return names.get(position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        if (fragments.contains(object)) {
            return fragments.indexOf(object);
        } else {
            return POSITION_NONE;
        }
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    public void clearItems() {
        fragments.clear();
        names.clear();
        notifyDataSetChanged();
    }
}
