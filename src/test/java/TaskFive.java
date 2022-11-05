import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Napisz test sprawdzający przejście ze strony logowania do strony głównej.
public class TaskFive {
    @Test
    void checkLoggingToMainPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement emailInput = driver.findElement(By.id("user-name"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        passwordInput.sendKeys("secret_sauce");
        emailInput.sendKeys("standard_user");
        submitButton.click();
        Thread.sleep(2000);
        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        Assertions.assertTrue(shoppingCart.isDisplayed(), "This is not a main page");
        driver.quit();
    }
}

