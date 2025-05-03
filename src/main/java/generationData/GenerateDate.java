package generationData;

import java.util.Arrays;
import java.util.List;
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
        public static String optionsDay() {
            int Day = ThreadLocalRandom.current().nextInt(1, 32);  // Генерация случайного дня
            return String.format("%02d", Day);
        }
        public static String optionsYear() {
            String Year = String.valueOf(ThreadLocalRandom.current().nextInt(1970, 2010));
            return Year;
        }
    }