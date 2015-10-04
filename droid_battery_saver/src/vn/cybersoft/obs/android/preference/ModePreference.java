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
package vn.cybersoft.obs.android.preference;


import java.util.List;

import com.ksk.droidbatterybooster.R;
import com.ksk.droidbatterybooster.provider.OptimalMode;

import vn.cybersoft.obs.android.utilities.Utils;
import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;

/**
 * @author Luan Vu (hlvu.cybersoft@gmail.com)
 *
 */
public class ModePreference extends ListPreference {
	//private int mModeId = -1;
	
    public ModePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        String[] entries = null; 
        String[] entryValues = null;
        
        List<OptimalMode> modes = OptimalMode.getModes(context.getContentResolver(), null);
        
        int size = modes.size();
        
		entries = new String[size];
		entryValues = new String[size];
		
		for (int i = 0; i < size; i++) {
			OptimalMode optimalMode = modes.get(i);
			entries[i] = Utils.getString(getContext(), optimalMode.name, R.string.class);
			entryValues[i] = String.valueOf(optimalMode.id);
		}
        
/*        try {
			c = OBS.getInstance().getModeDbAdapter().fetchAllMode();
			c.moveToFirst();
			int count = c.getCount();
			
			entries = new String[count];
			entryValues = new String[count];
	        for (int i = 0; i < count; i++) {
	        	boolean canEdit = Boolean.parseBoolean(c.getString(c.getColumnIndex(ModeDbAdapter.CAN_EDIT)));
	        	if (!canEdit) {
					int resId = ReflectionUtils.getResourceId(c.getString(c.getColumnIndex(ModeDbAdapter.NAME)), R.string.class);
					entries[i] = resId != -1 ? context.getString(resId) : c.getString(c.getColumnIndex(ModeDbAdapter.NAME));
				} else {
					entries[i] = c.getString(c.getColumnIndex(ModeDbAdapter.NAME));
				}
	        	entryValues[i] = String.valueOf(c.getInt(c.getColumnIndex(ModeDbAdapter._ID))) ;
	        	c.moveToNext();
			}
		} finally {
			if (c != null) {
				c.close();
			}
		}*/
        
        setEntries(entries);
        setEntryValues(entryValues);
    }
    
    @Override
    protected void onDialogClosed(boolean positiveResult) {
    	super.onDialogClosed(positiveResult);
    	setSummary(getEntry());
    }
    
    public int getModeId() {
    	return getValue() != null ? Integer.valueOf(getValue()) : -1;
    }
    
    public void setModeId(long modeId) {
    	setValue(String.valueOf(modeId)); 
    	setSummary(getEntry()); 
    }
    
/*    @Override
    protected void onPrepareDialogBuilder(Builder builder) {
    	CharSequence[] entries = getEntries();
        builder.setSingleChoiceItems(entries, mModeId, 
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    	mModeId = which;
                    	ModePreference.this.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                        dialog.dismiss();
                    }
        });
        
        
         * The typical interaction for list-based dialogs is to have
         * click-on-an-item dismiss the dialog instead of the user having to
         * press 'Ok'.
         
        builder.setPositiveButton(null, null);
    }*/
    
}
