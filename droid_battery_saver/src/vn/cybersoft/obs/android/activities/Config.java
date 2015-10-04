package vn.cybersoft.obs.android.activities;

import com.revmob.RevMob;
import android.app.Activity;

public class Config {

public static final int MAX_OKANE_CLICK_LIMIT = 9;
	
	public static int clickCount = 0;
	
	public static void OKANE(Activity activity, RevMob revmob) {
    	clickCount++;
    	if(clickCount % MAX_OKANE_CLICK_LIMIT == 0) {
    		revmob.showFullscreen(activity);
    		Config.clickCount=0;
    	}
    }
	}