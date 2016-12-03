package com.hammerox.recyclerviewtut;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentVerticalList extends Fragment {

    private final static String KEY_CONTACTS = "KEY_CONTACTS";

    Gson gson = new Gson();
    ArrayList<Contact> contacts;


    public FragmentVerticalList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vertical_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_contacts);

        if (savedInstanceState == null) {
            contacts = Contact.createContactList(20);
        } else {
            String jsonToLoad = savedInstanceState.getString(KEY_CONTACTS);

            Type type = new TypeToken<ArrayList<Contact>>() {}.getType();
            contacts = gson.fromJson(jsonToLoad, type);
        }

        ContactsAdapter adapter = new ContactsAdapter(getContext(), contacts);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String jsonToSave = gson.toJson(contacts);
        outState.putString(KEY_CONTACTS, jsonToSave);
    }
}
