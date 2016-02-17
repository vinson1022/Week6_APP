package com.example.vinson_chen.week6_app;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_send_out, button_send;

    private View.OnClickListener Button_Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == button_send_out.getId()) {
                Fragment_Send_Out fragment1 = new Fragment_Send_Out();
                getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment1).commit();
            } else if (v.getId() == button_send.getId()) {
                Fragment_Send fragment1 = new Fragment_Send();
                getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment1).commit();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Vinson","onCreate");

        Intent intent = getIntent();

        setView();
        setListener();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        if (intent.getType() != null) {
            if (intent.getType().indexOf("image/") != -1) {
                Fragment_Send fragment1 = new Fragment_Send();
                getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment1).commit();
            } else {
                Fragment_Send_Out fragment1 = new Fragment_Send_Out();
                getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment1).commit();
            }
        } else {
            Fragment_Send_Out fragment1 = new Fragment_Send_Out();
            getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment1).commit();
        }

    }

    public void setView() {

        button_send_out = (Button) findViewById(R.id.button_send_out);
        button_send = (Button) findViewById(R.id.button_send);

    }

    public void setListener() {

        button_send_out.setOnClickListener(Button_Listener);
        button_send.setOnClickListener(Button_Listener);

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("Vinson","onDestroy");
    }

}
