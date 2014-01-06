package com.itpencil.whatsnext;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalEvent {

	private String evntTitle;
	private String evntDesc;
	private String evntLoc;
	private String evntSDate;
	private String evntEDate;
	private String calID;
	private String calName;
	private Long evnt_id;
	private boolean reminder = false;
	
	
	
	


	public CalEvent(String calID, String evntTitle, String evntSDate, String evntDesc, String evntLoc)
	{
		this.evntTitle = evntTitle;
		this.evntDesc = evntDesc;
		this.evntLoc = evntLoc;
		this.evntSDate = evntSDate;
		this.calID = calID;
		//this.calName = calName;
		
	}


	public String getEvntTitle() {
		return evntTitle;
	}


	public void setEvntTitle(String evntTitle) {
		this.evntTitle = evntTitle;
	}


	public String getEvntDesc() {
		return evntDesc;
	}


	public void setEvntDesc(String evntDesc) {
		this.evntDesc = evntDesc;
	}


	public String getEvntLoc() {
		return evntLoc;
	}


	public void setEvntLoc(String evntLoc) {
		this.evntLoc = evntLoc;
	}


	public String getCalID() {
		return calID;
	}


	public void setCalID(String calID) {
		this.calID = calID;
	}


	public String getCalName() {
		return calName;
	}


	public void setCalName(String calName) {
		this.calName = calName;
	}
		
	
	public String getEvntSDate() {
		return this.evntSDate;
	}


	public void setEvntSDate(String evntSDate) {
		this.evntSDate = evntSDate;
	}


	public String getEvntEDate() {
		return this.evntEDate;
	}


	public void setEvntEDate(String evntEDate) {
		this.evntEDate = evntEDate;
	}


	public String getEvnt_id() {
		return "" + evnt_id;
	}


	public void setEvnt_id(long l) {
		this.evnt_id = l;
	}


	public String printShortEvent(){
		return evntTitle +" "+ "(" + getDate(Long.parseLong(this.evntSDate))+ ")";
	
	}
	
	public String getFormatSDate(){
		return getDate(Long.parseLong(this.evntSDate));
	}
	public String getFormatEDate(){
		return getDate(Long.parseLong(this.evntEDate));
	}
	
	
	public boolean isReminder() {
		return reminder;
	}


	public void setReminder(boolean reminder) {
		this.reminder = reminder;
	}


	public String[] deleteEvent(){
		return new String[]{""+this.calID, this.evntDesc, this.evntLoc};
	}
	@Override
	public String toString(){
		return this.evntTitle + "\n" + getDate(Long.parseLong(this.evntSDate));
	}
	
	public static String getDate(long milliSeconds) {
	    SimpleDateFormat formatter = new SimpleDateFormat(
	            "dd/MM/yy @ hh:mm");
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTimeInMillis(milliSeconds);
	    return formatter.format(calendar.getTime());
	}
	
}
