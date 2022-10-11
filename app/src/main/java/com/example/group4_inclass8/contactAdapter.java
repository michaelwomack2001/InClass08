package com.example.group4_inclass8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class contactAdapter extends ArrayAdapter<Contacts> {

    public contactAdapter(@NonNull Context context, int resource, @NonNull List<Contacts> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.contact_list_adapter,parent, false);
        }
        Contacts contact = getItem(position);
        TextView textViewName = convertView.findViewById(R.id.nameLbl3);
        TextView textViewEmail = convertView.findViewById(R.id.emailLbl3);
        TextView textViewPhone = convertView.findViewById(R.id.phoneLbl3);
        TextView textViewType = convertView.findViewById(R.id.type3);

        textViewName.setText("Name: " + contact.getName());
        textViewEmail.setText("Email: "+ contact.getEmail());
        textViewPhone.setText("Phone #: "+ contact.getPhoneNum());
        textViewType.setText("Type: "+ contact.getType());


        return super.getView(position, convertView, parent);
    }
}
