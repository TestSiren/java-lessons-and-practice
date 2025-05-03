package generationData;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import com.github.javafaker.Faker;


public class GenerateData{
        static Faker faker = new Faker();

        public static StudentData generate() throws IOException {
            StudentData data = new StudentData();
            data.firstName = faker.name().firstName();
            data.lastName = faker.name().lastName();
            data.userEmail = faker.internet().emailAddress();
            data.userGender = getRandomValue("Male", "Female", "Other");
            data.userCellNumber = String.valueOf(faker.number().numberBetween(9151111111L, 9269999999L));
            data.hobby = getRandomValue("Sports", "Reading", "Music");
            data.subject = getRandomValue("Math", "Chemistry", "Physics", "Computer Science", "English", "History");
            data.address = faker.address().fullAddress();
            data.pictureFileName = String.valueOf(faker.name());
            data.picture = generatePngFile(data.pictureFileName); // ← имя класса
            data.state = getRandomValue("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
            data.city = getCity(data.state);
            data.birthDay = GenerateDate.optionsDay();
            data.birthMonth = GenerateDate.optionsMonth();
            data.birthYear = GenerateDate.optionsYear();
            return data;
        }

        private static String getRandomValue(String... initialValues) {
            return faker.options().option(initialValues);
        }

        private static String getCity(String state) {
            switch (state) {
                case "NCR": return getRandomValue("Delhi", "Gurgaon", "Noida");
                case "Uttar Pradesh": return getRandomValue("Agra", "Lucknow", "Merrut");
                case "Haryana": return getRandomValue("Karnal", "Panipat");
                case "Rajasthan": return getRandomValue("Jaipur", "Jaiselmer");
                default: return "Unknown";
            }
        }
        public static File generatePngFile(String fileName) throws IOException {
            int width = 200;
            int height = 200;
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            Graphics2D graphics = image.createGraphics();
            graphics.setPaint(new Color(100, 150, 200));
            graphics.fillRect(0, 0, width, height);
            graphics.setPaint(Color.WHITE);
            graphics.setFont(new Font("Arial", Font.BOLD, 20));
            graphics.drawString("Test Img", 40, 100);
            graphics.dispose();

            File outputFile = new File("src/test/resources/" + fileName + ".png");
            ImageIO.write(image, "png", outputFile);
            return outputFile;
        }
    }

