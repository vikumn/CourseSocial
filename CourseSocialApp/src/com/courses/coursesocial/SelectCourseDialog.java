package com.courses.coursesocial;

import com.courses.coursesocial.CoursesListDialog.CourseDialogListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class SelectCourseDialog extends DialogFragment{
	
	/*public interface DepartmentDialogListener {
		public void onDep_dialogPositiveClick(DialogFragment dialog);
		public void onDep_dialogNegativeClick(DialogFragment dialog);
	}
	
	DepartmentDialogListener dListener;
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            dListener = (DepartmentDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement DepartmentDialogListener");
        }
	}*/

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
	  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	  
	  builder.setTitle(R.string.select_department);
	  builder.setItems(R.array.departments, new DialogInterface.OnClickListener() {
		
		public void onClick(DialogInterface dialog, int which) {
			DialogFragment courseDialog = new CoursesListDialog(which);    		
    		courseDialog.show(getFragmentManager(), "CoursesList");
			
		}
		
		
	})
	  /*.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
              // FIRE ZE MISSILES!
          }
      })*/
      .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
              // User cancelled the dialog
          }
      });
	  // Create the AlertDialog object and return it
	  return builder.create();
  }

}
