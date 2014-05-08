package com.countmedown;

import java.util.Calendar;

import com.countmedown.R.color;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ToDoAdapter extends ArrayAdapter<Event>{
	private final Context mContext;
	private Event[] mArray;


	public ToDoAdapter(Context context, Event[] array) {
		super(context, R.layout.event_row, array);
		// TODO Auto-generated constructor stub
		mContext = context;
		mArray = array;
	}
	
	public View getView(int position, View convertView, ViewGroup parrent){
		 View view = convertView;
		 
		

		 //Inflates the view if it hadn't been yet.
		 if (view == null) {
		      LayoutInflater inflater = LayoutInflater.from(mContext);
		      view = inflater.inflate(R.layout.event_row, null);  
		 }
		 
		 TextView text = (TextView) view.findViewById(R.id.event_name);
		 ProgressBar bar = (ProgressBar) view.findViewById(R.id.event_time_bar);
		 
		
		 bar.getProgressDrawable().setColorFilter(Color.RED ,android.graphics.PorterDuff.Mode.DARKEN);
		 bar.setProgress(dayDifference(1, 100, 50));
		 
		 //Calendar temp = Calendar.getInstance();
		
		 
		 
		 return view;
	}
	
	
	
	public int dayDifference(int older, int newer, int current){
		int result;
		
		result = 100 * current;
		result = result / ( (newer - older) );
		
		
		
		
		Log.d("TGE", Integer.toString(result));
		
		if(result > 100){
			return -1;
		}
		
		return result;
	}
	
	
	

}
