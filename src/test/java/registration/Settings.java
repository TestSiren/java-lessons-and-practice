package registration;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Settings {
    public static void configure() {
        Configuration.browser = "chrome"; // Указываем браузер
        Configuration.browserSize = "1920x1080"; // Устанавливаем размер окна браузера (ширина x высота)
        Configuration.holdBrowserOpen = true;// настройка для того чтобы не закрывать браузер после завершения теста
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");

        Configuration.browserCapabilities = options;
        Configuration.timeout = 10000; // ожидание элементов
        Configuration.pageLoadTimeout = 60000; // ожидание загрузки страницы
    }
}
