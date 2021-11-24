package pl.jsystems.qa.qagui;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.google.common.truth.Truth.assertThat;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuiTest extends GuiConfig{


    @Test
    public void lgInTest() {
        driver.get("https://wordpress.com/");
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.id("usernameOrEmail")).click();
        driver.findElement(By.id("usernameOrEmail")).clear();
        driver.findElement(By.id("usernameOrEmail")).sendKeys("automation112021");
        driver.findElement(By.className("login__form-action")).click();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Test112021");
        driver.findElement(By.className("login__form-action")).click();
        assertTrue(driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me")).isDisplayed());
        driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me")).click();

        assertThat(driver.findElement(By.className("profile-gravatar__user-display-name")).getText()).isEqualTo("automation112021");

        driver.findElement(By.cssSelector("button[title=\"Log out of WordPress.com\"]")).click();

    }



    @Test
    public void logInTest() {
        driver.get("https://wordpress.com/");
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.id("usernameOrEmail")).clear();
        driver.findElement(By.id("usernameOrEmail")).click();
        driver.findElement(By.id("usernameOrEmail")).sendKeys("krzyst");
        driver.findElement(By.className("login__form-action")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("TestSelenium");
        driver.findElement(By.className("login__form-action")).click();
        assertTrue(driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me")).isDisplayed());
        driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me")).click();

        assertThat(driver.findElement(By.className("profile-gravatar__user-display-name")).getText()).isEqualTo("krzyst");

        driver.findElement(By.cssSelector("button[title=\"Log out of WordPress.com\"]")).click();




    }
}
