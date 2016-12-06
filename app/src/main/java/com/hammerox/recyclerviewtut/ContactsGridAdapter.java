package com.hammerox.recyclerviewtut;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Mauricio on 05-Dec-16.
 */

public class ContactsGridAdapter
        extends RecyclerView.Adapter<ContactsGridAdapter.ViewHolder> {

    private List<Contact> contactList;
    private Context context;

    public ContactsGridAdapter(List<Contact> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_contact_grid, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        ColorStateList color;

        holder.textView.setText(contact.getName());

        if (contact.isOnline()) {
            holder.button.setText("ON");
            color = ContextCompat.getColorStateList(context, R.color.colorGreen);
            ViewCompat.setBackgroundTintList(holder.button, color);
        } else {
            holder.button.setText("OFF");
            color = ContextCompat.getColorStateList(context, R.color.colorRed);
            ViewCompat.setBackgroundTintList(holder.button, color);
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private Button button;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.grid_textview);
            button = (Button) itemView.findViewById(R.id.grid_button);
        }
    }
}
