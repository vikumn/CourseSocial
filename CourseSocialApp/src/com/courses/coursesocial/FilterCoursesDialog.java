package com.courses.coursesocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class FilterCoursesDialog extends Activity {

	
	ListView lview;
	FeedbackListAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_courses_dialog);
        
        lview = (ListView) findViewById(R.id.feedbackFilterView);
        
        String[] data = {"Overall", "Professor", "TA"};
        
        adapter = new FeedbackListAdapter(data,getLayoutInflater());
        lview.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_filter_courses_dialog, menu);
        return true;
    }
    
    public void setButton(View view)
    {
    	Button button = (Button) view.findViewById(view.getId());
    	
    	if (button.isPressed())    		
    		button.setPressed(false);
    	else
    		button.setPressed(true);
    			
    	
    }
   
}
