package AloneTests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;

public class DragAndDrop {
    @Test
    void DragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("[href='http://elementalselenium.com/']").shouldBe(visible);
        // Выбрать элементы, которые нужно перетащить
        SelenideElement source = $("#column-a");
        SelenideElement target = $("#column-b");

        // Перетащить элемент
        //source.dragAndDropTo(target);

        // Проверить, что перетаскивание прошло успешно (можно, например, проверить, что текст на элементах изменился)
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
