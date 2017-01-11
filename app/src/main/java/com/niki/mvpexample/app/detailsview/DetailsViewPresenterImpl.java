package com.niki.mvpexample.app.detailsview;

import javax.inject.Inject;

/**
 * Created by nikiizvorski on 11/01/2017.
 */
class DetailsViewPresenterImpl implements DetailsViewPresenter {
    /**
     * The Details viewa.
     */
    @Inject DetailsViewa detailsViewa;

    /**
     * Instantiates a new Details view presenter.
     *
     * @param detailsViewa the details viewa
     */
    @Inject
    DetailsViewPresenterImpl(DetailsViewa detailsViewa) {
        this.detailsViewa = detailsViewa;
    }

    @Override
    public void setTextViewto(String texta) {
        if(texta != null && !texta.isEmpty()){
            detailsViewa.setTextViewTexta(texta);
        } else detailsViewa.setTextViewTexta("None");
    }
}
