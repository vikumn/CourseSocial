package com.courses.coursesocial;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

public class FeedbackListAdapter extends BaseAdapter{	 	
	 	private static LayoutInflater inflater=null;
	 	private String[] data;
	    
	    public FeedbackListAdapter(String[] d, LayoutInflater inflater) {
	        //fragment = a;
	        data=d;
	        //this.inflater = (LayoutInflater)fragment.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        this.inflater = inflater;
	        
	    }
	 
	    public int getCount() {
	        return data.length;
	    }
	 
	    public Object getItem(int position) {
	        return position;
	    }
	 
	    public long getItemId(int position) {
	        return position;
	    }
	 
	    public View getView(int position, View convertView, ViewGroup parent) {
	        View vi=convertView;
	        if(convertView==null)
	            vi = inflater.inflate(R.layout.feedback_filter_row, null);
	 
	        TextView title = (TextView)vi.findViewById(R.id.title); // title
	        String text = data[position];
	        // Setting all values in listview
	        title.setText(text);
	        
	        RatingBar rbar = (RatingBar) vi.findViewById(R.id.ratingBar);
	        rbar.setRating(1.25f * position);
	        return vi;
	    }
	
	}
