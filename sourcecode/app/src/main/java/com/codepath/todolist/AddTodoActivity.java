package com.codepath.todolist;

import com.codepath.todolist.dao.TodoDAO;
import com.codepath.todolist.data.Todo;
import com.codepath.todolist.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.Fragment;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static com.codepath.todolist.R.id.button;
import static com.codepath.todolist.R.id.info;

public class AddTodoActivity extends AppCompatActivity implements OnClickListener {

	// GUI components
	private EditText todoText;		// Text field
	private EditText tododate;		// Due date field
	private Button todoPriority1;
	private Button todoPriority2;
	private Button todoPriority3;
	private Button todoPriority4;
	private Button addNewButton;	// Add new button
	private Button backButton;
	private TextView todoNotes;// Back button
	private List<Todo> todoList;

	// DAO
	private TodoDAO dao;
	private int color;
	private String flagname;
	private int id;
	private int idt;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_todo);
		// Create DAO object
		dao = new TodoDAO(this);
		Todo todo1 = new Todo();

		todoText 		= (EditText)findViewById(R.id.newTodoText);
		tododate 		= (EditText)findViewById(R.id.displayDate);
		todoPriority1   = (Button)findViewById(button);
		todoPriority2   = (Button)findViewById(R.id.button2);
		todoPriority3   = (Button)findViewById(R.id.button3);
		todoPriority4   = (Button)findViewById(R.id.button4);
		todoNotes       = (TextView)findViewById(R.id.notes1);
		addNewButton 	= (Button)findViewById(R.id.addNewTodoButton);
		backButton		= (Button)findViewById(R.id.menuGoBackButton);

		todoList = dao.getTodos();
		//Intent myIntent = new Intent(this , MainActivity.class);
		//todoText.setText(todoList.get(info));
		//onActivity(myIntent);
		//todoText.setText("testing");
		flagname = ((com.codepath.todolist.MyApplication) this.getApplication()).getFlag();
		Toast.makeText(getApplicationContext(), "flag value!"+flagname, Toast.LENGTH_LONG).show();
		if(flagname.equals("true")) {
			addNewButton.setText("Save");
		}
			id = todo1.getId();
			todoText.setText(todoList.get(id).getText());
			if (todoList.get(id).getpriorityColor() == Color.RED) {
				todoPriority1.setBackgroundColor(todoList.get(id).getpriorityColor());
				color = ((ColorDrawable) todoPriority1.getBackground()).getColor();
			}
			if (todoList.get(id).getpriorityColor() == Color.GREEN) {
				todoPriority2.setBackgroundColor(todoList.get(id).getpriorityColor());
				color = ((ColorDrawable) todoPriority2.getBackground()).getColor();
			}
			if (todoList.get(id).getpriorityColor() == Color.BLUE) {
				todoPriority3.setBackgroundColor(todoList.get(id).getpriorityColor());
				color = ((ColorDrawable) todoPriority3.getBackground()).getColor();
			}
			if (todoList.get(id).getpriorityColor() == Color.YELLOW) {
				todoPriority4.setBackgroundColor(todoList.get(id).getpriorityColor());
				color = ((ColorDrawable) todoPriority4.getBackground()).getColor();
			}
			tododate.setText(todoList.get(id).getdueDate());
			todoNotes.setText(todoList.get(id).getlistNotes());

		addNewButton.setOnClickListener(this);
		backButton.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		Boolean isOnePressed = false, isSecondPlace = false, isThirdPlace = false,isFourthPlace = false;
		if(todoPriority1.isPressed()) {
			// TODO Auto-generated method stub
			isOnePressed = true;
			todoPriority1.setBackgroundColor(Color.RED);
			todoPriority2.setBackgroundResource(R.drawable.round_button);
			todoPriority3.setBackgroundResource(R.drawable.round_button);
			todoPriority4.setBackgroundResource(R.drawable.round_button);
			color = ((ColorDrawable)todoPriority1.getBackground()).getColor();
			Toast.makeText(getApplicationContext(), "in button1!"+color,Toast.LENGTH_LONG).show();
		}
		if(todoPriority2.isPressed() ){
				todoPriority2.setBackgroundColor(Color.GREEN);
			todoPriority1.setBackgroundResource(R.drawable.round_button);
			todoPriority3.setBackgroundResource(R.drawable.round_button);
			todoPriority4.setBackgroundResource(R.drawable.round_button);
			isSecondPlace = true;
			color = ((ColorDrawable)todoPriority2.getBackground()).getColor();
		}
		if(todoPriority3.isPressed()){
			todoPriority3.setBackgroundColor(Color.BLUE);
			todoPriority1.setBackgroundResource(R.drawable.round_button);
			todoPriority2.setBackgroundResource(R.drawable.round_button);
			todoPriority4.setBackgroundResource(R.drawable.round_button);

			isThirdPlace = true;
			color = ((ColorDrawable)todoPriority3.getBackground()).getColor();
		}
		if(todoPriority4.isPressed()){
			todoPriority4.setBackgroundColor(Color.YELLOW);
			todoPriority1.setBackgroundResource(R.drawable.round_button);
			todoPriority2.setBackgroundResource(R.drawable.round_button);
			todoPriority3.setBackgroundResource(R.drawable.round_button);
			isFourthPlace = true;
			color = ((ColorDrawable)todoPriority4.getBackground()).getColor();
		}

		// If add button was clicked
		if (addNewButton.isPressed()) {
			// Get entered text
			String todoTextValue = todoText.getText().toString();
			//Date todoDueDateValue = (Date) tododate.getText();
			String todoDueDateValue = tododate.getText().toString();

			String todoNotesValue = todoNotes.getText().toString();
			Toast.makeText(getApplicationContext(), "before inserting!"+color, Toast.LENGTH_LONG).show();
			// Add text to the database
			if(flagname.equals("false")) {
				dao.createTodo(todoTextValue, color, todoDueDateValue, todoNotesValue);
			}else{
				idt = todoList.get(id).getId();
				dao.updateTable(idt,todoTextValue,color,todoDueDateValue,todoNotesValue);
			}
			// Display success information
			Toast.makeText(getApplicationContext(), "New  TODO added!", Toast.LENGTH_LONG).show();
			Intent intent = new Intent(this, MainActivity.class);
			// Start activity
			startActivity(intent);
			// Finish this activity
			this.finish();

			// Close the database
			dao.close();
			
		} else if (backButton.isPressed()) {
			// When back button is pressed
			// Create an intent
			Intent intent = new Intent(this, MainActivity.class);
			// Start activity
			startActivity(intent);
			// Finish this activity
			this.finish();
			
			// Close the database
			dao.close();
		}
		
	}

	public void selectDate(View v) {
		DialogFragment newFragment = new com.codepath.todolist.DatePickerFragment();
		newFragment.show(getSupportFragmentManager(),"datePicker");
	}
	
}
