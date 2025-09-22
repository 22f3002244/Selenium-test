package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class AmazonSearchTest {

    @Test
    public void searchAmazonProduct() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Open Amazon India
            driver.get("https://www.amazon.in/");

            // Wait a bit for the page to load
            Thread.sleep(1000);

            // Locate the search box
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

            // Type the search query and press ENTER
            searchBox.sendKeys("laptop" + Keys.ENTER);

            // Wait for results page to load and display results
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.s-main-slot")));

            // (Optional) Print titles of first few products
            List<WebElement> productTitles = driver.findElements(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal"));
            for (int i = 0; i < Math.min(5, productTitles.size()); i++) {
                System.out.println(productTitles.get(i).getText());
            }

        } catch (Exception e) {
            Reporter.log("Exception caught: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
