package com.niki.mvpexample.app.details;

import android.widget.AdapterView;

import javax.inject.Inject;

/**
 * The type Details presenter.
 */
class DetailsPresenterImpl implements DetailsPresenter {
    /**
     * The Details view.
     */
    @Inject DetailsView detailsView;
    /**
     * The Details iterator.
     */
    @Inject DetailsIterator detailsIterator;

    /**
     * Instantiates a new Details presenter.
     *
     * @param detailsView     the details view
     * @param detailsIterator the details iterator
     */
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

    /**
     * Gets details view.
     *
     * @return the details view
     */
    DetailsView getDetailsView() {
        return detailsView;
    }

}
