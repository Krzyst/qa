package pl.jsystems.qa.qagui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class KatalonTest extends GuiConfiguration {



    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://wordpress.com/");
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.id("usernameOrEmail")).click();
        driver.findElement(By.id("usernameOrEmail")).clear();
        driver.findElement(By.id("usernameOrEmail")).sendKeys("krzyst");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("TestSelenium");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Nowy wpis'])[1]/following::*[name()='svg'][1]")).click();
        driver.findElement(By.xpath("//div[@id='secondary']/ul/li/div[2]/button")).click();
        //ERROR: Caught exception [unknown command []]
    }





}
