package pl.jsystems.qa.qagui;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.jsystems.qa.qagui.page.LoginPage;
import pl.jsystems.qa.qagui.page.MainUserPage;
import pl.jsystems.qa.qagui.page.MyProfilePage;
import pl.jsystems.qa.qagui.page.WordPressMainPage;

import java.time.Duration;

import static com.google.common.truth.Truth.assertThat;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuiTest extends GuiConfig{


    @Test
    public void lgInTest() {
        driver.get("https://wordpress.com/");

        WordPressMainPage wordpressMainPage = new WordPressMainPage(driver);

        wordpressMainPage.logIn.click();

        final WebElement usernameOrEmail = driver.findElement(By.id("usernameOrEmail"));

        usernameOrEmail.click();
        usernameOrEmail.clear();
        usernameOrEmail.sendKeys("automation112021");
        driver.findElement(By.className("login__form-action")).click();

        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

//        try {
//            sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        driver.findElement(By.id("password")).click();

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Test112021");
        driver.findElement(By.className("login__form-action")).click();

        final WebElement avatar = driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me"));

        assertTrue(avatar.isDisplayed());

        avatar.click();

        assertThat(driver.findElement(By.className("profile-gravatar__user-display-name")).getText()).isEqualTo("automation112021");

        driver.findElement(By.cssSelector("button[title=\"Log out of WordPress.com\"]")).click();

    }

    WordPressMainPage wordpressMainPage;
    LoginPage loginPage;
    MainUserPage mainUserPage;
    MyProfilePage myProfilePage;
    @Test
    public void lgIn() {
        driver.get("https://wordpress.com/");
        wordpressMainPage = new WordPressMainPage(driver);
        wordpressMainPage.clickLogIn();

        loginPage = new LoginPage(driver);
        loginPage.enterUser("krzyst");
        loginPage.userContinueButton.click();
        loginPage.enterPass("TestSelenium");
        loginPage.passConfirmButton.click();

        mainUserPage = new MainUserPage(driver);
        assertTrue(mainUserPage.avatar.isDisplayed());
        mainUserPage.clickAvatar();

        myProfilePage = new MyProfilePage(driver);

        assertThat(myProfilePage.getProfileName()).isEqualTo("krzyst");
        myProfilePage.clickLogOutButton();

    }



    @Test
    public void logInTest() {
        driver.get("https://wordpress.com/");
        driver.findElement(By.linkText("Log In")).click();

        final WebElement usernameOrEmail = driver.findElement(By.id("usernameOrEmail"));
        usernameOrEmail.clear();
        usernameOrEmail.click();
        usernameOrEmail.sendKeys("krzyst");

        driver.findElement(By.className("login__form-action")).click();

        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

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
