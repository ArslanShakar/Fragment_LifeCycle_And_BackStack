package com.practice.coding.fragmentbackstack;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

    private TextView textView;
    private String data = "I am B..Change Orientation see what...";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_b, container, false);
        textView = view.findViewById(R.id.tvFB);
        textView.setText(data);
        return view;
    }
}
