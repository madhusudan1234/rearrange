package com.example.mandeep.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by MANDEEP on 6/2/2017.
 */

public class SegOrExp extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seg_or_exp);

        TextView exp = (TextView) findViewById(R.id.export);
        TextView seg = (TextView) findViewById(R.id.segregate);

        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListOfTags.class);
                startActivity(i);
            }
        });

        seg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SelectDirectory.class);
                startActivity(i);
            }
        });
    }
}
