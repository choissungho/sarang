package com.androidproject;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import com.androidproject.models.English;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;


public class MyPageFragment extends Fragment {
    private EditText mNameEditText;
    private EditText mAgeEditText;
    private RecyclerView mRecyclerView;

    Realm realm = Realm.getDefaultInstance();

    public MyPageFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_my_page, container, false);

        mNameEditText = rootView.findViewById(R.id.name_edit);
        mAgeEditText = rootView.findViewById(R.id.age_edit);
        mRecyclerView = rootView.findViewById(R.id.recycler_view);



        // 쿼리
        RealmResults<English> results = realm.where(English.class)
                .sort("english", Sort.ASCENDING).findAll();

        EnglishRecyclerAdapter adapter = new EnglishRecyclerAdapter(results);
        mRecyclerView.setAdapter(adapter);

        rootView.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String english = mNameEditText.getText().toString();
                String text = mAgeEditText.getText().toString();

                // DB에 저장
                realm.beginTransaction();
                English english1 = realm.createObject(English.class);
                english1.setEnglish(english);
                english1.setText(text);
                realm.commitTransaction();
            }
        });


        return rootView;
    }



}
