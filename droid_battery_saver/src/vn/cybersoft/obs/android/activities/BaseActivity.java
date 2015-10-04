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

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.MenuItem;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.ksk.droidbatterybooster.R;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseActivity extends SlidingFragmentActivity {
	private int mTitleRes;
	protected ListFragment mFrag;
	private boolean flag = true;
	

	public BaseActivity(int titleRes) {
		mTitleRes = titleRes;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setTitle(mTitleRes);
		
		setContentView(R.layout.blank_layout); 
		setBehindContentView(R.layout.blank_layout);
		
	//	View homeIcon = findViewById(android.R.id.home);
	//	((View) homeIcon.getParent()).setVisibility(View.GONE);
//		

		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setBehindWidth(500);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		setActionBar();
		
		ActionBar actionBar = getSupportActionBar();
		 actionBar.setDisplayHomeAsUpEnabled(false);
		//actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_HOME);
		actionBar.show();
		
		

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				toggle();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void setActionBar() {
		ActionBar mActionBar = getSupportActionBar();
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
					//mDrawerLayout.openDrawer(Gravity.LEFT);
					//sm.showMenu();
					getSlidingMenu().showMenu();
					flag = false;
				} else {
					//mDrawerLayout.closeDrawer(Gravity.LEFT);
					if(getSlidingMenu().isMenuShowing()){
						getSlidingMenu().showContent(true);
						
					}
					flag = true;
				}
			}
		});
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
	}
}
