import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChromeTest {

    private WebDriver driver;
    @BeforeEach //Esta anotacion permite ejecutar una porcion de codigo antes de que se ejecute un test.
    public void setup(){// En este caso, antes de ejecutar un test creara la variable WebDriver para la conexion que usaran esos test.
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
    }
    @AfterEach //Esta anotacion permite ejecutar una porcion de codigo despues de que se ejecute un test.
    public void finishDriver(){
        driver.quit();
    }

/*a. Haz un test que liste los productos de una categoría y compruebe que se
    cargue el mismo número de productos que se cargan en la web*/



    @Test

    public void testNumProducts(){
        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        driver.get("https://www.lidl.es/");
        ewait.until(ExpectedConditions.titleContains("Lidl"));
        driver.findElement(By.xpath("//button[@class='cookie-alert-extended-button']")).click();
        driver.findElement(By.cssSelector("input#mainsearch-input")).sendKeys("zumo");
        driver.findElement(By.cssSelector("button.primary")).click();
        ewait.until(ExpectedConditions.titleContains("Resultado de búsqueda"));
        List<WebElement> products = driver.findElements(By.cssSelector("div[class='plp-product-grid-box-tile__title']"));
        for(WebElement countProducts : products){
            System.out.println("Producto = "+countProducts.getText());
        }
        assertEquals(4,products.size(),"Se esperaban 4 productos.");
    }



    //driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS); "plp-product-grid-box-tile__title"
}
