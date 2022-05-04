package thred.threadlocal;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程不安全的 SimpleDateFormat
 * 多个线程会同时调用calender.setTime方法，导致time被别的线程修改，因此线程是不安全的
 *
 * @author Java男朋友
 * @date 2022-04-04 17:46
 */
public class UnSafeSimpleDateFormat {

    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        while (true) {
            new Thread(() -> {
                String dateStr = f.format(new Date());
                try {
                    Date parseDate = f.parse(dateStr);
                    String dateStrCheck = f.format(parseDate);
                    boolean equals = dateStr.equals(dateStrCheck);
                    if (!equals) {
                        System.out.println(equals + " " + dateStr + " " + dateStrCheck)
                        ;
                    } else {
                        System.out.println(equals);
                    }
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
            }).start();

        }
    }
}
