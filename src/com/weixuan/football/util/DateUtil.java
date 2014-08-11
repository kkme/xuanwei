package com.weixuan.football.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * ���ڴ��?����
 * @author dylan_xu
 * @date Mar 11, 2012
 * @modified by
 * @modified date
 * @since JDK1.6
 */

public class DateUtil {


    private static final String DATEC_FORMAT = "MM月dd日";


    private static SimpleDateFormat sdf_datec_format = new SimpleDateFormat(DATEC_FORMAT);

    /***
     * 格式日期     MM月dd日
     * @param date
     * @return
     */
    public static String getChineseDate(Date date){
      try {
          return  sdf_datec_format.format(date);
      }catch (Exception e){
          return "";
      }
    }

}
