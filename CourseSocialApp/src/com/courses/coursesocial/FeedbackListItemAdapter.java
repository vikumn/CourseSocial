package com.courses.coursesocial;


import com.courses.coursesocial.Feedback.DummySectionFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class FeedbackListItemAdapter extends BaseAdapter{
	
	int feedbackItem = 0; 
	LayoutInflater _inflater = null;

	public FeedbackListItemAdapter(LayoutInflater inflater) {
		super();
		_inflater = inflater;
		// TODO Auto-generated constructor stub
		
	}


	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	public View getView(int arg0, View convertView, ViewGroup arg2) {
		View v = convertView;
		  if (v == null) {
		           v= _inflater.inflate(R.layout.feedback_course_list, null);
		  }
		 
		
		
		return v;
	}}
