package com.hammerox.recyclerviewtut;

import java.util.ArrayList;

/**
 * Created by Mauricio on 02-Dec-16.
 */

public class Contact {

    private String mName;
    private boolean mOnline;

    public Contact(String name, boolean online) {
        this.mName = name;
        this.mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    public static ArrayList<Contact> createContactList(int numContacts) {

        int lastContact = 0;

        ArrayList<Contact> contacts = new ArrayList<>();

        for (int i = 1; i <= numContacts ; i++) {
            contacts.add(new Contact("Person " + ++lastContact, i <= numContacts/2));
        }

        return contacts;
    }
}
