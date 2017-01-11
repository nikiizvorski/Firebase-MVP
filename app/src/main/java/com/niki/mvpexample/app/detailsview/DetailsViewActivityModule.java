package com.niki.mvpexample.app.detailsview;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nikiizvorski on 11/01/2017.
 */
@Module
class DetailsViewActivityModule {

    private DetailsViewa detailsViewa;

    /**
     * Instantiates a new Details view activity module.
     *
     * @param detailsViewa the details viewa
     */
    DetailsViewActivityModule(DetailsViewa detailsViewa) {
        this.detailsViewa = detailsViewa;
    }

    /**
     * Gets details viewa.
     *
     * @return the details viewa
     */
    @Provides
    DetailsViewa getDetailsViewa() {
        return detailsViewa;
    }

    /**
     * Details view presenter details view presenter.
     *
     * @param detailsViewa the details viewa
     * @return the details view presenter
     */
    @Provides
    DetailsViewPresenter detailsViewPresenter(DetailsViewa detailsViewa){
        return new DetailsViewPresenterImpl(detailsViewa);
    }
}
