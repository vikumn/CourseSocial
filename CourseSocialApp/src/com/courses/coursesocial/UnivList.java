package com.courses.coursesocial;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class UnivList extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_univ_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_univ_list, menu);
        return true;
    }
}
