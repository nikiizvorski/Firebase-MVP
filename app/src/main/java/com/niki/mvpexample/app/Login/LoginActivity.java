package com.niki.mvpexample.app.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.niki.mvpexample.app.R;
import com.niki.mvpexample.app.details.Details;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

public class LoginActivity extends Activity implements LoginView {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;

    @Inject LoginPresenter presenter;

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        Button button = (Button) findViewById(R.id.button);
        Button register = (Button) findViewById(R.id.button2);

        initAppData();

        presenter.getAuthListener();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validateCredentials(username.getText().toString().trim(), password.getText().toString().trim());
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.registerTheUser(username.getText().toString().trim(), password.getText().toString().trim());
            }
        });
    }

    @Override
    public void initAppData() {
        DaggerLoginViewComponent.builder().loginViewModule(new LoginViewModule(this)).build().inject(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        Intent home = new Intent(this, Details.class);
        home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(home);
        finish();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(presenter.getAuthListener());
    }

    @Override
    public void onStop() {
        super.onStop();
        if (presenter.getAuthListener() != null) {
            mAuth.removeAuthStateListener(presenter.getAuthListener());
        }
    }
}
