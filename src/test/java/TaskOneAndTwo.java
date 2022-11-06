import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Napisz test, który zweryfikuje działanie aplikacji, gdy przy próbie logowania nie podano loginu.
//Napisz test, który zweryfikuje działanie aplikacji, gdy przy próbie logowania nie podano hasła.
public class TaskOneAndTwo {
    @Test
    void submitWithUserNameFieldEmpty(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        passwordInput.sendKeys("secret_sauce");
        submitButton.click();
        WebElement errorBox = driver.findElement(By.cssSelector(".error-message-container"));
        Assertions.assertEquals("Epic sadface: Username is required", errorBox.getText(),"Username is required");
        driver.quit();
    }
    @Test
    void submitWithPasswordFieldEmpty(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        userNameInput.sendKeys("problem_user");
        submitButton.submit();
        WebElement errorBox = driver.findElement(By.cssSelector(".error-message-container"));
        Assertions.assertEquals("Epic sadface: Password is required", errorBox.getText(),
                "Password is required");
        driver.quit();
    }

}
