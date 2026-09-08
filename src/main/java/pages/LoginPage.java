package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;






    By username =By.id("user-name");
    By password =By.id("password");
    By loginButton = By.id("login-button");
    By erreur = By.cssSelector("[data-test='error']");

    public void login(String nom, String pass){

    driver.findElement(username).sendKeys(nom);
    driver.findElement(password).sendKeys(pass);
    wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

}
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String ErreurMessage(){
        return driver.findElement(erreur).getText();

    }
}
