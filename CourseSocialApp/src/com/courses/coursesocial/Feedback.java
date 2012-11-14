package com.courses.coursesocial;

import com.courses.coursesocial.CoursesListDialog.CourseDialogListener;

import android.app.DialogFragment;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Feedback extends FragmentActivity implements CourseDialogListener{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the
     * sections. We use a {@link android.support.v4.app.FragmentPagerAdapter} derivative, which will
     * keep every loaded fragment in memory. If this becomes too memory intensive, it may be best
     * to switch to a {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    String pageTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());


        // Set up the ViewPager with the sections adapter.      
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_feedback, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId()) {
    	case R.id.menu_select_courses:
    		DialogFragment dialog = new SelectCourseDialog();    		
    		dialog.show(getFragmentManager(), "SelectCoursesDialog");
    		
    	}
    	return true;
    }
    
    


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the primary
     * sections of the app.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = new DummySectionFragment();
            Bundle args = new Bundle();
            args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, i + 1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return getString(R.string.title_section1).toUpperCase();
                case 1: return getString(R.string.title_section2).toUpperCase();
                case 2: return getString(R.string.title_section3).toUpperCase();
            }
            return null;
        }
    }

    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     */
    public class DummySectionFragment extends Fragment {
        public DummySectionFragment() {
        }

        public static final String ARG_SECTION_NUMBER = "section_number";
        ListView list;
    	SimpleFeedbackAdapter adapter;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        	
        	
        	Bundle args = getArguments();
        	int position = args.getInt(ARG_SECTION_NUMBER);
        	View view = inflater.inflate(R.layout.feedback_course, container,false);
        	String[] data = null;
        	if (position==1) {
        		//Course
        		String[] courseData = {"Coverage", "Flexibility", "Relevance", "Comprehensibility", "Exam", "Grading"};
        		data = courseData;
        	}
        	else if(position ==2) {
        		String[] profData = {"Coverage", "Knowledge"};
        		data = profData;
        	}
        	else {
        		String[] TAdata = {"Helpful", "Knowledge Depth", "Respect students", "Tough"};
        		data = TAdata;
        	}
        	
    		list = (ListView) view.findViewById(R.id.list);    		
    		adapter = new SimpleFeedbackAdapter(data, inflater);
    		list.setAdapter(adapter);
    		
    		return view;
    		        	
        	/*
            TextView textView = new TextView(getActivity());
            textView.setGravity(Gravity.CENTER);
            Bundle args = getArguments();
            textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));
            return textView;*/
        	//return inflater.inflate(R.layout.feedback_course_list, container);
        	
        	
        }
    }

	public void onDialogPositiveClick(DialogFragment dialog) {
		//CHANGE THE FEEDBACK TITLE
		CharSequence title = "Feedback:CS";
		setTitle(title);
		
	}

	public void onDialogNegativeClick(DialogFragment dialog) {
		//DO NOTHING
		
	}
}
