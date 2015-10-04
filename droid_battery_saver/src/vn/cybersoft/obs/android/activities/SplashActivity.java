package vn.cybersoft.obs.android.activities;

import com.actionbarsherlock.app.SherlockActivity;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.ksk.droidbatterybooster.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;

public class SplashActivity extends SherlockActivity {
	
	//MediaPlayer mp= null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		
	//	mp = MediaPlayer.create(getBaseContext(), R.raw.spl);
	//	mp.start();
		
		//splash time out starts.......................
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				finish();
				Intent intent = new Intent(SplashActivity.this, MainActivity.class);
				SplashActivity.this.startActivity(intent);   
				finish();
			}
		}, 2000);
	
	}
}
		
		