package thred.threadlocal;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * 测下
 * @author yechaoa
 * @date 2023-05-30 11:18
 */
public class UnSafeSimpleDateFormatTest {

    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        long lockTimeMs = TimeUnit.MINUTES.toMillis(5);
        String repeatSign = "aaa";
        String setLockValue = (currentTimeMillis + lockTimeMs) + "|" + repeatSign;
        System.out.println(setLockValue);
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");  // 替换为您所需的时区

        Instant instant = Instant.ofEpochMilli(1685413260440L);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, zoneId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formattedDateTime = dateTime.format(formatter);

        System.out.println("Timestamp: " + currentTimeMillis + lockTimeMs);
        System.out.println("Formatted DateTime: " + formattedDateTime);
    }
}