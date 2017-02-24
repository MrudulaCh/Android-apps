package com.codepath.todolist;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.codepath.todolist.data.Todo;

/**
 * List adapter for storing TODOs data
 * 
 * @author itcuties
 *
 */
public class ListAdapter extends ArrayAdapter<Todo> {

	// List context
    private final Context context;
    // List values
    private final List<Todo> todoList;
	
	public ListAdapter(Context context, List<Todo> todoList) {
		super(context, R.layout.activity_main, todoList);
		this.context = context;
		this.todoList = todoList;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 
        View rowView = inflater.inflate(R.layout.activity_main, parent, false);
         
        TextView todoText = (TextView) rowView.findViewById(R.id.todoText);
        todoText.setText(todoList.get(position).getText());

		int priorityColor = (todoList.get(position).getpriorityColor());
		//Toast.makeText(getContext(), "color is"+priorityColor, Toast.LENGTH_LONG).show();

		//todoText.setBackgroundColor(priorityColor);
		todoText.setTextColor(priorityColor);

        return rowView;
	}
	
}
