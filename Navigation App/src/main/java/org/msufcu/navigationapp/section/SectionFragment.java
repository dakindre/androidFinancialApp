package org.msufcu.navigationapp.section;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.msufcu.navigationapp.MainActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class SectionFragment extends Fragment {

    /**
     * The section being displayed in this fragment
     */
    public Section mSection;

    /**
     * The fragment argument representing the Section for this fragment
     */
    public static final String SECTION_KEY = "section_key";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static final SectionFragment newInstance(Section section) {
        SectionFragment fragment = new SectionFragment();
        Bundle args = new Bundle();
        args.putSerializable(SECTION_KEY, section);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mSection == null) {
            Section section = (Section) getArguments().getSerializable(SECTION_KEY);
            mSection = section;
        }

        Log.d("SECTION_FRAGMENT", mSection.getHeading());

        View rootView = mSection.getView(inflater, container);
        mSection.fillView(getActivity(), getActivity().getSupportFragmentManager(), rootView);

        return rootView;
    }

    public Section getSection() {
        return (Section) getArguments().getSerializable(SECTION_KEY);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                (Section) getArguments().getSerializable(SECTION_KEY));
    }
}