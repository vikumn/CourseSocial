package com.courses.coursesocial;


import java.util.ArrayList;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class ShowBestCoursesAdapter extends BaseAdapter implements Filterable{
	 	private Fragment fragment;
	 	private static LayoutInflater inflater=null;
	 	private Course[] data;
	    
	    public ShowBestCoursesAdapter(Course[] courses, LayoutInflater inflater) {
	        //fragment = a;
	        data=courses;
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
	            vi = inflater.inflate(R.layout.showfeedback_list_row, null);
	 
	        TextView title = (TextView)vi.findViewById(R.id.courseName); // title
	        Course  course = data[position];
	        // Setting all values in listview
	        title.setText(course.getCourseName());
	        return vi;
	    }

	    
		public Filter getFilter() {
	    	
	    	Filter filter = null;

            if(filter == null)
                filter = new Filter
                () {
					
					@Override
					protected void publishResults(CharSequence constraint, FilterResults results) {
						
						
					}
					
					@Override
					protected FilterResults performFiltering(CharSequence constraint) {
						constraint = constraint.toString().toLowerCase();

		                FilterResults newFilterResults = new FilterResults();

		                if (constraint != null && constraint.length() > 0) {


		                    ArrayList<String> auxData = new ArrayList<String>();

		                    for (int i = 0; i < data.length; i++) {
		                        if (data[i].getCourseName().toLowerCase().contains(constraint))
		                            auxData.add(data[i].getCourseName());
		                    }

		                    newFilterResults.count = auxData.size();
		                    newFilterResults.values = auxData;
		                } else {

		                    newFilterResults.count = data.length;
		                    newFilterResults.values = data;
		                }

		                return newFilterResults;
						
					}
				};
            return filter;
		
		}
	
	}
