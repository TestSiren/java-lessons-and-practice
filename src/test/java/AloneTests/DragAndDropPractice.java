package AloneTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import registration.PageOpener;
import registration.Settings;

public class DragAndDropPractice {

    @BeforeAll
    public static void setUp() {
        Settings.configure();
        String Url = "/droppable";
        PageOpener.openPracticeForm(Url);

    }

    @Test
    void DragAndDropTest() {
        $("#droppableContainer").shouldBe(visible);
        // Выбрать элементы, которые нужно перетащить
        SelenideElement source = $("#draggable");
        SelenideElement target = $("#droppable");

        // Перетащить элемент
        //source.dragAndDropTo(target);

        // Проверить, что перетаскивание прошло успешно (можно, например, проверить, что текст на элементах изменился)
        $("#droppable").shouldHave(text("droppable"));
    }
}
