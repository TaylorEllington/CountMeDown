package com.countmedown;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.countmedown.R.color;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
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
		 long d1 = 0;
		 long d2 = 0;
		 long d3 = 0;
		 
		 SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
		 Calendar cal= Calendar.getInstance();
		 
		 
		 
		 try {
				d1 = formater.parse(mArray[position].getStartDate() ).getTime();
				d2 = formater.parse(mArray[position].getEndDate() ).getTime();
				d3 = formater.parse(formater.format(cal.getTime()) ).getTime();
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		Log.d("start", Long.toString(d1));
		Log.d("end", Long.toString(d2));
		Log.d("now", Long.toString(d3));

		 //Inflates the view if it hadn't been yet.
		 if (view == null) {
		      LayoutInflater inflater = LayoutInflater.from(mContext);
		      view = inflater.inflate(R.layout.event_row, null);  
		 }
		 
		 TextView text = (TextView) view.findViewById(R.id.event_title);
		 ProgressBar bar = (ProgressBar) view.findViewById(R.id.event_time_bar);
		 
		 text.setText(mArray[position].getName());
		 
		 int temp = dayDifference(d1, d2, d3);
		 
		 
		 //based on ratio pick one of 5 colors, gives a sense of intuitive urgency
		 
		 if(temp < 35){
			 bar.getProgressDrawable().setColorFilter(getContext().getResources().getColor(R.color.bar_green) 
					 ,android.graphics.PorterDuff.Mode.MULTIPLY);
		 }else if(temp < 55){
			 bar.getProgressDrawable().setColorFilter(getContext().getResources().getColor(R.color.bar_yellow) 
					 ,android.graphics.PorterDuff.Mode.MULTIPLY);
		 }else if(temp < 75){
			 bar.getProgressDrawable().setColorFilter(getContext().getResources().getColor(R.color.bar_orange) 
					 ,android.graphics.PorterDuff.Mode.MULTIPLY);
		 }else if(temp < 100){
			 bar.getProgressDrawable().setColorFilter(getContext().getResources().getColor(R.color.bar_red) 
					 ,android.graphics.PorterDuff.Mode.MULTIPLY);
		 }
		 
		 
		

		
		
		

		 Log.d("TGE", Long.toString(Math.abs((d1-d2)/(1000*60*60*24)))   );
		 
		 
		 
		 bar.setProgress(temp);
		 
		 
		
		 
		 
		 return view;
	}
	

	public int dayDifference(long older, long newer, long current){
		long result;
//		Log.d("older", Integer.toString(older));
//		Log.d("newer", Integer.toString(newer));
//		Log.d("current", Integer.toString(current));
		result = 100 * ((current/(1000*60*60*24))- (older/(1000*60*60*24)));
		result = result / ( ((newer/(1000*60*60*24)) - (older/(1000*60*60*24)) ) );
		
		
		
		
		Log.d("TGE--", Long.toString(result));
		
		if(result > 100){
			return -1;
		}
		
		return (int) result;
	}
	
	
	

}
