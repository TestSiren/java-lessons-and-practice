package AloneTests;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Condition;


public class SearchSoftAssertAndJUnit5 {
    @BeforeAll
    public static void setup() {
        // Устанавливаем размер окна браузера через Configuration
        Configuration.browser = "chrome"; // Указываем браузер
        Configuration.browserSize = "1200x800"; // Устанавливаем размер окна браузера (ширина x высота)
       // Configuration.holdBrowserOpen = true;// настройка для того чтобы не закрывать браузер после завершения теста
        // Открываем страницу Google
        open("https://github.com/");
    }

    @Test
void successfulGitHubTest() {
        //Открывает поисковую строку и вводим текст Selenide
    $("button[class*='header-search-button']").shouldBe(Condition.enabled).click();
    $("[name=query-builder-test]").setValue("Selenide").pressEnter();
        //дожидаемся когда элемент станет видимым и нажимаем на первое совпадение selenide/selenide
    $("a[href='/selenide/selenide']").shouldBe(Condition.visible).click();
        // переходим в раздел WIKI
    $("a[href='/selenide/selenide/wiki']").shouldBe(Condition.visible).click();
        // проверяем наличие текст Soft assertions, переходим по гиперссылке и проверяем, что есть junit5 блок
    $("li a.internal.present[href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(Condition.text("Soft assertions")).click();
    $("a[href='#3-using-junit5-extend-test-class']").shouldBe(Condition.enabled).scrollIntoView(true);
    }
}
