package org.msufcu.navigationapp.section;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by kyle on 2/6/14.
 */
public class SectionTabbedAdapter extends FragmentStatePagerAdapter {
    Context mContext;
    ArrayList<Section> mSections;

    public SectionTabbedAdapter(Context context, FragmentManager fm, ArrayList<Section> sections) {
        super(fm);
        mContext = context;
        mSections = sections;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mSections.get(position).getHeading();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new SectionFragment();
        Bundle args = new Bundle();
        args.putSerializable(SectionFragment.SECTION_KEY, mSections.get(position));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return mSections.size();
    }
}
