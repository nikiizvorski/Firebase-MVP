package com.niki.mvpexample.app.details;

import android.widget.AdapterView;

import javax.inject.Inject;

class DetailsPresenterImpl implements DetailsPresenter {
    @Inject DetailsView detailsView;
    @Inject DetailsIterator detailsIterator;

    @Inject
    DetailsPresenterImpl(DetailsView detailsView, DetailsIterator detailsIterator) {
        this.detailsView = detailsView;
        this.detailsIterator = detailsIterator;
    }

    @Override
    public void createItemsForAdapterRequest() {
        detailsView.setListItems(detailsIterator.getDB());
    }

    @Override public void onDestroy() {
        detailsView = null;
    }

    @Override
    public void leaveTheApp() {
        detailsIterator.logOutTheUser();
        detailsView.takeUserToLogin();
    }

    @Override
    public void setOnItemClicked(int position, AdapterView<?> parent) {
        detailsView.showmsg(String.valueOf(position) + " " + parent.getItemAtPosition(position).toString());
    }

    DetailsView getDetailsView() {
        return detailsView;
    }

}
