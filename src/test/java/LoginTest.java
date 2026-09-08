
import pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import pages.ProductsPage;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    ProductsPage productsPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);

    }
    @AfterEach
    void fermer(){
        driver.quit();
    }

   @Test
    void verifok(){

       assertEquals ( "Swag Labs",driver.getTitle());

   }

@Test
    void authentifpositif(){

//tester si les vrais identifiants marchent ou pas

    loginPage.login("standard_user", "secret_sauce");

}

    @Test
    void authentifnegatif(){

        //tester un vrai identifiant et un faut mot de passe et voir si la page produit saffiche ou pas

        loginPage.login("standard_user","123456");
        String message = loginPage.ErreurMessage();


        assertEquals("Epic sadface: Username and password do not match any user in this service",message);

    }
    @Test
    void authentifnegatif2(){

        //tester un faux identifiant et un vrai mot de passe

        loginPage.login("hedy@gmail.com","secret_sauce");
        String auth = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/",auth);

    }
    @Test
            void ajoutproduits(){

        loginPage.login("standard_user", "secret_sauce");
        productsPage.premierArticle();
        productsPage.deuxArticle();

        assertEquals("2", productsPage.nombre());

    }

}
