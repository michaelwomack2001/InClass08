package com.example.group4_inclass8;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link contactListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class contactListFragment extends Fragment {
    private final
    ListView contactLv;
    ArrayList<Contacts> contactsList = new ArrayList<>();
    contactAdapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public contactListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment contactListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static contactListFragment newInstance(String param1, String param2) {
        contactListFragment fragment = new contactListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View contactsListView = inflater.inflate(R.layout.fragment_contact_list,container, false);

        //Populate contact list adapter

        adapter = new contactAdapter(getContext(),R.layout.contact_list_adapter, contactsList);
        contactLv = contactsListView.findViewById(R.id.listView);
        contactLv.setAdapter(adapter);

        return contactsListView;
    }
}