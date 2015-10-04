/*
 * Copyright (C) 2014 IUH �yber$oft Team
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

package vn.cybersoft.obs.android.receivers;

import java.util.Calendar;

import com.ksk.droidbatterybooster.provider.BatteryTrace;

import vn.cybersoft.obs.android.utilities.Log;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @author Luan Vu (hlvu.cybersoft@gmail.com)
 *
 */
public class BatteryTraceReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		Log.v("Tracing at: " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE)); 
		
        Intent i = new Intent(BatteryTrace.TRACE_SERVICE_ACTION);
        context.startService(i);
	}

}
