package com.courses.coursesocial;

public class Course {
	
	private int courseId;
	public String courseName;
	float rating;
	float feedback;
	
	
	public Course(int Id, String name, float rating, float feedback) {
		this.courseId = Id;
		this.courseName = name;
		this.rating = rating;
		this.feedback = feedback;
	}
	
	public int getId() {
		return this.courseId;
	}
	
	public void setId(int id) {
		this.courseId = id;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public void setCourseName(String name) {
		this.courseName = name;
	}
	
	public float getRating() {
		return this.rating;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public float getFeedback() {
		return this.feedback;
	}
	
	public void setFeedback(float feedback) {
		this.feedback = feedback;
	}
}
