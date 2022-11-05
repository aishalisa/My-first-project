import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

//Sprawdź, czy strona główna oraz strona logowania zawiera logo i product_sort_container

public class TaskThree {
    @Test
    void checkLogoAndSearchField() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement loginLogo = driver.findElement(By.className("login_logo"));
        Assertions.assertTrue(loginLogo.isDisplayed(), "Login logo is not displayed");
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement emailInput = driver.findElement(By.id("user-name"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        passwordInput.sendKeys("secret_sauce");
        emailInput.sendKeys("standard_user");
        submitButton.click();
        Select productSortContainer = new Select(driver.findElement(By.className("product_sort_container")));
        List<WebElement> productChoice = productSortContainer.getOptions();
        String productChoice1 = productChoice.get(1).getText();
        Assertions.assertEquals("Name (Z to A)", productChoice1, "There is no such option");
        driver.quit();
    }
}

