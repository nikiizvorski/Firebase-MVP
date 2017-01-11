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

    /**
     * Instantiates a new Details view module.
     *
     * @param detailsView the details view
     * @param details     the details
     */
    public DetailsViewModule(DetailsView detailsView, Details details) {
        this.detailsView = detailsView;
        this.details = details;
    }

    /**
     * Details view details view.
     *
     * @return the details view
     */
    @Provides
    DetailsView detailsView(){
        return detailsView;
    }

    /**
     * Gets details.
     *
     * @return the details
     */
    @Provides
    public Details getDetails() {
        return details;
    }

    /**
     * Details iterator details iterator.
     *
     * @return the details iterator
     */
    @Provides
    DetailsIterator detailsIterator(){
        return new DetailsIteratorImpl();
    }

    /**
     * Database reference database reference.
     *
     * @param detailsIterator the details iterator
     * @return the database reference
     */
    @Provides
    DatabaseReference databaseReference(DetailsIterator detailsIterator){
        return detailsIterator.getDB();
    }

    /**
     * Details presenter details presenter.
     *
     * @param detailsView     the details view
     * @param detailsIterator the details iterator
     * @return the details presenter
     */
    @Provides
    DetailsPresenter detailsPresenter(DetailsView detailsView, DetailsIterator detailsIterator){
        return new DetailsPresenterImpl(detailsView, detailsIterator);
    }

    /**
     * List custom adapter list custom adapter.
     *
     * @param details           the details
     * @param databaseReference the database reference
     * @return the list custom adapter
     */
    @Provides
    ListCustomAdapter listCustomAdapter(Details details, DatabaseReference databaseReference){
        return new ListCustomAdapter(details, Knigi.class, android.R.layout.simple_list_item_1, databaseReference);
    }
}
