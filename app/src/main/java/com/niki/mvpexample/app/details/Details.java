package com.niki.mvpexample.app.details;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.niki.mvpexample.app.Login.LoginActivity;
import com.niki.mvpexample.app.R;
import com.niki.mvpexample.app.adapter.ListCustomAdapter;
import com.google.firebase.database.DatabaseReference;

import javax.inject.Inject;

import dagger.internal.DaggerCollections;

public class Details extends Activity implements DetailsView, View.OnClickListener, AdapterView.OnItemClickListener {

    @Inject DetailsPresenter detailsPresenter;
    @Inject ListCustomAdapter firebaseListAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        listView = (ListView) findViewById(R.id.novi);
        Button leave = (Button) findViewById(R.id.leave);
        leave.setOnClickListener(this);
        initAppData();
    }

    @Override
    public void initAppData() {
        DaggerDetailsViewComponent.builder().detailsViewModule(new DetailsViewModule(this, this)).build().inject(this);
        detailsPresenter.createItemsForAdapterRequest();
    }

    @Override
    public void setListItems(DatabaseReference databaseReference) {
        listView.setAdapter(firebaseListAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void takeUserToLogin() {
        Intent home = new Intent(this, LoginActivity.class);
        home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(home);
        finish();
    }

    @Override
    public void showmsg(String msg) {
        Toast.makeText(Details.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        detailsPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        detailsPresenter.leaveTheApp();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        detailsPresenter.setOnItemClicked(position, parent);
    }
}
