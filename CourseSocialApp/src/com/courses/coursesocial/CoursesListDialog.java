package com.courses.coursesocial;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;

public class CoursesListDialog extends DialogFragment {
	
	int department = -1;
	int courseSelected = -1;
	String courseName = null;
	
	public CoursesListDialog(int department) {
		this.department = department;
	}
	
	public interface CourseDialogListener {
		public void onDialogPositiveClick(DialogFragment dialog, String courseName, int courseId);
		public void onDialogNegativeClick(DialogFragment dialog);
	}
	
	CourseDialogListener dListener;
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            dListener = (CourseDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement CourseDialogListener");
        }
	}
	
	

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
	  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	  
	  builder.setTitle(R.string.select_courses);
	  
	  int resId = R.array.none;
	  switch (this.department){
	  case 0:
		  //Computer Science		  
		  resId = R.array.csci;
		  break;
	  case 1:
		  resId = R.array.cmpi;
		  break;
	  case 2:
		  resId = R.array.ee;
		  break;
	  case 3:
		  resId = R.array.me;
		  break;
	  default: 
		  resId = R.array.none;
	  }
	  
	  final int rId = resId;
	  
	  builder.setSingleChoiceItems(resId, 0, new DialogInterface.OnClickListener() {
		
		public void onClick(DialogInterface dialog, int which) {
			courseSelected = which;
			courseName = getCourseName(rId, which);
			
		}
	})
	  
	  
	  .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
        	  dListener.onDialogPositiveClick(CoursesListDialog.this, courseName, courseSelected);
          }
      })
      .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
              dListener.onDialogNegativeClick(CoursesListDialog.this);
              DialogFragment df = new SelectCourseDialog(department);
              df.show(getFragmentManager(), "SelectCourseDialog");
          }
      });
	  // Create the AlertDialog object and return it
	  return builder.create();
  }
  
  private String getCourseName(int resId, int position){
	  String[] courseArrays = getResources().getStringArray(resId);	  
	  return courseArrays[position];  
	  
  }
  
}
