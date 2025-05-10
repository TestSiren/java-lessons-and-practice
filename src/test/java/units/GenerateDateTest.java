package units;

import generationData.GenerateDate;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

public class GenerateDateTest {

    @RepeatedTest(100)
    public void testGenerateValidDate() {
        // Генерируем месяц, год и день
        String month = GenerateDate.optionsMonth();
        String year = GenerateDate.optionsYear();
        String day = GenerateDate.optionsDay(month, year);

        // Проверка валидности даты
        assertTrue(GenerateDate.isValidDate(day, month, year),
                "Invalid date generated: " + day + " " + month + " " + year);
    }
}
