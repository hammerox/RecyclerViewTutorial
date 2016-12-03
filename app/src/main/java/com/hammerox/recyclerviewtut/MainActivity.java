package com.hammerox.recyclerviewtut;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final static String TAG_FRAG_VERT_LIST = "TAG_FRAG_VERT_LIST";

    FragmentVerticalList fragmentVerticalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            fragmentVerticalList = new FragmentVerticalList();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main, fragmentVerticalList, TAG_FRAG_VERT_LIST)
                    .commit();
        } else {
            fragmentVerticalList = (FragmentVerticalList) getSupportFragmentManager()
                    .findFragmentByTag(TAG_FRAG_VERT_LIST);
        }
    }
}
