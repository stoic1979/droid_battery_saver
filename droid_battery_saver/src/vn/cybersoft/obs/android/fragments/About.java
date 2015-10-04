package vn.cybersoft.obs.android.fragments;

import com.ksk.droidbatterybooster.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class About extends Fragment implements OnItemClickListener {

	private ListView list;
	private ListAdapter1 adapter;

	String[] names = new String[] { "Version", "Rate Us", "Share App",
			"Suggestion" };
	String[] small = new String[] { "1.0.0", "If like us,rate us",
			"If like us,let others know",
			"Please give us your suggestion to improve" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.about, container, false);
		// setContentView(R.layout.about);

		list = (ListView) view.findViewById(R.id.list);
		adapter = new ListAdapter1(getActivity(), Config.images1, names, small);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
		// TODO Auto-generated method stub
		return view;
	}

	// @Override
	// protected void onCreate(Bundle savedInstanceState) {
	// super.onCreate(savedInstanceState);
	// setContentView(R.layout.about);
	//
	// list = (ListView) findViewById(R.id.list);
	// adapter = new ListAdapter1(this, Config.images1, names, small);
	// list.setAdapter(adapter);
	// list.setOnItemClickListener(this);
	// }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		switch (position) {
		case 1:
			AppRater.showRateDialog(getActivity(), null);
			break;

		case 2:
			Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
			shareIntent.setType("text/plain");
			shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
					"Droid Battery Booster");
			String shareMessage = "https://play.google.com/store/search?q=com.ksk.droidbatterybooster&hl=en";
			shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,
					shareMessage);
			startActivity(Intent.createChooser(shareIntent,
					"Share This App Via"));
			break;

		case 3:
			Intent obj1 = new Intent(getActivity(), ContactUs.class);
			startActivity(obj1);
			break;
		}
	}
}
