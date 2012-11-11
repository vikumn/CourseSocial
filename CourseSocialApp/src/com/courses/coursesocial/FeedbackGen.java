package com.courses.coursesocial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class FeedbackGen extends Activity {
	
	
	ListView list;
	SimpleFeedbackAdapter adapter;
	
	@Override
	public void onCreate(Bundle savedInstance)
	{
		super.onCreate(savedInstance);
		setContentView(R.layout.feedback_course);
		
		
		list = (ListView) findViewById(R.id.list);
		String[] data = {"Vikas", "Kumar"};
		//adapter = new SimpleFeedbackAdapter(this, data);
		list.setAdapter(adapter);
		
	}

 
}
