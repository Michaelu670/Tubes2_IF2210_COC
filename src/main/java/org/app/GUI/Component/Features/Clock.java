package org.app.GUI.Component.Features;

import javax.swing.*;
import java.text.*;
import java.util.*;
public class Clock extends JLabel implements Runnable{
    Thread thread;
//    JLabel dayLabel;
//    JLabel timeLabel;

    public Clock(){
        thread = new Thread(this);
        thread.start();

//        timeLabel = new JLabel();
//        dayLabel = new JLabel();
    }

    public void run() {
        try {
            while (true) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                int dayName = cal.get(Calendar.DAY_OF_WEEK);
                int hours = cal.get(Calendar.HOUR_OF_DAY);
                int minutes = cal.get(Calendar.MINUTE);
                int seconds = cal.get(Calendar.SECOND);

                String dayNameString = new DateFormatSymbols().getWeekdays()[dayName];
                String monthString = new DateFormatSymbols().getMonths()[month];
                String dayString = String.format("%s, %d %s %d ", dayNameString, day, monthString, year);
                String timeString = String.format("%d:%d:%d", hours, minutes, seconds);
//                dayLabel.setText(dayString);
//                timeLabel.setText(timeString);
                this.setText(dayString + timeString);

                thread.sleep(1000);  // interval given in milliseconds
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
