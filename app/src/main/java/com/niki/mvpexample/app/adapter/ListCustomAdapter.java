package com.niki.mvpexample.app.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.niki.mvpexample.app.model.Knigi;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.Query;

import javax.inject.Inject;

public class ListCustomAdapter extends FirebaseListAdapter<Knigi> {

    @Inject
    public ListCustomAdapter(Activity activity, Class<Knigi> modelClass, int modelLayout, Query ref) {
        super(activity, modelClass, modelLayout, ref);
    }

    @Override
    protected void populateView(View v, final Knigi model, int position) {
        TextView textView = (TextView) v.findViewById(android.R.id.text1);
        textView.setText(model.getName());
    }
}
