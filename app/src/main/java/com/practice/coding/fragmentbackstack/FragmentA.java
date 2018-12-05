package com.practice.coding.fragmentbackstack;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentA extends Fragment {

    private TextView textView;
    String text = "I'm A..Change Orientation Will kill me";
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("tag", "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null)
        {
            Log.d("tag", "onCreate : First Time");
        }else {
            Log.d("tag", "onCreate : Sub Sequent Time");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(savedInstanceState == null)
        {
            Log.d("tag", "onCreateView : First Time");
        }else {
            Log.d("tag", "onCreateView : Sub Sequent Time");
        }
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        textView = view.findViewById(R.id.tvFA);
        textView.setText(text);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState == null)
        {
            Log.d("tag", "onActivityCreated : First Time");
        }else {
            Log.d("tag", "onActivityCreated : Sub Sequent Time");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("tag", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("tag", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("tag", "onPause");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("tag", "onSaveInstanceState");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("tag", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("tag", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("tag", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("tag", "onDetach");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("tag", "onViewStateRestored");
    }
}
