package com.androidproject;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.androidproject.models.English;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewFragment extends Fragment {

    TextView eng;
    TextView kor;

    Realm realm = Realm.getDefaultInstance();


    public ReviewFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_review, container, false);
//        Objects.requireNonNull(activity.getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
//        activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black);

        final RealmResults<English> results = realm.where(English.class).findAll();

        final List<English> englishList = new ArrayList<>();
        for(English english : results) {
            englishList.add(english);
        }

        eng = rootView.findViewById(R.id.eng);
        kor = rootView.findViewById(R.id.kor);

        rootView.findViewById(R.id.yes_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Collections.shuffle(englishList);
                eng.setText(englishList.get(0).getEnglish());

            }
        });



        // Inflate the layout for this fragment
        return rootView;
    }




}
