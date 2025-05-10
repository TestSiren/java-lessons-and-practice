package tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import generationData.*;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import registration.*;
import java.io.IOException;
import static io.qameta.allure.Allure.step;

public class DemoQAPracticeForm {
    public static final String Url = "/automation-practice-form";
    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем страницу" + Url, () -> {
            Settings.configure();
            PageOpener.openPracticeForm(Url);
        });
    }
    @Attachment(value = "Скриншот по завершении теста", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
    @Test
    void CreateNewUser() throws IOException {
        StudentData data = GenerateData.generate();
        CreateNewStudent student = new CreateNewStudent();

        step("Заполняем Имя и Фамилию студента", () -> {
            student.fillInFullName(data.firstName, data.lastName);
        });
        step("Заполняем e-mail студента", () -> {
            student.fillUserEmail(data.userEmail);
        });
        step("Заполняем пол студента", () -> {
            student.chooseGender(data.userGender);
        });
        step("Заполняем ТЕЛЕФОН студента", () -> {
            student.fillPhoneNumber(data.userCellNumber);
        });

        String expectedDate = step("Заполняем Дату рождения студента", () -> {
            return student.chooseBirthDay(data.birthYear, data.birthMonth, data.birthDay);
        });

        step("Заполняем Предметы для студента", () -> {
            student.chooseSubject(data.subject);
        });
        step("Заполняем Хобби студента", () -> {
            student.chooseHobbies(data.hobby);
        });

        step("Заполняем фотографию студента", () -> {
            try {
                student.uploadFile(data.picture);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        step("Заполняем адрес студента", () -> {
            student.fillAddress(data.address);
        });
        step("Заполняем Государство и Город студента", () -> {
            student.chooseStateCity(data.state, data.city);
        });
        step("Подтверждаем заполнение формы", () -> {
            student.approve();
        });

        step("Проверка что форма заполнена согласно введенным данным на форме", () -> {
            CheckResultsTable resultsTable = new CheckResultsTable();
            resultsTable.TableWasCreating();
            CheckResultsTable.TableCheckResults(data, expectedDate);
            attachScreenshot();

        });
    }
}
