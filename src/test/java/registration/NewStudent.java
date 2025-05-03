package registration;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class NewStudent {
    public NewStudent fillInFullName(String firstNameValue, String lastNameValue)
    {
        $("[placeholder='First Name']").setValue(firstNameValue);
        $("[placeholder='Last Name']").setValue(lastNameValue);
        return this;
    }
    public void fillUserEmail(String emailValue)
    {
        $("#userEmail").setValue(emailValue);
    }
    public void chooseGender(String genderValue)
    {
        $("#genterWrapper").$(byText(genderValue)).click(); //gender-radio-3
    }
    public String chooseBirthDay(String yearValue, String monthValue, String dayValue)
    {
        $("[id='dateOfBirthInput']").click();
        $(".react-datepicker__year-select").selectOption(yearValue);
        $(".react-datepicker__month-select").selectOption(monthValue);
        String day = ".react-datepicker__day--0"+ dayValue +":not(.react-datepicker__day--outside-month)"; //not используется для того чтобы не выбрать другой месяц
        $(day).click();
        return dayValue + " " + monthValue + "," + yearValue;
    }
    public void fillPhoneNumber(String numberValue)
    {
        $("[placeholder='Mobile Number']").setValue(numberValue);
    }
    public void chooseSubject(String subjectValue)
    {
        // заполнить поле subjects несколькими значениями
        $("[id='subjectsInput']").setValue(subjectValue).pressEnter();
    }
    public void chooseHobbies(String hobbyValue)
    {
        $("#hobbiesWrapper").$(byText(hobbyValue)).click();
    }
    public void uploadFile(File picture) throws IOException
    {
        $("#uploadPicture").uploadFile(picture);
    }
    public void fillAddress(String addressValue)
    {
        $("[id='currentAddress']").setValue(addressValue);//currentaddress
    }
    public void chooseStateCity(String stateValue, String cityValue)
    {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(stateValue)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(cityValue)).click();
    }
    public void approve()
    {
        $("button[id='submit']").click();
    }

}
