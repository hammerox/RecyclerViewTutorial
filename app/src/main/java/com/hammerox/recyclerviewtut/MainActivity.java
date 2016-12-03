package com.hammerox.recyclerviewtut;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final static String KEY_CONTACTS = "KEY_CONTACTS";

    Gson gson = new Gson();
    ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_contacts);

        if (savedInstanceState == null) {
            contacts = Contact.createContactList(20);
        } else {
            String jsonToLoad = savedInstanceState.getString(KEY_CONTACTS);

            Type type = new TypeToken<ArrayList<Contact>>() {}.getType();
            contacts = gson.fromJson(jsonToLoad, type);
        }


        ContactsAdapter adapter = new ContactsAdapter(this, contacts);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String jsonToSave = gson.toJson(contacts);
        outState.putString(KEY_CONTACTS, jsonToSave);
    }
}
