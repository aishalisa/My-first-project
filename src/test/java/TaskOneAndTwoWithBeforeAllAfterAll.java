import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TaskOneAndTwoWithBeforeAllAfterAll {
     WebDriver driver;

    @BeforeEach
     void shouldBeDoneBeforeEveryTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
     void shouldBeDoneAfterEveryTest() {
        driver.quit();
    }

    @Test
    void submitWithUserNameFieldEmpty(){
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        passwordInput.sendKeys("secret_sauce");
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement errorBox = driver.findElement(By.xpath("//h3[text()='Epic sadface: Username is required']"));
        Assertions.assertEquals("Epic sadface: Username is required", errorBox.getText(),
                "Error");
        passwordInput.clear();

    }
    @Test
    void submitWithPasswordFieldEmpty(){
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        userNameInput.sendKeys("standard_user");
        submitButton.submit();
        WebElement errorBox = driver.findElement(By.xpath("//h3[text()='Epic sadface: Password is required']"));
        Assertions.assertEquals("Epic sadface: Password is required", errorBox.getText(),
                "Error");
    }
}