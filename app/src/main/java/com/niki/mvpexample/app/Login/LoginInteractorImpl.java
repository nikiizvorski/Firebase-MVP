package com.niki.mvpexample.app.Login;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

class LoginInteractorImpl implements LoginInteractor {

    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private static final String TAG = LoginActivity.class.getSimpleName();

    @Inject LoginInteractorImpl() {}

    @Override
    public FirebaseAuth.AuthStateListener authListener(final OnLoginFinishedListener listener) {
        return firebaseAuth -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                // User is signed in
                Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                listener.onSuccess();
            } else {
                // User is signed out
                listener.onUsernameError();
                Log.d(TAG, "onAuthStateChanged:signed_out");
            }
        };
    }

    @Override
    public void registerUser(String trim, String trim1, final OnLoginFinishedListener listener, final LoginView view) {
        auth.createUserWithEmailAndPassword(trim, trim1).addOnCompleteListener((Activity) view, task -> {
            if (!task.isSuccessful()) {
                listener.onUsernameError();
            } else {
                listener.onSuccess();
            }
        });
    }

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener, final LoginView view) {
        auth.signInWithEmailAndPassword(username, password).addOnCompleteListener((Activity) view, task -> {
            if (!task.isSuccessful()) {
                listener.onUsernameError();
            } else {
                listener.onSuccess();
            }
        });
    }
}
