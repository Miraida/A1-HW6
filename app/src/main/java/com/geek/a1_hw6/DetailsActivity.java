package com.geek.a1_hw6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {
    UserContactModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        chekOrientation();
        checkGetIntent();
    }

    private void chekOrientation() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
        }
    }

    private void checkGetIntent() {
        if (getIntent() != null) {
            model = (UserContactModel) getIntent().getSerializableExtra("MODEL_EXTRA");
            init();
        }
    }

    private void init() {
       TextFragment textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.text_fragment);
        assert textFragment != null;
        textFragment.setupViewsWith(model);
    }
}