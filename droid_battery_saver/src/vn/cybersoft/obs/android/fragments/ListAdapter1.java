package vn.cybersoft.obs.android.fragments;

import com.ksk.droidbatterybooster.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter1 extends ArrayAdapter<String>{

	private final Context 	context;
	private final int[] 	images ;
	private String[] aa;
	private String[] bb;
	String lists;

	public ListAdapter1(Context context, int[] images, String[] aa,String[] bb ) {
		super(context, R.layout.about,aa);
		this.context = context;
		this.images  = images;
		this.aa	 	 = aa;
		this.bb		 = bb;
	}

	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater 	inflater	 	= 	(LayoutInflater) context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View       		rowView 	 	= 	inflater.inflate(R.layout.about_items, parent, false);
		ImageView  		image       	= 	(ImageView) rowView.findViewById(R.id.imageView1);	      
		TextView   		textView1 		= 	(TextView)  rowView.findViewById(R.id.txt1);
		TextView   		textView2 		= 	(TextView)  rowView.findViewById(R.id.txtPass);

		for(int i =0; i<aa.length; i++){
			textView1 .setText(""+aa[position]);
		}
		for(int j=0;j<bb.length;j++){
			textView2.setText(""+bb[position]);
		}
		for(int k=0;k<images.length;k++)
			image.setImageResource(images[position]); 
		return rowView; 
	}
}
