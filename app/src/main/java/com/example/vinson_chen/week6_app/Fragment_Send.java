package com.example.vinson_chen.week6_app;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Vinson_Chen on 2015/12/21.
 */
public class Fragment_Send extends Fragment{

    public ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_fragment_send, container, false);
    }

    @Override
    public void onResume(){
        super.onResume();

        setView();
    }

    public void setView(){

        Intent intent = getActivity().getIntent();
        Uri uri = (Uri)intent.getParcelableExtra(Intent.EXTRA_STREAM);

        img = (ImageView)getActivity().findViewById(R.id.imageView);
        img.setImageURI(uri);

        //TODO

    }


}
