package com.hammerox.recyclerviewtut;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private final static String KEY_CURRENT_TAG = "CURRENT_TAG";
    private final static String TAG_FRAG_VERT_LIST = "TAG_FRAG_VERT_LIST";
    private final static String TAG_FRAG_GRID = "TAG_FRAG_GRID";
    private final static String TAG_FRAG_INFINITE = "TAG_FRAG_INFINITE";

    FragmentVerticalList fragmentVerticalList;
    FragmentGrid fragmentGrid;
    FragmentInfinite fragmentInfinite;

    String currentTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment;

        if (savedInstanceState == null) {

            fragment = getVerticalList();
            currentTag = TAG_FRAG_VERT_LIST;

        } else {

            currentTag = savedInstanceState.getString(KEY_CURRENT_TAG);
            switch (currentTag) {
                case TAG_FRAG_VERT_LIST:
                    fragment = getVerticalList();
                    break;
                case TAG_FRAG_GRID:
                    fragment = getGrid();
                    break;
                case TAG_FRAG_INFINITE:
                    fragment = getInfinite();
                    break;
                default:
                    fragment = getVerticalList();
                    break;
            }

        }

        replaceFragment(fragment, currentTag);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Fragment fragment;

        switch (id) {
            case R.id.item_vertical_list:
                fragment = getVerticalList();
                currentTag = TAG_FRAG_VERT_LIST;
                break;
            case R.id.item_grid:
                fragment = getGrid();
                currentTag = TAG_FRAG_GRID;
                break;
            case R.id.item_infinite:
                fragment = getInfinite();
                currentTag = TAG_FRAG_INFINITE;
                break;
            default:
                fragment = getVerticalList();
                currentTag = TAG_FRAG_VERT_LIST;
                break;
        }

        replaceFragment(fragment, currentTag);

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CURRENT_TAG, currentTag);
    }

    public FragmentVerticalList getVerticalList() {
        FragmentManager fm = getSupportFragmentManager();

        fragmentVerticalList = (FragmentVerticalList) fm.findFragmentByTag(TAG_FRAG_VERT_LIST);
        if (fragmentVerticalList == null) fragmentVerticalList = new FragmentVerticalList();

        return fragmentVerticalList;
    }

    public FragmentGrid getGrid() {
        FragmentManager fm = getSupportFragmentManager();

        fragmentGrid = (FragmentGrid) fm.findFragmentByTag(TAG_FRAG_GRID);
        if (fragmentGrid == null) fragmentGrid = new FragmentGrid();

        return fragmentGrid;
    }

    public FragmentInfinite getInfinite() {
        FragmentManager fm = getSupportFragmentManager();

        fragmentInfinite = (FragmentInfinite) fm.findFragmentByTag(TAG_FRAG_INFINITE);
        if (fragmentInfinite == null) fragmentInfinite = new FragmentInfinite();

        return fragmentInfinite;
    }

    public void replaceFragment(Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main, fragment, tag)
                .commit();
    }
}
