package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
        @Test
                public void userShouldNavigateToLoginPageSuccessfully(){
        //click on the sing in link
            driver.findElement(By.partialLinkText("In")).click();
            //verify the text 'Welcome Back!'
            String expectedText = "Welcome Back!";
            WebElement actualTextElement = driver.findElement(By.xpath("//h2[@class='page__heading']"));
            String actualText = actualTextElement.getText();
            Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyTheErrorMessage() throws InterruptedException {
        //click on the 'sign in' link
        driver.findElement(By.partialLinkText("In")).click();
        //Enter Invalid username
        driver.findElement(By.id("user[email]")).sendKeys("abc@gmal.com");
        //Enter invalid password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("3456");
        //click on sign in button
        WebElement clickOn = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        clickOn.click();
Thread.sleep(9000);
        //Verify the error message 'Invalid email or password
        String expectedText = "Invalid email or password.";
       WebElement actualTextElement = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
       String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void tearDown(){
       closeBrowser();
    }


    }

