package com.codepath.todolist.data;

import java.util.Date;

public class Todo {

	private int id;
	
	private String text;

	private int priorityColor;

	private String dueDate;

	private String listNotes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getdueDate(){ return dueDate;}

	public void setdueDate(String dueDate) { this.dueDate = dueDate;}

	public int getpriorityColor() {
		return priorityColor;
	}

	public void setpriorityColor(int priorityColor) {
		this.priorityColor = priorityColor;
	}

	public String getlistNotes() {
		return listNotes;
	}

	public void setlistNotes(String listNotes) {
		this.listNotes = listNotes;
	}


}
