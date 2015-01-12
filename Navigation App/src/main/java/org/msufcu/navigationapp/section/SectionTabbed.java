package org.msufcu.navigationapp.section;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import org.msufcu.navigationapp.R;

import java.util.ArrayList;

/**
 * Created by kyle on 2/6/14.
 */
public class SectionTabbed extends Section {

    ArrayList<Section> mSections;
    private static final String TAG = "SECTION_NODE";

    public SectionTabbed(String heading, ArrayList<Section> sections) {
        super(heading);
        mSections = sections;
    }

    public View getView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_section_node, container, false);
    }

    public void fillView(Context context, FragmentManager fm, View rootView) {
        fm.beginTransaction().addToBackStack("TABS").commit();

        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        viewPager.setAdapter(new SectionTabbedAdapter(context, fm, mSections));

        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) rootView.findViewById(R.id.tabstrip);
        tabStrip.setViewPager(viewPager);

        tabStrip.setAllCaps(true);
        tabStrip.setIndicatorColorResource(mColorDark);
    }

    @Override
    public boolean isLeaf() { return false; }
}
