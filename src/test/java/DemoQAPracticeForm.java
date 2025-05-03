import org.junit.jupiter.api.Test;
import generationData.*;
import org.junit.jupiter.api.BeforeAll;
import registration.*;
import java.io.File;
import java.io.IOException;

public class DemoQAPracticeForm  {
    @BeforeAll
    public static void setUp() {
        Settings.configure();
        String Url = "/automation-practice-form";
        PageOpener.openPracticeForm(Url);

    }

    @Test
    void CreateNewUser() throws IOException {
        StudentData data = GenerateData.generate();
        NewStudent student = new NewStudent();
        student.fillInFullName(data.firstName, data.lastName);
        student.fillUserEmail(data.userEmail);
        student.chooseGender(data.userGender);
        student.fillPhoneNumber(data.userCellNumber);
        String expectedDate = student.chooseBirthDay(data.birthYear, data.birthMonth, data.birthDay);
        student.chooseSubject(data.subject);
        student.chooseHobbies(data.hobby);
        student.uploadFile(data.picture);
        student.fillAddress(data.address);
        student.chooseStateCity(data.state, data.city);
        student.approve();

        //что корректно заполнилась форма:
        CheckResultsTable resultsTable = new CheckResultsTable();
        resultsTable.TableWasCreating();// Проверка полей в таблице после отправки формы
        CheckResultsTable.TableCheckResults(data, expectedDate);

    }
}
