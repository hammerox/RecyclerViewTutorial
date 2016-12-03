package com.hammerox.recyclerviewtut;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private final static String KEY_CURRENT_TAG = "CURRENT_TAG";
    private final static String TAG_FRAG_VERT_LIST = "TAG_FRAG_VERT_LIST";

    FragmentVerticalList fragmentVerticalList;
    String currentTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment;

        if (savedInstanceState == null) {

            createFragments();
            fragment = fragmentVerticalList;
            currentTag = TAG_FRAG_VERT_LIST;

        } else {

            recreateFragments();
            currentTag = savedInstanceState.getString(KEY_CURRENT_TAG);
            switch (currentTag) {
                case TAG_FRAG_VERT_LIST:
                    fragment = fragmentVerticalList;
                    break;
                default:
                    fragment = fragmentVerticalList;
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
                fragment = fragmentVerticalList;
                currentTag = TAG_FRAG_VERT_LIST;
                break;
            default:
                fragment = fragmentVerticalList;
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

    public void createFragments() {
        fragmentVerticalList = new FragmentVerticalList();
    }

    public void recreateFragments() {
        fragmentVerticalList = (FragmentVerticalList) getSupportFragmentManager()
                .findFragmentByTag(TAG_FRAG_VERT_LIST);
    }

    public void replaceFragment(Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main, fragment, tag)
                .commit();
    }
}
