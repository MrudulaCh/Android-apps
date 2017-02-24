package com.codepath.todolist.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.codepath.todolist.data.Todo;
import com.codepath.todolist.sql.TodoSQLiteHelper;
import java.util.Date;


/**
 * TODOs DAO object.
 * 
 * @author itcuties
 *
 */
public class TodoDAO {

	private SQLiteDatabase db;
	private TodoSQLiteHelper dbHelper;
	
	public TodoDAO(Context context) {
		dbHelper = new TodoSQLiteHelper(context);
		db = dbHelper.getWritableDatabase();
	}
	
	// Close the db
	public void close() {
		db.close();
	}
	
	/**
	 * Create new TODO object
	 * @param todoText
	 */
	public void createTodo(String todoText, int todoPriority, String todoDate, String todoNotes) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("todo", todoText);
		contentValues.put("todoPriority",todoPriority);
		contentValues.put("todoDate", todoDate);
		contentValues.put("todoNotes",todoNotes);
	    // Insert into DB
		db.insert("todosListItems", null, contentValues);
	}
	
	/**
	 * Delete TODO object
	 * @param todoId
	 */
	public void deleteTodo(int todoId) {
		// Delete from DB where id match
		db.delete("todosListItems", "_id = " + todoId, null);
	}
	
	/**
	 * Get all TODOs.
	 * @return
	 */
	public List<Todo> getTodos() {
		List<Todo> todoList = new ArrayList<Todo>();
		
		// Name of the columns we want to select
		String[] tableColumns = new String[] {"_id","todo","todoPriority","todoDate","todoNotes"};
		
		// Query the database
		Cursor cursor = db.query("todosListItems", tableColumns, null, null, null, null, null);
		cursor.moveToFirst();
		
		// Iterate the results
	    while (!cursor.isAfterLast()) {
	    	Todo todo = new Todo();
	    	// Take values from the DB
	    	todo.setId(cursor.getInt(0));
	    	todo.setText(cursor.getString(1));
			todo.setpriorityColor(cursor.getInt(2));
			todo.setdueDate(cursor.getString(3));
			todo.setlistNotes(cursor.getString(4));
	    	
	    	// Add to the DB
	    	todoList.add(todo);
	    	
	    	// Move to the next result
	    	cursor.moveToNext();
	    }
		
		return todoList;
	}

	public void updateTable(int id,String todoText, int todoPriority, String todoDate, String todoNotes){
		ContentValues contentValues = new ContentValues();
		contentValues.put("todo", todoText);
		contentValues.put("todoPriority",todoPriority);
		contentValues.put("todoDate", todoDate);
		contentValues.put("todoNotes",todoNotes);

		db.update("todosListItems", contentValues, "_id" + "=" + id,null);
	}
	
}
