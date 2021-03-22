package com.geek.a1_hw6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ChangeFragment extends Fragment implements IFragment {
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;

    public ChangeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        setupRecycler();
        return view;
    }

    private void setupRecycler() {
        List<UserContactModel> list = new ArrayList<>();
        list.add(new UserContactModel("Miraida","chat: Hello, How are you?",R.drawable.miraida));
        list.add(new UserContactModel("Lisa","chat: Hello, How are you?",R.drawable.lisa));
        list.add(new UserContactModel("Artem","chat: Hello, How are you?",R.drawable.artem));
        list.add(new UserContactModel("Unknown","chat: Hello, How are you?",R.drawable.user_profile_photo));
        list.add(new UserContactModel("Miraida","chat: Hello, How are you?",R.drawable.miraida));
        list.add(new UserContactModel("Lisa","chat: Hello, How are you?",R.drawable.lisa));
        list.add(new UserContactModel("Artem","chat: Hello, How are you?",R.drawable.artem));
        list.add(new UserContactModel("Unknown","chat: Hello, How are you?",R.drawable.user_profile_photo));
        list.add(new UserContactModel("Miraida","chat: Hello, How are you?",R.drawable.miraida));
        list.add(new UserContactModel("Lisa","chat: Hello, How are you?",R.drawable.lisa));
        list.add(new UserContactModel("Artem","chat: Hello, How are you?",R.drawable.artem));
        list.add(new UserContactModel("Unknown","chat: Hello, How are you?",R.drawable.user_profile_photo));
        TextAdapter adapter = new TextAdapter(list, getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setOnclickListener(this);
    }

    @Override
    public void displayDetails(UserContactModel model) {
        MainActivity mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        mainActivity.displayDetails(model);
    }
}