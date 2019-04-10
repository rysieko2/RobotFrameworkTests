import org.junit .*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

    public class registration_form {

        WebDriver driver;

        String nameId = "first-name";
        String lastnameId = "last-name";
        String male = "//label[1]";
        String female = "//label[2]";
        String inBeetwen = "//label[3]";
        String dateOfBirth = "dob";
        String address = "address";
        String email = "email";
        String password = "password";
        String company = "company";
        String role = "role";
        String expectation = "expectation";
        String readBooks = "/html/body/div/div/form/div[11]/div/div[1]/label/input";
        String TakeOnlineCourses = "";
        String contributeToOpensourceProjects = "";
        String joinTechCons = "/html/body/div/div/form/div[11]/div/div[4]/label";
        String readTechBlogs = "";
        String viaDiscoveryAndExperiment = "";
        String comment = "comment";
        String submitMsg = "submit-msg";
        String submitButtonId = "submit";

        String firstNameErrorId = "first-name-error";
        String lastNameErrorId = "last-name-error";
        String maleErrorId = "gender-error";
        String dateOfBirthErrorId = "dob-error";
        String addressErrorId = "address-error";
        String emailErrorId = "email-error";
        String passwordErrorId = "password-error";
        String companyErrorId = "company-error";


        @Before
        public void setUp() {

            System.setProperty("webdriver.gecko.driver", "rsc/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

      //  @Ignore
        @Test
        public void testValidUserRegistration() {
            WebElement nameField = driver.findElement(By.id(nameId));   //do zmiennej 'nameField' wpisuję wyszukany element przez id: 'nameId'
            if (nameField.isDisplayed()) {                              //jeżeli element 'nameField' jest 'podany' wykona się instrukcja IF
                nameField.click();                                      //kliknięcie w element
                nameField.clear();                                      //wyczyszczenie elementu
                nameField.sendKeys("Zbigniew");          //wpisanie tekstu do elementu
                System.out.println("I write to the field with id:'" + nameId + "' value: Zbigniew");     //wyświetlenie napisu na ekranie
            }else {
                System.out.println("The field with id:'" + nameId + "' doesn't exist");
                Assert.fail();                                                                          //Asercja przerywająca test z wynikiem negatywnym

            }

            WebElement lastNameField = driver.findElement(By.id(lastnameId));
            lastNameField.click();
            lastNameField.clear();
            lastNameField.sendKeys("Kowalski");

            WebElement maleField = driver.findElement(By.xpath(female));
            maleField.click();

            WebElement dateOfBirthField = driver.findElement(By.id(dateOfBirth));
            dateOfBirthField.click();
            dateOfBirthField.clear();
            dateOfBirthField.sendKeys("07/27/1983");

            WebElement addressField = driver.findElement(By.id(address));
            addressField.click();
            addressField.clear();
            addressField.sendKeys("Świebodzka");

            WebElement emailField = driver.findElement(By.id(email));
            emailField.click();
            emailField.clear();
            emailField.sendKeys("karol@gmail.com");

            WebElement passwordField = driver.findElement(By.id(password));
            passwordField.click();
            passwordField.clear();
            passwordField.sendKeys("123!@");

            WebElement companyField = driver.findElement(By.id(company));
            companyField.click();
            companyField.clear();
            companyField.sendKeys("CodersLab");

            Select roleFiled = new Select(driver.findElement(By.id(role)));
            //     roleFiled.deselectAll();
            roleFiled.selectByVisibleText("Manager");

            Select expectationFiled = new Select(driver.findElement(By.id(expectation)));
            expectationFiled.selectByVisibleText("High salary");

            WebElement readBooksField = driver.findElement(By.xpath(readBooks));
            readBooksField.click();

            WebElement joinTechConsField = driver.findElement(By.xpath(joinTechCons));
            joinTechConsField.click();

            WebElement commentField = driver.findElement(By.id(comment));
            commentField.click();
            commentField.clear();
            commentField.sendKeys("I gitara!!!");

            WebElement submitField = driver.findElement(By.id(submitButtonId));
            submitField.click();

            WebElement link = driver.findElement(By.id(submitMsg));
            String textLinku = link.getText();
            String oczekiwanyTekst = "Successfully submitted!";
            System.out.println("The text of the link: " + textLinku);
            assertTrue(textLinku.equals(oczekiwanyTekst));
            System.out.println("Registration was successful - OK!!!");
        }

        @Test
        public void errorHandling() {
            WebElement submitButton = driver.findElement(By.id(submitButtonId));            //pobranie do zmiennej przycisku zatwierdzenia formularza

            driver.findElement(By.id(nameId)).clear();                                      //wyczyszczenie znalezionego elementu przez id
            submitButton.click();                                                           //kliknięcie na przycist zatwierdzenia formularza
            WebElement firstNameErrorIdField = driver.findElement(By.id(firstNameErrorId)); //wpisanie do zmiennej znalezionego elementu przez id
            assertTrue(firstNameErrorIdField.isDisplayed());                                //jeżeli element jest 'podany' asercja zwraca 'true'
            System.out.println("The field: '" + nameId + "' doesn't accept empty values correctly - OK!!!");    //wyświetlenie napisu





            driver.findElement(By.id(lastnameId)).clear();
            driver.findElement(By.id(dateOfBirth)).clear();
            driver.findElement(By.id(address)).clear();
            driver.findElement(By.id(email)).clear();
            driver.findElement(By.id(password)).clear();
            driver.findElement(By.id(company)).clear();


            submitButton.click();



            WebElement lastNameErrorIdField = driver.findElement(By.id(lastNameErrorId));
            assertTrue(lastNameErrorIdField.isDisplayed());

            WebElement dateOfBirthErrorIdField = driver.findElement(By.id(dateOfBirthErrorId));
            assertTrue(dateOfBirthErrorIdField.isDisplayed());

            WebElement addressErrorIdField = driver.findElement(By.id(addressErrorId));
            assertTrue(addressErrorIdField.isDisplayed());

            WebElement emailErrorIdField = driver.findElement(By.id(emailErrorId));
            assertTrue(emailErrorIdField.isDisplayed());

            WebElement passwordErrorIdField = driver.findElement(By.id(passwordErrorId));
            assertTrue(passwordErrorIdField.isDisplayed());

            WebElement companyErrorIdField = driver.findElement(By.id(companyErrorId));
            assertTrue(companyErrorIdField.isDisplayed());

        }


        @After
        public void tearDown() {
            //   driver.quit();
        }
    }
