package AloneTests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class TrainingHover {

    @Test
    void successfulGitHubTest() {
        // 1. На главной странице GitHub выберите меню Solutions -> Enterprize с помощью команды hover для Solutions.
        // $("button:contains('Solutions')").hover(); // но это работает только с jQuery-поддержкой
        open("https://github.com");
        // Наводим мышку на "Solutions"
        $(byText("Solutions")).hover();
        // Ждём, пока появится выпадающее меню
        $(".HeaderMenu-dropdown").shouldBe(enabled);
        // Кликаем по пункту "Enterprize" — ищем по тексту в ссылке
        $("a[href='https://github.com/enterprise']").shouldBe(enabled).click();
        // 2. Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
        $("#hero-section-brand-heading").shouldBe(visible).shouldHave(text("The AI-powered"));

    }
}
