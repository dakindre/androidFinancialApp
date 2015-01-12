package org.msufcu.navigationapp;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;

import org.msufcu.navigationapp.section.Section;
import org.msufcu.navigationapp.section.SectionFragment;
import org.msufcu.navigationapp.section.SectionsProvider;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private ArrayList<Section> mSections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // This is where we populate from database
        mSections = SectionsProvider.getSections();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        mTitle = mSections.get(mNavigationDrawerFragment.getCurrentSelectedPosition())
                .getHeading();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    public void setTitle(String title) {
        mTitle = title;
        restoreActionBar();
    }

    public ArrayList<Section> getSections() { return mSections; }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        replaceContainer(SectionFragment.newInstance(mSections.get(position)));

        // update action bar
        mTitle = mSections.get(position).getHeading();
        setActionBarBackground(mSections.get(position).getAccentColor());
    }

    public void onSectionAttached(Section section) {
        /*
        mTitle = section.getHeading();
        setActionBarBackground(section.getAccentColor());
        */
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        SectionFragment more = (SectionFragment) fm.findFragmentByTag("FRAGMENT_MORE");

        if (more != null) {
            // Go back to previous view instead of this
            super.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    public void replaceContainer(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_calculator) {
            replaceContainer(CalculatorFragment.newInstance("Calculator"));
            return true;
        } else if (id == R.id.action_ask_an_expert) {
            replaceContainer(AskAnExpertFragment.newInstance("Ask an expert"));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * setActionBarBackground() - change background of actionbar
     * @param color
     */
    public void setActionBarBackground(int color) {
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(color));
    }
}
