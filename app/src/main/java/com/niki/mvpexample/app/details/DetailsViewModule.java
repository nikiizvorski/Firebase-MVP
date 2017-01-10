package com.niki.mvpexample.app.details;

import com.google.firebase.database.DatabaseReference;
import com.niki.mvpexample.app.adapter.ListCustomAdapter;
import com.niki.mvpexample.app.model.Knigi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nikiizvorski on 10/01/2017.
 */

@Module
public class DetailsViewModule {

    private DetailsView detailsView;
    private Details details;

    public DetailsViewModule(DetailsView detailsView, Details details) {
        this.detailsView = detailsView;
        this.details = details;
    }

    @Provides
    DetailsView detailsView(){
        return detailsView;
    }

    @Provides
    public Details getDetails() {
        return details;
    }

    @Provides
    DetailsIterator detailsIterator(){
        return new DetailsIteratorImpl();
    }

    @Provides
    DatabaseReference databaseReference(DetailsIterator detailsIterator){
        return detailsIterator.getDB();
    }

    @Provides
    DetailsPresenter detailsPresenter(DetailsView detailsView, DetailsIterator detailsIterator){
        return new DetailsPresenterImpl(detailsView, detailsIterator);
    }

    @Provides
    ListCustomAdapter listCustomAdapter(Details details, DatabaseReference databaseReference){
        return new ListCustomAdapter(details, Knigi.class, android.R.layout.simple_list_item_1, databaseReference);
    }
}
