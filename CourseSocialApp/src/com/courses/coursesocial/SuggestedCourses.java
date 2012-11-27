package com.courses.coursesocial;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

public class SuggestedCourses extends Activity {
	
	ListView list;
	ShowBestCoursesAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_courses);
        
        
        setCourseContent(0);
        
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_suggested_courses, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId()) {
    	case R.id.grads:
    		setCourseContent(5);
    		break;
    		
    	case R.id.undergrads:
    		//Reset the data given in feedback
    		setCourseContent(1);
    		break;
    	
    	
    	case R.id.mostLiked:
    		setCourseContent(2);
    		//Most liked
    		break;
    	case R.id.sort_by_number:
    		setCourseContent(3);
    		break;
    	case R.id.filter:
    		
    		Intent intent = new Intent(getBaseContext(),FilterCoursesDialog.class);
    		startActivity(intent);
    		
    		break;
    		
    	}	
    	return true;
    }
    
    public void setCourseContent(int n) {
    	  Random randomgen = new Random();
          Course[] courses = new Course[20];
          int start=0, end = 0;
          switch (n){
          case 0:
        	  start = 1000;
        	  end =7000;
        	  break;
          case 1:
        	  start = 1000;
        	  end = 3000;
        	  break;
          case 2:
        	  start = 2000;
        	  end = 4000;
        	  break;
          case 3:
        	  start = 1000;
        	  end = 7000;
        	  break;
          case 5:
        	  start = 4000;
        	  end = 4000;
        	  break;        	  
          }
          for(int i=0; i< courses.length; i++)
          {
        	  
          	float rand = randomgen.nextFloat();
          	int cId = start + (int)(rand * end);
          	courses[i] = new Course(i, "CSCI " + cId, 0.0f + rand * 5f, 0.2f + rand * 4.5f);
          }
          
          ListView list = (ListView) findViewById(R.id.list);    		
  		adapter = new ShowBestCoursesAdapter(courses, getLayoutInflater());
  		list.setAdapter(adapter);   
  		
  		 TextWatcher filterTextWatcher = new TextWatcher() {

             public void afterTextChanged(Editable s) {
             }

             public void beforeTextChanged(CharSequence s, int start, int count,
                     int after) {
             }

             public void onTextChanged(CharSequence s, int start, int before,
                     int count) {
                 adapter.getFilter().filter(s);
             }

         };
  		
  		EditText inputSearch = (EditText) findViewById(R.id.searchView);
  		inputSearch.addTextChangedListener(filterTextWatcher);
        
       
    }
    
    
}
