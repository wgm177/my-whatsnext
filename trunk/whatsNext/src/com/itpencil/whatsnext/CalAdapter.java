package com.itpencil.whatsnext;

import java.util.List;

import android.app.Activity;
import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.Rect;
//import android.graphics.drawable.BitmapDrawable;
//import android.graphics.drawable.Drawable;
//import android.graphics.drawable.ScaleDrawable;
//import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
//import android.widget.ImageView;
import android.widget.TextView;
 
public class CalAdapter extends ArrayAdapter<CalEvent> {
 
    Context context;
 
    public CalAdapter(Context context, int resourceId,List<CalEvent> items) {
        super(context, resourceId, items);
        this.context = context;
    }
 
    /*private view holder class*/
    private class ViewHolder {
        //ImageView imageWarn;
        //ImageView imageDelete;
        TextView txtTitle;
        TextView txtSDate;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        CalEvent calEvent = getItem(position);
 
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            
            holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
            holder.txtSDate = (TextView) convertView.findViewById(R.id.sdate);
            holder.txtTitle.setText(calEvent.getEvntTitle());
	        holder.txtSDate.setText(calEvent.getFormatSDate());
            
            
            // holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            
           //holder.imageWarn = (ImageView) convertView.findViewById(R.id.warn);
           //holder.imageDelete = (ImageView) convertView.findViewById(R.id.delete);
            
            
            
           convertView.setTag(holder);
        } else
        {
	        	
	        holder = (ViewHolder) convertView.getTag();
	        holder.txtTitle.setText(calEvent.getEvntTitle());
	        holder.txtSDate.setText(calEvent.getFormatSDate());
	        
	        
	        
	        
	        
	       /* Drawable notify = convertView.getResources().getDrawable( R.drawable.horn);
	        Drawable noNotify = convertView.getResources().getDrawable( R.drawable.nohorn);
	        
	        
	        if (calEvent.isReminder()) {
	        	notify = new ScaleDrawable(notify, 0, 22, 22).getDrawable();
	        	notify.setBounds(new Rect(0, 0, 22, 22));
	        	 holder.txtTitle.setCompoundDrawables( notify, null, null, null );
	            } else {
	            	noNotify = new ScaleDrawable(noNotify, 0, 22, 22).getDrawable();
	            	noNotify.setBounds(new Rect(0, 0, 22, 22));
	            	holder.txtTitle.setCompoundDrawables( noNotify, null, null, null );
	            }
	        if (calEvent.isReminder()) {
	        	notify = new ScaleDrawable(notify, 0, 22, 22).getDrawable();
	        	notify.setBounds(new Rect(0, 0, 22, 22));
	        	 holder.txtTitle.setCompoundDrawables( notify, null, null, null );
	            } else {
	            	noNotify = new ScaleDrawable(noNotify, 0, 22, 22).getDrawable();
	            	noNotify.setBounds(new Rect(0, 0, 22, 22));
	            	holder.txtTitle.setCompoundDrawables( noNotify, null, null, null );
	            }
	            */
	        
	        //convertView.setTag(holder);
        }
        return convertView;
    }
}
