package registration;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PageOpener {
    public static final String BASE_URL = "https://demoqa.com";

    public static void openPracticeForm ()
    {
      //  String absoluteUrl = "/automation-practice-form"; // bad practice. Лишняя строчка
        Configuration.baseUrl = BASE_URL;
        open("/automation-practice-form"); // Лучше, потому что чище и понятнее.
        $("h1[class*='text-center']").shouldHave(text("Practice Form"));
    }
}
