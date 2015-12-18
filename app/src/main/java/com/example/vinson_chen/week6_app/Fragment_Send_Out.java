package com.example.vinson_chen.week6_app;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Calendar;

/**
 * Created by Vinson_Chen on 2015/12/18.
 */
public class Fragment_Send_Out extends Fragment implements View.OnClickListener {


    Button button_send_out_calendar,button_send_out_email,button_send_out_call,button_send_out_web,button_send_out_map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_fragment_send_out, container, false);
    }

    @Override
    public void onResume(){
        super.onResume();

        setView();
        setListener();
    }

    public void setView(){

        button_send_out_calendar = (Button)getActivity().findViewById(R.id.button_send_out_calendar);
        button_send_out_email = (Button)getActivity().findViewById(R.id.button_send_out_email);
        button_send_out_call = (Button)getActivity().findViewById(R.id.button_send_out_call);
        button_send_out_web = (Button)getActivity().findViewById(R.id.button_send_out_web);
        button_send_out_map = (Button)getActivity().findViewById(R.id.button_send_out_map);

    }

    public void setListener(){

        button_send_out_calendar.setOnClickListener(this);
        button_send_out_call.setOnClickListener(this);
        button_send_out_email.setOnClickListener(this);
        button_send_out_map.setOnClickListener(this);
        button_send_out_web.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == button_send_out_calendar.getId()){
//            Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
//            Calendar beginTime = Calendar.getInstance().set(2012, 0, 19, 7, 30);
//            Calendar endTime = Calendar.getInstance().set(2012, 0, 19, 10, 30);
//            calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
//            calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
//            calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class");
//            calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");
        }else if(v.getId() == button_send_out_email.getId()){
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"jon@example.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
            emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
            startActivity(emailIntent);
        }else if (v.getId() == button_send_out_web.getId()){
            Log.d("Vinson","Web");
            Uri webpage = Uri.parse("http://www.android.com");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(webIntent);
        }else if(v.getId() == button_send_out_map.getId()){
            Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
            startActivity(mapIntent);
        }else if(v.getId() == button_send_out_call.getId()){
            Uri number = Uri.parse("tel:5551234");
            Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
            startActivity(callIntent);
        }

    }
}
