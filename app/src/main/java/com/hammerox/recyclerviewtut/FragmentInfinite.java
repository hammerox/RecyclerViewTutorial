package com.hammerox.recyclerviewtut;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentInfinite extends Fragment {

    private RecyclerView recyclerView;
    private InfiniteAdapter adapter;
    private LinearLayoutManager manager;
    private List<Contact> contactList;
    private Random random = new Random();


    public FragmentInfinite() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactList = Contact.createContactList(10);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_infinite, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_infinite);

        adapter = new InfiniteAdapter(contactList, getContext());
        recyclerView.setAdapter(adapter);

        manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);

        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(manager) {
            @Override
            public void onLoadMore(int current_page) {
                String name = "Created " + current_page;
                boolean online = random.nextBoolean();
                contactList.add(new Contact(name, online));
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }

}
