package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;
 By ajout1 = By.id("add-to-cart-sauce-labs-backpack");
 By ajout2 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
 By nombreCommande = By.className("shopping_cart_badge");

 public ProductsPage(WebDriver driver) {
        this.driver = driver;
 }

 public void premierArticle (){
        driver.findElement(ajout1).click();
    }

 public void deuxArticle(){
        driver.findElement(ajout2).click();
    }

  public String nombre() {
        return driver.findElement(nombreCommande).getText();
    }

}
