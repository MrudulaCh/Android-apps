package com.codepath.todolist;



import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Pragiti on 2/9/2017.
 */

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    int newYear,newMonth,newDay;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
        newYear = selectedYear;
        newMonth = selectedMonth;
        newDay = selectedDay;
        onPopulateSet(selectedYear, selectedMonth + 1, selectedDay);
    }

    private void onPopulateSet(int year, int i, int dayOfMonth) {
        TextView txtVw = (TextView) getActivity().findViewById(R.id.displayDate);//register_et_dob:-id name of the edit text
        //et_setDate.setText(dayOfMonth + "/" + i + "/" + year);
        txtVw.setText(dayOfMonth + "/" + i + "/" + year);
        System.out.println("enetring on populate Set");

    }

}