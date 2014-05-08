package com.countmedown;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	

	boolean editing;  //boolean flag for backbutton
	LinearLayout edit;
	RelativeLayout display;
	
	ArrayList<Event> events = new ArrayList<Event>();
	
	
	DatePickerDialog.OnDateSetListener date;
	
	private EditText edittext;
	private ListView list;
	
	
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return true;
	}
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editing = false;
		edittext = (EditText) findViewById(R.id.event_due);
		edit = (LinearLayout) findViewById(R.id.edit);
		display = (RelativeLayout) findViewById(R.id.display);
				
		
		
		list = (ListView) findViewById(R.id.event_list);
		
		
		
		//sample data 
		Event holder = new Event();
		
		
		holder.setName("Presentation");
		holder.setStartDate("2014-4-19");
		holder.setEndDate("2014-5-9");
		
		events.add(holder);
		
		holder = new Event();
		holder.setName("Study for Final");
		holder.setStartDate("2014-5-3");
		holder.setEndDate("2014-5-13");
		events.add(holder);
		
		holder = new Event();
		holder.setName("Signup for Classes");
		holder.setStartDate("2014-5-7");
		holder.setEndDate("2014-5-13");
		events.add(holder);
		
		
		//array[1] = new Event();
		//array[1].setName("time for sleep");
		
		ImageView addButton = (ImageView) findViewById(R.id.add_event_button);
		addButton.setOnClickListener(new addButtonListener());
		
		
		
		ToDoAdapter todo = new ToDoAdapter(getApplicationContext(),  events.toArray(new Event[0]));
		list.setAdapter(todo);


	}
	
		@Override
		public void onBackPressed(){
			
			if(editing == true){
				//close editing panel with out changing stuff
				editing = false;
				
				display.setVisibility(View.VISIBLE);
				edit.setVisibility(View.GONE);
				
			}else{
				//normal quit
				super.onBackPressed();
			}
			
		}
	
	
	class addButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			editing = true;
			display.setVisibility(View.GONE);
			edit.setVisibility(View.VISIBLE);
			
		}
		
	}//end of addButtonListener
	
	
	
	class submitButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
		
	}// end of submit button
	
	
	

}
