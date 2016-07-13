package com.example.displayjokemodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private String LOG_TAG = JokeActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        String s;
        TextView textView = (TextView) findViewById(R.id.textView2);
        try {
            s= getIntent().getStringExtra("FUNNY_JOKE");
            Log.e(LOG_TAG,s);
        }
        catch (NullPointerException e)
        {
            Log.e(LOG_TAG,"NullPointerException String was NULL");
            e.printStackTrace();
            s = "FAILED TO GET STRING";
        }
        textView.setText(s);
    }
}
