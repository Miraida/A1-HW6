package com.geek.a1_hw6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void displayDetails(UserContactModel model) {
       FragmentManager manager = getSupportFragmentManager();
       TextFragment textFragment = (TextFragment) manager.findFragmentById(R.id.text_fragment);

        if (textFragment != null && textFragment.isVisible()){
            textFragment.setupViewsWith(model);
            Toast.makeText(this,"work",Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("MODEL_EXTRA", model);
            startActivity(intent);
        }
    }
}