import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TaskFour {

    //Napisz test sprawdzający przejście ze strony głównej do strony ”Kontakt”
    @Test
    void shouldGoFromMainPageToContacts(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement emailInput = driver.findElement(By.id("user-name"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        passwordInput.sendKeys("secret_sauce");
        emailInput.sendKeys("standard_user");
        submitButton.click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement aboutButton = driver.findElement(By.id("about_sidebar_link"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        aboutButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/header/div/nav/ul/li[1]/ul[2]/li[5]/div[1]/div/a")));
        WebElement contactButton = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[1]/ul[2]/li[5]/div[1]/div/a"));
        contactButton.click();
    }
}
