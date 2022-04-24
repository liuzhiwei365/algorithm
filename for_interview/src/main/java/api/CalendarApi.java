package api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarApi {
    public static void main(String[] args) {


        testCalendar();
    }


    public static void testCalendar(){
        Calendar  cal = Calendar.getInstance();
        /** 月份从0开始, 0表示1月，2表示3月，等  */
        cal.set(1993,3-1,23);
        /**月份向前移动一个月*/
        cal.add(Calendar.MONTH,-1);
        /** 设置成为该月份的最后一天 */
        cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        Date time = cal.getTime();
        System.out.println(time);

        String yyyyMMdd = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
        System.out.println(yyyyMMdd);


    }
}
