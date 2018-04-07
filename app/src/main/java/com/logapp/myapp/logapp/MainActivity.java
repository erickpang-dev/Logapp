package com.logapp.myapp.logapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class MainActivity extends Activity {

    private Button button;
    private TextView textView;
    private ConstraintLayout constraintLayout;
    private ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonId);


        textView = findViewById(R.id.textViewId);
        constraintLayout = findViewById(R.id.constraintLayoutId);
        scrollView = findViewById(R.id.scrollViewId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String showText;
                showText = "Text to be received.";
                showWriteTextOnLog(showText, textView, scrollView);
            }
        });

        constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (scrollView.isShown()) {
                    scrollView.setVisibility(View.GONE);
                } else {
                    scrollView.setVisibility(View.VISIBLE);
                }
                
                return false;
            }
        });


    }


    public void showWriteTextOnLog(String text, TextView tV, ScrollView sV) {
        Date now = new Date();
        tV.append(new SimpleDateFormat("HH:mm:ss").format(now) + " - " + text + "\n");
        sV.fullScroll(View.FOCUS_DOWN);

    }

}
