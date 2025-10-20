package ru.netology.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class PaymentTest {
    @Test
    public void testSuccessfulPayment() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        // Заполнение формы оплаты
        driver.findElement(By.id("cardNumber")).sendKeys("4111111111111111");
        driver.findElement(By.id("expiryDate")).sendKeys("12/25");
        driver.findElement(By.id("cvv")).sendKeys("123");
        driver.findElement(By.id("payButton")).click();
        // Проверка успешного сообщения
        assertTrue(driver.findElement(By.id("successMessage")).isDisplayed());
        driver.quit();
    }
}