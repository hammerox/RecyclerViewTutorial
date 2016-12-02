package com.hammerox.recyclerviewtut;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mauricio on 02-Dec-16.
 */

public class ContactsAdapter
        extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private List<Contact> mContacts;
    private Context mContext;


    public ContactsAdapter(Context context, List<Contact> contacts) {
        this.mContext = context;
        this.mContacts = contacts;
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);

        holder.mTextView.setText(contact.getName());

        if (contact.isOnline()) {
            holder.mButton.setText("Message");
            holder.mButton.setClickable(true);
            holder.mButton.setTextColor(Color.BLACK);
        } else {
            holder.mButton.setText("Offline");
            holder.mButton.setClickable(false);
            holder.mButton.setTextColor(Color.GRAY);
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public Button mButton;

        public ViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.contact_name);
            mButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }

}
