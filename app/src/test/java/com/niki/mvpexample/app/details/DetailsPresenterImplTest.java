package com.niki.mvpexample.app.details;

import android.widget.AdapterView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.niki.mvpexample.app.adapter.ListCustomAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.after;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DetailsPresenterImplTest {

    @Mock DetailsView view;
    @Mock DetailsIteratorImpl detailsIterator;
    @Mock FirebaseAuth firebaseAuth;

    private DetailsPresenterImpl detailsPresenter;

    @Before
    public void setUp() throws Exception {
            detailsPresenter = new DetailsPresenterImpl(view, detailsIterator);
    }

    @Test
    public void checkIfItIsDestroyed() throws Exception {
        detailsPresenter.onDestroy();
        assertNull(detailsPresenter.getDetailsView());
    }

    @Test
    public void getDetailsView() throws Exception {
        assertEquals(view, detailsPresenter.getDetailsView());
    }

    @Test
    public void createItemsForAdapterRequest() throws Exception {
        detailsPresenter.createItemsForAdapterRequest();
        verify(view, after(5)).setListItems(detailsIterator.getDB());
    }

    @Test
    public void leaveTheApp() throws Exception {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        detailsPresenter.leaveTheApp();
        detailsIterator.logOutTheUser();

        assertEquals(firebaseUser, null);
        verify(view, times(1)).takeUserToLogin();
    }

    @Test
    public void setOnItemClicked() throws Exception {
        detailsPresenter.createItemsForAdapterRequest();
        verify(view, times(1)).setListItems(detailsIterator.getDB());
    }

}