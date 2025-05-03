package registration;

import generationData.StudentData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultsTable {
    public Object TableWasCreating() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public static void TableCheckResults(StudentData data, String expectedDate) {
        $("tbody").$$("tr").findBy(text("Student Name"))
                .$("td", 1).shouldHave(text(data.firstName + " " + data.lastName));
        $("tbody").$$("tr").findBy(text("Student Email"))
                .$("td", 1).shouldHave(text(data.userEmail));
        $("tbody").$$("tr").findBy(text("Gender"))
                .$("td", 1).shouldHave(text(data.userGender));
        $("tbody").$$("tr").findBy(text("Mobile"))
                .$("td", 1).shouldHave(text(data.userCellNumber));
        $("tbody").$$("tr").findBy(text("Date of Birth"))
                .$("td", 1).shouldHave(text(expectedDate));
        $("tbody").$$("tr").findBy(text("Subjects"))
                .$("td", 1).shouldHave(text(data.subject));
        $("tbody").$$("tr").findBy(text("Hobbies"))
                .$("td", 1).shouldHave(text(data.hobby));
        $("tbody").$$("tr").findBy(text("Picture"))
                .$("td", 1).shouldHave(text(data.pictureFileName));
        $("tbody").$$("tr").findBy(text("Address"))
                .$("td", 1).shouldHave(text(data.address));
        $("tbody").$$("tr").findBy(text("State and City"))
                .$("td", 1).shouldHave(text(data.state + " " + data.city));
    }
}
