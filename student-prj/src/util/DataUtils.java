package util;

import java.time.LocalDate;
import java.util.Date;

public class DataUtils {
    public static boolean isDate(String str) {
        String regex = "^[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}$";
        boolean check = str.matches(regex);
        if (check) {
            try {
                LocalDate date =convertDate(str);
            } catch (Exception e) {
                return false;
            }
        }
        return check;

    }

    public static LocalDate convertDate(String str) {
        String[] parts = str.split("/");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            return LocalDate.of(year, month, day);
    }

    public static boolean isPhoneNumber(String str) {
        String regex = "^[\\d]{10}$";
        return str.matches(regex);
    }
}
