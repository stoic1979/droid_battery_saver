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

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.preference.ListPreference;
import android.util.AttributeSet;

import java.text.DateFormatSymbols;
import java.util.Calendar;

import com.ksk.droidbatterybooster.provider.TimeSchedule;


/**
 * @author Luan Vu (hlvu.cybersoft@gmail.com)
 *
 */
public class RepeatPreference extends ListPreference {

    // Initial value that can be set with the values saved in the database.
    private TimeSchedule.DaysOfWeek mDaysOfWeek = new TimeSchedule.DaysOfWeek(0);
    // New value that will be set if a positive result comes back from the
    // dialog.
    private TimeSchedule.DaysOfWeek mNewDaysOfWeek = new TimeSchedule.DaysOfWeek(0);

    public RepeatPreference(Context context, AttributeSet attrs) {
        super(context, attrs);

        String[] weekdays = new DateFormatSymbols().getWeekdays();
        String[] values = new String[] {
            weekdays[Calendar.MONDAY],
            weekdays[Calendar.TUESDAY],
            weekdays[Calendar.WEDNESDAY],
            weekdays[Calendar.THURSDAY],
            weekdays[Calendar.FRIDAY],
            weekdays[Calendar.SATURDAY],
            weekdays[Calendar.SUNDAY],
        };
        setEntries(values);
        setEntryValues(values);
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        if (positiveResult) {
            mDaysOfWeek.set(mNewDaysOfWeek);
            setSummary(mDaysOfWeek.toString(getContext(), true));
            callChangeListener(mDaysOfWeek);
        }
    }

    @Override
    protected void onPrepareDialogBuilder(Builder builder) {
        CharSequence[] entries = getEntries();
        // not used ===>>
        //CharSequence[] entryValues = getEntryValues();

        builder.setMultiChoiceItems(
                entries, mDaysOfWeek.getBooleanArray(),
                new DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialog, int which,
                            boolean isChecked) {
                        mNewDaysOfWeek.set(which, isChecked);
                    }
                });
    }

    public void setDaysOfWeek(TimeSchedule.DaysOfWeek dow) {
        mDaysOfWeek.set(dow);
        mNewDaysOfWeek.set(dow);
        setSummary(dow.toString(getContext(), true));
    }

    public TimeSchedule.DaysOfWeek getDaysOfWeek() {
        return mDaysOfWeek;
    }
}
