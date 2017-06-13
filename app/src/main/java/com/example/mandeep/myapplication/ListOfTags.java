package com.example.mandeep.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

/**
 * Created by MANDEEP on 6/11/2017.
 */

public class ListOfTags extends Activity {

    String[] items = {"#item1","#item2","#item3","#item4","#item5","#item1","#item2","#item3","#item4","#item5"};
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_tags);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AdapterCardTag(items);
        recyclerView.setAdapter(adapter);

        Button export = (Button) findViewById(R.id.export_but);
        export.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Export.class);
                startActivity(i);
            }
        });
    }
}
