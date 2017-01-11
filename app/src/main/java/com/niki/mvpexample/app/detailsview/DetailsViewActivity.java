package com.niki.mvpexample.app.detailsview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.niki.mvpexample.app.R;
import com.niki.mvpexample.app.model.Knigi;

import javax.inject.Inject;

/**
 * The type Details view activity.
 */
public class DetailsViewActivity extends Activity implements DetailsViewa{

    /**
     * The Details view presenter.
     */
    @Inject DetailsViewPresenter detailsViewPresenter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view);
        textView = (TextView) findViewById(R.id.kniga_details);
        initData();
        Bundle b = getIntent().getExtras();
        Knigi obj = b.getParcelable("com.package.ObjectA");
        String data = obj.getText();
        detailsViewPresenter.setTextViewto(data);
    }

    @Override
    public void initData() {
        DaggerDetailsViewActivityComponent.builder().detailsViewActivityModule(new DetailsViewActivityModule(this)).build().inject(this);
    }

    @Override
    public void setTextViewTexta(String texta){
        textView.setText(texta);
    }

    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
        finish();
    }
}
