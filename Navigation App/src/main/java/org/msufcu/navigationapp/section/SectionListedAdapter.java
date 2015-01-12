package org.msufcu.navigationapp.section;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.msufcu.navigationapp.R;

import java.util.ArrayList;

/**
 * List adapter for sections
 */
public class SectionListedAdapter extends ArrayAdapter<Section> {
    int mLayout;

    public SectionListedAdapter(Context context, int layout, ArrayList<Section> list) {
        super(context, layout, list);
        mLayout = layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SectionMore section = (SectionMore) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mLayout, null);
        }

        TextView heading = (TextView) convertView.findViewById(R.id.section_list_item_heading);
        TextView content = (TextView) convertView.findViewById(R.id.section_list_item_content);
        heading.setText(section.getHeading());
        content.setText(section.getContent());

        return convertView;
    }
}
