package com.countmedown;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	Calendar myCalendar;
	
	private int mYear;
	private int mMonth;
	private int mDay;
	
	
	DatePickerDialog.OnDateSetListener date;
	
	private EditText edittext;
	private ListView list;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edittext = (EditText) findViewById(R.id.event_due);
				
		myCalendar = Calendar.getInstance();
		
		list = (ListView) findViewById(R.id.event_list);
		
		Event[] array = new Event[2];
		
		
		
		
		
		
		
		ToDoAdapter todo = new ToDoAdapter(getApplicationContext(), array);
		list.setAdapter(todo);


		  
		
		

		
	}
	
	
	

}
