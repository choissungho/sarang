package com.androidproject;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidproject.models.English;

import java.util.Collections;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class EnglishRecyclerAdapter extends RealmRecyclerViewAdapter<English, EnglishRecyclerAdapter.StudentViewHolder> {


    public EnglishRecyclerAdapter(
            @Nullable OrderedRealmCollection<English> data) {
        super(data, true);
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // ViewHolder 만드는 부분
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_english, viewGroup, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int position) {
        // 실제로 화면에 뿌려주는 부분
        final English english = getItem(position);
        studentViewHolder.nameTextView.setText(english.getEnglish());
        studentViewHolder.ageTextView.setText(english.getText() + "");
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView ageTextView;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_text);
            ageTextView = itemView.findViewById(R.id.age_text);
        }
    }
}
