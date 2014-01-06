package com.itpencil.whatsnext;

import java.util.ArrayList;
import java.util.Calendar;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract.Events;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ListView lv; 
	//private int days = 14;
	
	
	public void onCreate(Bundle saveInstanceState) {
		super.onCreate(saveInstanceState);
		setContentView(R.layout.activity_main);

        popList(7);
        
   }
	
	
	
	public void popList(int days){
		lv = (ListView) findViewById(R.id.listappointments);
		
		ArrayList<CalEvent> contact_array_list = EventsFromCal.readCalendarEvent(this, days);
	        CalAdapter calAdapter = new CalAdapter(
	                this, 
	                android.R.layout.activity_list_item,
	                contact_array_list);

	        lv.setAdapter(calAdapter); 
	        
	        lv.setOnItemClickListener(new OnItemClickListener() {
	        	  @Override
	        	  public void onItemClick(AdapterView<?> parent, View view,
	        	    int position, long id) {
	        		  
	        		CalEvent calEvent = (CalEvent)parent.getItemAtPosition(position);
	        		String details = "***** " + calEvent.getEvntTitle() + "*****\n";
	        		details += "Description: " + calEvent.getEvntDesc() + "\n";
	        		details += "Start: " + calEvent.getFormatSDate() + "\n";
	        		details += "End  : " + calEvent.getFormatEDate() + "\n";
	        		details += "Location: " + calEvent.getEvntLoc() + "\n";
	        		
	        		
	        	    Toast.makeText(getApplicationContext(),
	        	      details, Toast.LENGTH_LONG)
	        	      .show();
	        	  }
	        	}); 
	        
	        lv.setOnItemLongClickListener(new OnItemLongClickListener() {
	        	  
	        	  public boolean onItemLongClick(AdapterView<?> parent, View view,
	        	    int position, long id) {
	        		  
	        		CalEvent calEvent = (CalEvent)parent.getItemAtPosition(position);
	        		long eventID = Long.parseLong(calEvent.getEvnt_id());
	        		
	        		Uri uri = ContentUris.withAppendedId(Events.CONTENT_URI, eventID);
	        		Intent intent = new Intent(Intent.ACTION_VIEW)
	        		   .setData(uri)
	        		   .putExtra(Events.TITLE, calEvent.getEvntTitle())
		        		.putExtra(Events.DTSTART, calEvent.getEvntSDate())
		        		.putExtra(Events.DTEND, calEvent.getEvntEDate())
		        		.putExtra(Events.DESCRIPTION, calEvent.getEvntDesc())
		        		.putExtra(Events.EVENT_LOCATION, calEvent.getEvntLoc());
	        		startActivity(intent);
					return false;
	        		
	        	    
	        	  }
	        	}); 
	        
	       
	}
	
		public void addEvent(View view){
			final EditText editNewAppointment = (EditText) findViewById(R.id.editNewAppointment);
			String newTitle = editNewAppointment.getText().toString();
			Calendar beginTime = Calendar.getInstance();
			Calendar endTime = Calendar.getInstance();
			endTime.add(Calendar.HOUR_OF_DAY,1);
			Intent intent = new Intent(Intent.ACTION_INSERT)
			        .setData(Events.CONTENT_URI)
			        .putExtra(Events.TITLE, newTitle)
			        .putExtra(Events.DTSTART, beginTime)
			        .putExtra(Events.DTEND, endTime)
			        .putExtra(Events.DESCRIPTION, "F21MC Class")
			        .putExtra(Events.EVENT_LOCATION, "Heriot Watt University")
			        .putExtra(Events.CALENDAR_ID, "1");
			editNewAppointment.setText("");
			startActivity(intent);
			
		}
	
	
	
	 @Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.main, menu);
	    return true;
	  }

	 	 
	  
	  public void popList7(View view) {
		     popList(7);
		 }
	  
	  public void popList31(View view) {
		     popList(30);
		 }
	  
	  public void popList365(View view) {
		     popList(365);
		 }
	  
	  
	  
	  public void deleteEvent(View view) {
		    
		  
		  
		 }
	  
	  

}
