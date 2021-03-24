package com.geek.a1_hw6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TextFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private String mParam1;
    private String mParam2;
    private int mParam3;
    private TextView txtTitle,txtSubTitle;
    private ImageView imvPhoto;
    public TextFragment() {}

    public static TextFragment newInstance(String param1, String param2,int param3) {
        TextFragment fragment = new TextFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view =  inflater.inflate(R.layout.fragment_text, container, false);
         txtTitle = view.findViewById(R.id.title_textView);
         txtSubTitle = view.findViewById(R.id.sub_title_textView);
         imvPhoto = view.findViewById(R.id.textF_imageView);
         if (mParam1!=null)setupViews();
        return view;
    }
    public void setupViewsWith(UserContactModel model){
        txtTitle.setText(model.getTitle());
        txtSubTitle.setText(model.getSubTitle());
        imvPhoto.setImageResource(model.getImage());
    }

    private void setupViews() {
        txtTitle.setText(mParam1);
        txtSubTitle.setText(mParam2);
        imvPhoto.setImageResource(mParam3);
    }
}