package thred.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程安全的SimpleDateFormat
 *
 * @author Java男朋友
 * @date 2022-04-04 20:49
 */
public class SafeSimpleDateFormat {

    public static ThreadLocal<SimpleDateFormat> f = ThreadLocal.withInitial(()-> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static void main(String[] args) {
        while (true) {
            new Thread(() -> {
                String dateStr = f.get().format(new Date());
                try {
                    Date parseDate = f.get().parse(dateStr);
                    String dateStrCheck = f.get().format(parseDate);
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

