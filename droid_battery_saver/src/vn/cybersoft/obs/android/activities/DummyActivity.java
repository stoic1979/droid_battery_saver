/*
 * Copyright (C) 2014 IUH €yber$oft Team
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package vn.cybersoft.obs.android.activities;

/**
 * @author Luan Vu (hlvu.cybersoft@gmail.com)
 *
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

import vn.cybersoft.obs.android.fragments.About;
import vn.cybersoft.obs.android.fragments.BatteryInfoFragment;
import vn.cybersoft.obs.android.fragments.ConsumptionFragment;
import vn.cybersoft.obs.android.fragments.OptimizationFragment;
import vn.cybersoft.obs.android.models.BatteryInfo;

import com.ksk.droidbatterybooster.R;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DummyActivity extends FragmentActivity  {

	private double					speed		= 0.0;
	private TextView				text1;
	private TextView				textMin;
	private TextView				textMax;
	private TextView				textAvg;

	private boolean					flag		= true;
	long							startTime;
	private String					speedString;
	private double					max			= 0;
	private double					min			= 0;
	private double					avg			= 0;
	public static Activity	instance	= null;

	private DrawerLayout			mDrawerLayout;

	private ListView				mDrawerList;

	private ActionBarDrawerToggle	mDrawerToggle;
	private String					mTitle		= "";

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		instance = this;
		
		View homeIcon = findViewById(android.R.id.home);
		((View) homeIcon.getParent()).setVisibility(View.GONE);

		//mTitle = "JAVATECHIG.COM";
		//getActionBar().setTitle(mTitle);
		getSupportFragmentManager().beginTransaction()
				.add(R.id.content_frame, new BatteryInfoFragment()).commit();


		

		setActionBar();

		mDrawerLayout 	= (DrawerLayout) 	findViewById(R.id.drawer_layout);
		mDrawerList 	= (ListView) 		findViewById(R.id.drawer_list);
		
		mDrawerToggle 	= new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			/** Called when drawer is closed */
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu();

			}

			/** Called when a drawer is opened */
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle("JAVATECHIG.COM");
				invalidateOptionsMenu();
			}

		};

		// Setting DrawerToggle on DrawerLayout
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getBaseContext(), R.layout.drawer_list_item, getResources()
						.getStringArray(R.array.menus));

		mDrawerList.setAdapter(adapter);

		// Setting item click listener for the listview mDrawerList
		mDrawerList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				// Getting an array of rivers
				String[] menuItems = getResources().getStringArray(
						R.array.menus);

				// Currently selected river
				mTitle = menuItems[position];
				switch (position) {
				case 0:
					getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, new BatteryInfoFragment()).commit();
					break;

				case 1:
					getSupportFragmentManager().beginTransaction()
							.replace(R.id.content_frame, new OptimizationFragment()).commit();
					break;

				case 2:
					getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, new ConsumptionFragment()).commit();
					break;

				case 3:
					getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, new About()).commit();
					break;
				default:
					break;
				}
				

				// Closing the drawer
				mDrawerLayout.closeDrawer(mDrawerList);

			}
		});

		
		
	}

	public void setActionBar() {
		ActionBar mActionBar = getActionBar();
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);

		LayoutInflater mInflater = LayoutInflater.from(this);
		View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);

		TextView tvAppName = (TextView) mCustomView
				.findViewById(R.id.tvAppName);
		tvAppName.setText("Droid Battery Booster");

		ImageButton ivSearch = (ImageButton) mCustomView
				.findViewById(R.id.ivSearch);
		ivSearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				// slide_me.toggleRightDrawer();
			}
		});

		ImageView ivdrawer = (ImageView) mCustomView
				.findViewById(R.id.ivdrawer);
		ivdrawer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				// slide_me.toggleLeftDrawer();
				if (flag) {
					mDrawerLayout.openDrawer(Gravity.LEFT);
					flag = false;
				} else {
					mDrawerLayout.closeDrawer(Gravity.LEFT);
					flag = true;
				}
			}
		});
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
	}

	protected String getUrl(int position) {
		switch (position) {
		case 0:
			/*getSupportFragmentManager().beginTransaction().replace(
					R.id.content_frame, new BatteryInfo());*/
		case 1:
			getSupportFragmentManager().beginTransaction().replace(
					R.id.content_frame, new About());
		case 2:
		case 3:

		default:
			return null;
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/** Called whenever we call invalidateOptionsMenu() */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// If the drawer is open, hide action items related to the content view
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);

		// menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) {
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 */

	
}

