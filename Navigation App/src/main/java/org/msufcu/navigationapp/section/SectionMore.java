package org.msufcu.navigationapp.section;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.msufcu.navigationapp.R;

/**
 * Created by msufcu on 2/11/14.
 */
public class SectionMore extends Section {

    String mContent;

    public SectionMore(String heading, String content) {
        super(heading);
        mContent = content;
    }

    public View getView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_section_leaf, container, false);
    }

    public void fillView(Context context, FragmentManager fm, View rootView) {
        TextView tv = (TextView) rootView.findViewById(R.id.section_label);
        tv.setText(mContent);
    }

    public String getContent() { return mContent; }
}
