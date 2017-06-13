package com.example.mandeep.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MANDEEP on 6/12/2017.
 */

public class SelectDirectory extends Activity {

    ArrayList<String> children_names = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_directory);

        String extState = Environment.getExternalStorageState();
        if (!extState.equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(getApplicationContext(),"SD card not mounted",Toast.LENGTH_SHORT).show();
        } else {
            File root = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
            File current_folder = root;
            File[] children = current_folder.listFiles();
//            for(File child : children){
//                children_names.add(child.getName());
//            }

            recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_directory);
            layoutManager = new LinearLayoutManager(this);

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(layoutManager);

            adapter = new AdapterCardDirectory(children);
            recyclerView.setAdapter(adapter);
        }
    }
}
