/* Copyright 2004 for General Secretariat of the Council of the European Union (GSC). */
/* This code belongs to the GSC.                                                      */
package com.hosp.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

/**
 * This class is generally used for date formating. There are 4 predefined types of date formats (defined as final static constants).
 */
public class FormatUtils {

    public static final String DATEPATTERN = "dd/MM/yyyy";
    public static final String TIMEPATTERN = "HH:mm";
    public static final String FULLDATEPATTERN = "dd/MM/yyyy HH:mm";
    /**
     * European date format without time
     */
    public static final int DD_MM_YYYY_NO_TIME = 1;
    /**
     * European date format with time
     */
    public static final int DD_MM_YYYY_TIME = 2;
    /**
     * American date format without time
     */
    public static final int MM_DD_YYYY_NO_TIME = 3;
    /**
     * American date format with time
     */
    public static final int MM_DD_YYYY_TIME = 4;
    /**
     * Constant ID for SUNDAY
     */
    public static final int SUNDAY = 1;
    /**
     * Constant ID for MONDAY
     */
    public static final int MONDAY = 2;
    /**
     * Constant ID for TUESDAY
     */
    public static final int TUESDAY = 3;
    /**
     * Constant ID for WEDNESDAY
     */
    public static final int WEDNESDAY = 4;
    /**
     * Constant ID for THURSDAY
     */
    public static final int THURSDAY = 5;
    /**
     * Constant ID for FRIDAY
     */
    public static final int FRIDAY = 6;
    /**
     * Constant ID for SATURDAY
     */
    public static final int SATURDAY = 7;

    /**
     * Defauls private constructor, this is a common pattern for every utility class.
     */
    private FormatUtils() {
        super();
    }

    public static String addOneDay(String date) {
        // Start date
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(date));
            c.add(Calendar.DATE, 1);  // number of days to add
            String retValue = sdf.format(c.getTime());
            return retValue;
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Date addOneDay(Date date) {
        // Start date
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, 1);  // number of days to add			
            return c.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date minusOneDay(Date date) {
        // Start date
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, -1);  // number of days to add			
            return c.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date shiftDatePerDay(Date date, int days) {
        // Start date
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, days);  // number of days to add			
            return c.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date shiftDatePerMinute(Date date, int minutes) {
        // Start date
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.MINUTE, minutes);  // number of days to add			
            return c.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date shiftDatePerHour(Date date, int hours) {
        // Start date
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.HOUR, hours);  // number of days to add			
            return c.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date shiftDatePerYear(Date date, int years) {
        // Start date
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.YEAR, years);  // number of days to add			
            return c.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String minusOneDay(String date) {
        // Start date
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(date));
            c.add(Calendar.DATE, -1);  // number of days to add
            String retValue = sdf.format(c.getTime());
            return retValue;
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getDayWeek() {
        Calendar calendar = Calendar.getInstance();
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        return weekday;
    }

    public static Date addTime(Date date, int days, int type) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(type, days);
        return cal.getTime();
    }

    public static int subtractDate(Date start, Date end) {
        GregorianCalendar gc1 = new GregorianCalendar();
        gc1.setTime(start);
        GregorianCalendar gc2 = new GregorianCalendar();
        gc2.setTime(end);

        int days1 = 0;
        int days2 = 0;
        int minYear = Math.min(gc1.get(Calendar.YEAR), gc2.get(Calendar.YEAR));

        GregorianCalendar gctmp = (GregorianCalendar) gc1.clone();
        for (int f = gctmp.get(Calendar.YEAR); f > minYear; f--) {
            days1 += gctmp.getActualMaximum(Calendar.DAY_OF_YEAR);
            gctmp.add(Calendar.YEAR, -1);
        }

        gctmp = (GregorianCalendar) gc2.clone();
        for (int f = gctmp.get(Calendar.YEAR); f > minYear; f--) {
            days2 += gctmp.getActualMaximum(Calendar.DAY_OF_YEAR);
            gctmp.add(Calendar.YEAR, -1);
        }

        days1 += gc1.get(Calendar.DAY_OF_YEAR) - 1;
        days2 += gc2.get(Calendar.DAY_OF_YEAR) - 1;

        return (days2 - days1);
    }

    public static String formatDate(java.util.Date date) {
        if (date != null) {
            DateFormat df = new SimpleDateFormat(DATEPATTERN);
            return df.format(date);
        } else {
            return "";
        }
    }

    public static String formatTimeStamp(Timestamp date) {
        if (date != null) {
            DateFormat df = new SimpleDateFormat(DATEPATTERN);
            return df.format(date);
        } else {
            return "";
        }
    }

    public static String formatDate(Date date, String patern) {
        if (date != null) {
            DateFormat df = new SimpleDateFormat(patern);
            return df.format(date);
        } else {
            return "";
        }
    }

    public static Date getDate(String date) {
        DateFormat df = new SimpleDateFormat(DATEPATTERN);
        try {
            return df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();

        }
    }

    public static Timestamp getTimestamp(String date) {
        DateFormat df = new SimpleDateFormat(DATEPATTERN);
        try {
            Date temp = df.parse(date);
            return new Timestamp(temp.getTime());
        } catch (ParseException e) {
            //e.printStackTrace();
            return new Timestamp(new Date().getTime());

        }
    }

    public static Timestamp formatDateToTimestamp(java.util.Date date) throws Exception {
        Timestamp timestamp = null;
        try {
            DateFormat df = new SimpleDateFormat(DATEPATTERN);
            String dateString = df.format(date);
            timestamp = new Timestamp(df.parse(dateString).getTime());
            return timestamp;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public static Timestamp formatDateToTimestamp(java.util.Date date, String pattern) {
        Timestamp timestamp = null;
        try {
            DateFormat df = new SimpleDateFormat(pattern);
            String dateString = df.format(date);
            timestamp = new Timestamp(df.parse(dateString).getTime());
            return timestamp;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Returns a string from the input timestamp in the designated format. Formats can be of the following types : <ul> <li> DD/MM/YYYY HH24:MI:SS <li>
     * DD/MM/YYYY <li> MM/DD/YYYY HH24:MI:SS <li> MM/DD/YYYY </ul?
     *

     *
     * @param timestamp is the epoc number to be used
     * @param format is the preferred format to be returned
     *
     * @return a String in the preferred format
     */
    public static String getFormat(long timestamp, int format) {
        java.util.Date modifiedDate = new java.util.Date(timestamp);
        return getFormatFromDate(modifiedDate, format);
    }

    /**
     * Return the hour in 24 basis (i.e. 0 - 23)
     *
     * @param date is the java.util.Date as input
     *
     * @return an integer value which represents the time in 24 basis
     */
    public static int getHourIn24Basis(java.util.Date date) {
        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(date);

        int offset = 0;

        if (gcal.get(Calendar.AM_PM) == 1) {
            offset = 12;
        }

        return gcal.get(Calendar.HOUR) + offset;
    }

    public static int getCurrentMinute(java.util.Date date) {
        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(date);
        int minute = gcal.get(Calendar.MINUTE);
        return minute;
    }

    /**
     * Returns the day of week for a specific date.
     *
     * @param date is the date of which the day of week is been seeked
     *
     * @return 1 sunday, 2 monday, ... 7 saturday
     */
    public static int getDayOfWeek(java.util.Date date) {
        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(date);
        return gcal.get(GregorianCalendar.DAY_OF_WEEK);
    }

    /**
     * Returns the day of month as an integer representation
     *
     * @param date the input date
     *
     * @return the integer representation of the day of month
     */
    public static int getDayOfMonth(java.util.Date date) {
        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(date);
        return gcal.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public static int getMonth(java.util.Date date) {
        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(date);
        return (gcal.get(Calendar.MONTH) + 1);
    }

    public static int getYear(java.util.Date date) {
        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(date);
        return gcal.get(Calendar.YEAR);
    }

    /**
     * Returns a String from the in the designated
     *
     * @param modifiedDate
     * @param format
     * @return
     */
    private static String getFormatFromDate(java.util.Date modifiedDate, int format) {
        String result = new String();

        GregorianCalendar lastModified = new GregorianCalendar();
        lastModified.setTime(modifiedDate);

        if (format == DD_MM_YYYY_TIME) {
            result = gregorianCalendar2OracleDateString(lastModified, true, false);
        } else if (format == DD_MM_YYYY_NO_TIME) {
            result = gregorianCalendar2OracleDateString(lastModified, true, true);
        } else if (format == MM_DD_YYYY_TIME) {
            result = gregorianCalendar2OracleDateString(lastModified, false, false);
        } else if (format == MM_DD_YYYY_NO_TIME) {
            result = gregorianCalendar2OracleDateString(lastModified, false, true);
        }

        return result;

    }

    /**
     * Converts a Gregorian calendar object into an "oracle like" date string DD/MM/YYYY HH24:MI:SS
     *
     * @param gcal the Gregorian calendar object
     * @param europeanFormat true for european format, false for US format
     * @param discardTime true for discarding the time or false for the oposite.
     *
     * @return the String representation of the Gregorian Calendar object (based on the specific parameters passed).
     */
    private static String gregorianCalendar2OracleDateString(java.util.GregorianCalendar gcal,
            boolean europeanFormat, boolean discardTime) {
        String retVal;
        int offset = 0;

        if (gcal.get(Calendar.AM_PM) == 1) {
            offset = 12;
        }

        if (!europeanFormat) {
            if (!discardTime) {
                retVal = pad(gcal.get(Calendar.MONTH) + 1, 2) + "/" + pad(gcal.get(Calendar.DATE), 2) + "/" + gcal.get(Calendar.YEAR) + " "
                        + pad(String.valueOf(gcal.get(Calendar.HOUR) + offset), 2) + ":" + pad(gcal.get(Calendar.MINUTE), 2) + ":" + pad(gcal.get(Calendar.SECOND), 2);
            } else {
                retVal = pad(gcal.get(Calendar.MONTH) + 1, 2) + "/" + pad(gcal.get(Calendar.DATE), 2) + "/" + gcal.get(Calendar.YEAR);
            }
        } else {
            if (!discardTime) {
                retVal = pad(gcal.get(Calendar.DATE), 2) + "/" + pad(gcal.get(Calendar.MONTH) + 1, 2) + "/" + gcal.get(Calendar.YEAR) + " "
                        + pad(String.valueOf(gcal.get(Calendar.HOUR) + offset), 2) + ":" + pad(gcal.get(Calendar.MINUTE), 2) + ":" + pad(gcal.get(Calendar.SECOND), 2);
            } else {
                retVal = pad(gcal.get(Calendar.DATE), 2) + "/" + pad(gcal.get(Calendar.MONTH) + 1, 2) + "/" + gcal.get(Calendar.YEAR);
            }
        }

        return (retVal);
    }

    /**
     * This method finds the date after or before the current date. According to the number (numOfWorkingDays) that we provide.
     *
     * The flag (isForward) finds the date after (true) or the date before (false) today
     *
     * The counted days are working days only. DAY_OF_WEEK - 1 --> SUNDAY DAY_OF_WEEK - 7 --> SATURDAY The previous two are ignored.
     *
     * @param numOfWorkingDays
     * @param isForward
     * @return
     */
    public static Date getWorking(int numOfWorkingDays, boolean isForward) {
        Calendar todayCal = new GregorianCalendar();
        Date today = new Date();
        todayCal.setTime(today);


        while (numOfWorkingDays > 0) {
            if (isForward) {
                todayCal.add(Calendar.DAY_OF_WEEK, 1);
            } else {
                todayCal.add(Calendar.DAY_OF_WEEK, -1);
            }


            int dayOfWeek = todayCal.get(Calendar.DAY_OF_WEEK);

            if ((dayOfWeek != 1) && (dayOfWeek != 7)) {
                numOfWorkingDays--;
            }
        }
        return todayCal.getTime();
    }

    /**
     * Pads a String with a specific padding (e.g. 3 -> 03)
     *
     * @param a the input value
     * @param thePad the padding to be used
     *
     * @return the padded value
     */
    public static String pad(String a, int thePad) {
        String help = new String();
        for (int i = 1; i <= thePad; i++) {
            help += "0";
        }
        return ((new DecimalFormat(help)).format(Long.parseLong(a)));
    }

    /**
     * Overloaded version of the above, (inputs are now integer values)
     *
     * @param a the input value
     * @param thePad the padding to be used
     *
     * @return the padded value
     */
    private static String pad(int a, int thePad) {
        String help = new String();
        for (int i = 1; i <= thePad; i++) {
            help += "0";
        }

        return ((new DecimalFormat(help)).format(a));
    }
}