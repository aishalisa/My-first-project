import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TaskEight {
//Add a product to shopping cart, enter it and check whether it was added.
    @Test
    void addProductToCart(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement userNameInput= driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        userNameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.submit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement slider = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        Actions builder = new Actions(driver);
        builder.click(slider).build().perform();
        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        builder.moveToElement(shoppingCart).click(shoppingCart).build().perform();
        WebElement cartQuantity = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        Assertions.assertEquals("1", cartQuantity.getText(), "There must be 1 item in the chopping cart");
        driver.quit();
    }
}
