package com.geek.a1_hw6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
     FragmentTransaction transaction;
     FragmentManager manager;
     boolean isOrientationLand = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        manager = getSupportFragmentManager();
      //  transaction = manager.beginTransaction();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if ( getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        {

            isOrientationLand = true;
            transaction = manager.beginTransaction();
           // transaction.hide(new ChangeFragment());
            transaction.replace(R.id.second_layout,new ChangeFragment());
          //  transaction.add(R.id.second_layout, new ChangeFragment());
        }else
        {
            isOrientationLand = false;
            transaction = manager.beginTransaction();
            transaction.show(new ChangeFragment());
        }
        transaction.commit();

    }
    public void displayDetails(UserContactModel model) {

        if (isOrientationLand ){
            TextFragment textFragment = (TextFragment) manager.findFragmentById(R.id.third_Layout);
            assert textFragment != null;
            textFragment.setupViews(model);
        }
        else {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("MODEL_EXTRA", model);
            startActivity(intent);
        }
    }
}