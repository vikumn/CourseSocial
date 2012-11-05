package com.courses.coursesocial;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleFeedbackAdapter extends BaseAdapter{
	 	private Activity activity;
	 	private static LayoutInflater inflater=null;
	 	private String[] data;
	    
	    public SimpleFeedbackAdapter(Activity a, String[] d) {
	        activity = a;
	        data=d;
	        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        
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
	            vi = inflater.inflate(R.layout.feedback_list_row, null);
	 
	        TextView title = (TextView)vi.findViewById(R.id.title); // title
	        String text = data[position];
	        // Setting all values in listview
	        title.setText(text);
	        return vi;
	    }
	
	}
