package com.itpencil.whatsnext;

import java.util.Calendar;

import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AppointmentActivity extends Activity {
	private String what;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appointment);
		
			
		 // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        
        Intent intent = getIntent();
       //this.what = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        
        EditText editAppointment = (EditText) findViewById(R.id.editWhat);
		editAppointment.setText(this.what);
        
		
		
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.appointment, menu);
		return true;
	}
	
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	        case android.R.id.home:
	            NavUtils.navigateUpFromSameTask(this);
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	    }

	 public void postAppointment(View view){
		 
		 EditText editWhat = (EditText) findViewById(R.id.editWhat);
		 String what = editWhat.getText().toString();
		 
		 
		 Calendar beginTime = Calendar.getInstance();
			beginTime.set(2013, 0, 19, 7, 30);
			Calendar endTime = Calendar.getInstance();
			endTime.set(2013, 0, 19, 8, 30);
			Intent calIntent = null;
			calIntent = new Intent(Intent.ACTION_INSERT)
			        .setData(Events.CONTENT_URI)
			        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
			        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
			        .putExtra(Events.TITLE, what);
			        //.putExtra(Events.DESCRIPTION, "Group class")
			        //.putExtra(Events.EVENT_LOCATION, "The gym")
			        //.putExtra(Events.AVAILABILITY, Events.AVAILABILITY_BUSY)
			        //.putExtra(calIntent.EXTRA_EMAIL, "rowan@example.com,trevor@example.com");
			startActivity(calIntent);
		 
		 
	 }
	
	
}
