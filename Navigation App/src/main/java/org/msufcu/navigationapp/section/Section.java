package org.msufcu.navigationapp.section;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.msufcu.navigationapp.R;

import java.io.Serializable;

/**
 * Interface for information sections
 *
 * TODO: getView and fillView could be encapsulated with a large parameter list
 */
public abstract class Section implements Serializable {

    String mHeading;
    int mColorLight;
    int mColorDark;

    public Section(String heading) {
        mHeading = heading;
        mColorDark = R.color.accent_default;
    }

    public void setAccentColors(int dark, int light) {
        mColorLight = light;
        mColorDark = dark;
    }

    /**
     * getHeading() - return a string containing this section's main heading
     * @return
     */
    public String getHeading() { return mHeading; }

    /**
     * getAccentColor() - get accent color for this section
     * @return resource id for accent color
     */
    public int getAccentColor() {
        return mColorDark;
    }

    /**
     * isLeaf() - determine whether this section has child subsections
     * @return          is a leaf
     */
    boolean isLeaf() { return true; }

    /**
     * fillView() - populate a view generated by this section's getView()
     * @param context   Activity fragment is attached to
     * @param fm        Fragment manager
     * @param rootView  (output) populate this view with this section's content
     */
    public abstract void fillView(Context context, FragmentManager fm, View rootView);

    /**
     * getView() - create a view tailored to display this section's content
     * @param inflater  LayoutInflater
     * @param container Parent view
     * @return          view to be populated by fillView
     */
    abstract public View getView(LayoutInflater inflater, ViewGroup container);
}
