package com.itpencil.whatsnext;

import java.util.ArrayList;
import java.util.Calendar;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class EventsFromCal {

	public static ArrayList<CalEvent> allOfEvent = new ArrayList<CalEvent>();
		
	public static ArrayList<CalEvent> readCalendarEvent(Context context, int days) {
				
		
		long now;
		long toDate;
		Calendar cal = Calendar.getInstance();
		
		now = cal.getTimeInMillis();
		cal.add(Calendar.DAY_OF_MONTH, days); 
		toDate = cal.getTimeInMillis();
		
		
		
		Cursor cursor = context.getContentResolver()
		            .query(
		                    Uri.parse("content://com.android.calendar/events"),
		                    new String[] {  "calendar_id", "title", "description",
		                            "dtstart", "dtend", "eventLocation", "ownerAccount", "_id"}, "dtstart >'" + now + "' AND dtstart < '" + toDate + "'",
		                    null, "dtstart ASC");
		
		
		    cursor.moveToFirst();
		    // fetching calendars name
		    String CNames[] = new String[cursor.getCount()];
		    
		    // fetching calendars id
		    allOfEvent.clear();
		    for (int i = 0; i < CNames.length; i++) {
		    	//creating calEvent object and storing in arraylist
		    		CalEvent tempCalEvnt = new CalEvent(
		    				cursor.getString(0), cursor.getString(1), cursor.getString(3), 
		    				cursor.getString(2), cursor.getString(5));
		    		tempCalEvnt.setEvntEDate(cursor.getString(4));
		    		
		    		tempCalEvnt.setEvnt_id(cursor.getLong(7));
		    		allOfEvent.add(tempCalEvnt);
		    	
		       CNames[i] = cursor.getString(1);
		        cursor.moveToNext();
		    }
	    return allOfEvent;
	}

	
	
	
}
