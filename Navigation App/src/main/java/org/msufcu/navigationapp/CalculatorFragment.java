package org.msufcu.navigationapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kyle on 2/9/14.
 */
public class CalculatorFragment extends Fragment {
    public static final String SOME_TEXT = "some_text";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static CalculatorFragment newInstance(String text) {
        CalculatorFragment fragment = new CalculatorFragment();
        Bundle args = new Bundle();
        args.putString(SOME_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String text = getArguments().getString(SOME_TEXT);

        View rootView = inflater.inflate(R.layout.fragment_skeleton, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.skeleton_text);
        textView.setText(text);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        /*
        ((MainActivity) activity).onSkeletonFragmentAttached(
                (Section) getArguments().getString(SOME_TEXT));
         */
    }
}
