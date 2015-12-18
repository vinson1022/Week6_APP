package com.example.vinson_chen.week6_app;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_send_out;

    private View.OnClickListener Button_Listener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            if(v.getId() == button_send_out.getId()){
                Fragment_Send_Out fragment1 = new Fragment_Send_Out();
                getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment1).commit();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setView();
        setListener();

    }

    public void setView(){

        Fragment_Send_Out fragment1 = new Fragment_Send_Out();
        getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment1).commit();

        button_send_out = (Button)findViewById(R.id.button_send_out);

    }

    public void setListener(){

        button_send_out.setOnClickListener(Button_Listener);

    }
}
