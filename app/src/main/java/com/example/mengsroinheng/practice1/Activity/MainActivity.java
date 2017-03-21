package com.example.mengsroinheng.practice1.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mengsroinheng.practice1.BlankFragment;
import com.example.mengsroinheng.practice1.Fragment.AssignmentFragment;
import com.example.mengsroinheng.practice1.Fragment.SettingFragment;
import com.example.mengsroinheng.practice1.Fragment.DocumentFragment;
import com.example.mengsroinheng.practice1.Fragment.FeedbackFragment;
import com.example.mengsroinheng.practice1.Fragment.ProfileFragment;
import com.example.mengsroinheng.practice1.R;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton_document, imageButton_assignment, imageButton_feedback, imageButton_setting, imageButton_profile;
    TextView textView_title;
    private DocumentFragment documentFragment;
    private AssignmentFragment assignmentFragment;
    private SettingFragment settingFragment;
    private FeedbackFragment feedbackFragment;
    private ProfileFragment profileFragment;
    boolean isFragmentShowing;
    View layout_menu, container_document, container_assignment, container_feedback, container_profile, container_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout_menu= findViewById(R.id.layout_menu);
        imageButton_document= (ImageButton) findViewById(R.id.imageButton_document);
        imageButton_profile = (ImageButton) findViewById(R.id.imageButton_profile);
        imageButton_assignment= (ImageButton) findViewById(R.id.imageButton_assignment);
        imageButton_setting= (ImageButton) findViewById(R.id.imageButton_setting);
        imageButton_feedback= (ImageButton) findViewById(R.id.imageButton_feedback);
        textView_title= (TextView) findViewById(R.id.textView_title);
        /*
        container_assignment= (LinearLayout) findViewById(R.id.container_assignment);
        container_document= (LinearLayout) findViewById(R.id.container_document);
        container_feedback= (LinearLayout) findViewById(R.id.container_feedback);
        container_profile= (LinearLayout) findViewById(R.id.container_profile);
        container_setting= (LinearLayout) findViewById(R.id.container_setting);
        */
        documentFragment = new DocumentFragment();
        assignmentFragment = new AssignmentFragment();
        settingFragment = new SettingFragment();
        feedbackFragment= new FeedbackFragment();
        profileFragment = new ProfileFragment();
        onRunning();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager= getFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    private void onRunning(){

        imageButton_document.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(documentFragment);
                textView_title.setText("Document");
            }
        });

        imageButton_assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(assignmentFragment);
                textView_title.setText("Assignment");
            }
        });

        imageButton_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(feedbackFragment);
                textView_title.setText("Feedback");
            }
        });

        imageButton_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(profileFragment);
                textView_title.setText("Profile");
            }
        });

        imageButton_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(settingFragment);
                textView_title.setText("Setting");
            }
        });
    }


    private void showFragment(Fragment fragment){
        replaceFragment(fragment);
        if (fragment==null){
            isFragmentShowing= false;
            layout_menu.setVisibility(View.VISIBLE);
            findViewById(R.id.fragment_content).setVisibility(View.GONE);
        }else {
            isFragmentShowing=true;
            layout_menu.setVisibility(View.GONE);
            findViewById(R.id.fragment_content).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        if (isFragmentShowing){
            isFragmentShowing=false;
            textView_title.setText("Mobile Online Classroom");
            layout_menu.setVisibility(View.VISIBLE);
            findViewById(R.id.fragment_content).setVisibility(View.GONE);
        }else{
            super.onBackPressed();
        }
    }
}
