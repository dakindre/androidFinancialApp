package org.msufcu.navigationapp.section;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.msufcu.navigationapp.MainActivity;
import org.msufcu.navigationapp.R;

import java.util.ArrayList;

/**
 * Created by kyle on 2/6/14.
 */
public class SectionListed extends Section {
    // List of sections within a tab
    ArrayList<Section> mSections;

    public SectionListed(String heading, ArrayList<Section> sections) {
        super(heading);
        mSections = sections;
    }

    public View getView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_section_list, container, false);
    }

    public void fillView(final Context context, FragmentManager fm, View rootView) {
        final MainActivity activity = (MainActivity) context;
        fm.beginTransaction().addToBackStack("LISTED").commit();

        ListView lv = (ListView) rootView.findViewById(R.id.section_list);
        lv.setAdapter(new SectionListedAdapter(
                context,
                R.layout.fragment_section_list_item,
                mSections
        ));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // position - 1 because header view is position 0... I think.
                Section section = mSections.get(position - 1);
                ((MainActivity) context).replaceContainer(SectionFragment.newInstance(section));
                ((MainActivity) context).setTitle(section.getHeading());
            }
        });
        lv.addHeaderView(new View(context), null, false);
        lv.addFooterView(new View(context), null, false);
    }
}