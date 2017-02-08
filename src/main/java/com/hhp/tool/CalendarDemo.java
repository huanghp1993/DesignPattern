package com.hhp.tool;

import java.util.Calendar;

/**
 * 获取当前时间的小时
 * Created by huanghaopeng on 17/2/8.
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);

        System.out.print(hour);
    }
}
