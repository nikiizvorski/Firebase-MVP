package com.niki.mvpexample.app.detailsview;

import com.niki.mvpexample.app.util.CustomScope;

import dagger.Component;

/**
 * The interface Details view activity component.
 */
@CustomScope
@Component(modules = DetailsViewActivityModule.class)
interface DetailsViewActivityComponent {
    /**
     * Inject.
     *
     * @param detailsViewActivity the details view activity
     */
    void inject(DetailsViewActivity detailsViewActivity);
}
