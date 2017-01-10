package com.niki.mvpexample.app.details;

import com.niki.mvpexample.app.util.CustomScope;

import dagger.Component;

/**
 * Created by nikiizvorski on 10/01/2017.
 */

@CustomScope
@Component(modules = DetailsViewModule.class)
interface DetailsViewComponent {
    void inject(Details details);
}
