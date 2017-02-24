package com.codepath.todolist;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.Toast;

import com.codepath.todolist.R;
import com.codepath.todolist.dao.TodoDAO;
import com.codepath.todolist.data.Todo;

import static com.codepath.todolist.R.id.todoText;

/**
 * Main activity which displays a list of TODOs.
 * 
 * @author itcuties
 *
 */
public class MainActivity extends ListActivity {

	// DAO
	private TodoDAO dao;
	//int position = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Create DAO object
		dao = new TodoDAO(this);
		
		// Set the list adapter and get TODOs list via DAO
		setListAdapter(new ListAdapter(this, dao.getTodos()));
		registerForContextMenu(getListView());
		
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu,View v, ContextMenu.ContextMenuInfo menuInfo){

			AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo)menuInfo;
			MenuItem mnu1=menu.add(0,0,0,"Edit");
			MenuItem mnu2=menu.add(0,1,1,"Delete");

	}

	@Override
	public boolean onContextItemSelected(MenuItem menuItem){
		AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)menuItem.getMenuInfo();
		final Todo todo = (Todo) getListAdapter().getItem(info.position);

		switch (menuItem.getItemId()) {
			case 0:
				((com.codepath.todolist.MyApplication) this.getApplication()).setFlag("true");
				Intent intent = new Intent(this, com.codepath.todolist.AddTodoActivity.class);
				// Start activity
				//todo.setId(todo.getId());
				//intent.putExtra("key",todo.getId());
				Toast.makeText(getApplicationContext(), "todo value!"+todo.getId(), Toast.LENGTH_LONG).show();
				startActivity(intent);
				//startActivityForResult(intent, 0);
				// Finish this activity
				this.finish();
				//dao.deleteTodo(todo.getId());

				//Toast.makeText(this, "Delete Selected", Toast.LENGTH_LONG).show();
				break;
			case 1:
				//final Todo todo = (Todo) getListAdapter().getItem(info.position);
				AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
				builder1.setMessage("Are you sure to delete this todo item?");
				builder1.setCancelable(true);

				builder1.setPositiveButton(
						"Delete",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Toast.makeText(getApplicationContext(), "Deleted!", Toast.LENGTH_LONG).show();
								dao.deleteTodo(todo.getId());
								setListAdapter(new ListAdapter(getApplicationContext(), dao.getTodos()));
							}
						});
				builder1.setNegativeButton(
						"No",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});

				AlertDialog alert11 = builder1.create();
				alert11.show();
				break;

			default:
				break;

		}
		return true;
	}


	/* ************************************************************* *
	 * Menu service methods
	 * ************************************************************* */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		((com.codepath.todolist.MyApplication) this.getApplication()).setFlag("false");
		//getMenuInflater().inflate(R.menu.activity_main, menu);
		getMenuInflater().inflate(R.menu.activity_headmenu,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Since we have only ONE option this code is not complicated :)

		// Create an intent
		Intent intent = new Intent(this, com.codepath.todolist.AddTodoActivity.class);
		// Start activity
		startActivity(intent);
		// Finish this activity
		this.finish();

		// Close the database
		dao.close();

		return super.onOptionsItemSelected(item);
	}

}
