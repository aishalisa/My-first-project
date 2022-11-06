import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

////Napisz test, który dodaje produkt do koszyka, a następnie usuwa go. Zweryfikuj, czy usunięcie powiodło
////się.
public class TaskSeven {
    @Test
    void addAndRemoveProduct(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement emailInput = driver.findElement(By.id("user-name"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        passwordInput.sendKeys("secret_sauce");
        emailInput.sendKeys("standard_user");
        submitButton.submit();
        WebElement addButton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button"));
        addButton.click();
        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeButton.click();
        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        Assertions.assertNotEquals("1", shoppingCart.getText(), "Product wasn't removed");
        driver.quit();
    }
}

