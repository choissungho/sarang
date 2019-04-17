package com.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class goal_popup extends Activity {

    EditText goal_edit;
    Button goal_commit;
    Button goal_close;

    View.OnClickListener commit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences goal = getSharedPreferences("goal",MODE_PRIVATE);
            SharedPreferences.Editor goal_editor = goal.edit();
            goal_editor.putString("my_goal", goal_edit.getText().toString());
            goal_editor.commit();
            Intent i = new Intent(getApplicationContext(), HomeFragment.class);
            startActivity(i);
            finish();

        }
    };


    View.OnClickListener close = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_popup);

        goal_close = (Button) findViewById(R.id.goal_close);
        goal_commit = (Button) findViewById(R.id.goal_commit);
        goal_edit = (EditText) findViewById(R.id.goal_edit);

        goal_commit.setOnClickListener(commit);
        goal_close.setOnClickListener(close);


    }
}
