package com.androidproject;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    TextView my_goal;
    Button goal_reset;


    public HomeFragment() {
        // Required empty public constructor

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        my_goal = rootView.findViewById(R.id.my_goal);
        goal_reset = rootView.findViewById(R.id.goal_reset);


        rootView.findViewById(R.id.goal_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences goal = getActivity().getSharedPreferences("goal",MODE_PRIVATE);
                SharedPreferences.Editor goal_editor = goal.edit();
                goal_editor.clear();
                goal_editor.commit();
                Intent i = new Intent(getContext(), goal_popup.class);
                startActivity(i);

            }
    });

        SharedPreferences sp = getActivity().getSharedPreferences("goal",MODE_PRIVATE);
        String nnn = sp.getString("my_goal","");

        my_goal.setText(nnn);




        return rootView;
    }






}
