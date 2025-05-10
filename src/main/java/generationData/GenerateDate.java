package generationData;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateDate {
    public static String optionsMonth() {
        List<String> months = Arrays.asList ("January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October",
                "November", "December");
        int randomIndex = ThreadLocalRandom.current().nextInt(months.size());
        String randomValue = months.get(randomIndex);
        return(randomValue);
    }
    public static String optionsYear() {
        String Year = String.valueOf(ThreadLocalRandom.current().nextInt(1970, 2010));
        return Year;
    }
    public static String optionsDay(String month, String year) {
        int maxDay;
        int Year = Integer.parseInt(year);
        switch (month) {
            case "January":
            case "March":
            case "May":
            case "July":
            case "August":
            case "October":
            case "December":
                maxDay = 31;
                break;
            case "April":
            case "June":
            case "September":
            case "November":
                maxDay = 30;
                break;
            case "February":
                maxDay = (Year % 4 == 0 && (Year % 100 != 0 || Year % 400 == 0)) ? 29 : 28;
                break;
            default:
                maxDay = 31;
        }

        int day = ThreadLocalRandom.current().nextInt(1, maxDay + 1);
        return String.format("%02d", day);
    }

    public static boolean isValidDate(String day, String month, String year) {
        try {
            Month monthEnum = Month.valueOf(month.toUpperCase(Locale.ENGLISH));
            int dayInt = Integer.parseInt(day);
            LocalDate.of(Integer.parseInt(year), monthEnum, dayInt); // Попробуем создать дату
            return true;  // Если не выбросилось исключение, то дата валидна
        } catch (Exception e) {
            return false;  // Если выбросилось исключение, то дата невалидна
        }
    }
}
