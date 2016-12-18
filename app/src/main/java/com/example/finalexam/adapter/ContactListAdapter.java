package com.example.finalexam.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.finalexam.MODEL.Contact;

import java.util.ArrayList;

/**
 * Created by Kittitorn on 18-Dec-16.
 */

public class ContactListAdapter extends ArrayAdapter<Contact> {

    private Context mContext;
    private int mLayoutResId;
    private ArrayList<Contact> mContactList;

    public ContactListAdapter(Context context, int resource, ArrayList<Contact> contactList) {
        super(context, resource, contactList);

        this.mContext = context;
        this.mLayoutResId = resource;
        this.mContactList = contactList;

    }
}
