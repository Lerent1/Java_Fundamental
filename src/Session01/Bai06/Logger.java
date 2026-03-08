package Session01.Bai06;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Logger {
    public static void logError(String message) {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = LocalDateTime.now().format(dt);
        System.out.println("[ERROR] " + time + " - " + message);
    }
}
