package com.redhammerstudios.quickevent;

//Special date class that allows for date rangese(5pm-10pm), all day events, etc.  The first field, ID, is used to differentiate between dates..  All objects are stored in database
//Will return parseable string date, to put into SQL table, methods stringToDate, dateToString
//stringformat    id-month

import android.text.TextUtils;
import android.util.Log;

public class QEDate {

    public int id;
    public int month;
    public int day;
    public int year;
    //if 0 then assume no start hour
    public int startHour;
    //if 0, then assume no ending hour
    public int endHour;

    public QEDate(int id, int day, int month, int year, int startHour, int endHour) {
        this.id = id;
        this.day = day;
        this.month = month;
        this.year = year;
        this.startHour = startHour;
        this.endHour = endHour;
    }
//String format currently is id--day--month--year--startHour--endHour
    public String dateToString(QEDate qedate) {
        try {
            String divider = "--";
            StringBuilder sb = new StringBuilder();
            sb.append(qedate.getId());
            sb.append(divider);
            sb.append(qedate.getDay());
            sb.append(divider);
            sb.append(qedate.getMonth());
            sb.append(divider);
            sb.append(qedate.getYear());
            sb.append(divider);
            sb.append(qedate.getStartHour());
            sb.append(divider);
            sb.append(qedate.getEndHour());
            String s = sb.toString();
            return s;
        }
        catch (Exception e){
            return "0";
        }
    }

    public QEDate stringToDate(String qedatestring){
        try {
            String[] splitStrings = qedatestring.split("--");
            int[] intValues = null;
            for (int i = 0; i < splitStrings.length; i++) {
                intValues[i] = Integer.parseInt(splitStrings[i]);
            }
            QEDate qedate = new QEDate(intValues[0],intValues[1],intValues[2],intValues[3],intValues[4],intValues[5]);
            return qedate;
        }
        catch (Exception e){
            Log.d("exception_stod",e.getMessage());
            return null;
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }
}
