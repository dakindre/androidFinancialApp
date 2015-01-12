package org.msufcu.navigationapp.section;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * List adapter for sections
 */
public class SectionNavigationAdapter extends ArrayAdapter<Section> {
    int mLayout;
    int mTextView;

    public SectionNavigationAdapter(Context context, int layout, int textView, ArrayList<Section> list) {
        super(context, layout, list);

        mLayout = layout;
        mTextView = textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Section section = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mLayout, null);
        }

        TextView tv = (TextView) convertView.findViewById(mTextView);
        tv.setText(section.getHeading());

        return convertView;
    }
}
