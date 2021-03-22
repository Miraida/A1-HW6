package com.geek.a1_hw6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {
    UserContactModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        checkGetIntent();

    }

    private void checkGetIntent() {
        if (getIntent() != null) {
            model = (UserContactModel) getIntent().getSerializableExtra("MODEL_EXTRA");
            init();
        }
    }

    private void init() {
       TextFragment textFragment = TextFragment.newInstance(model.getTitle(),model.getSubTitle(),model.getImage());
        getSupportFragmentManager().beginTransaction()
                .add(R.id.details_layout,textFragment)
                .commit();
    }
}