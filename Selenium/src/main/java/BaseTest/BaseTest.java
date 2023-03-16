package BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    private WebDriver driver;

    public void setup() /*throws InterruptedException*/ {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lidl.es/");

        //Thread.sleep(3000); Sirve para añadir un tiempo de demora en la ejecución

        //driver.quit(); Metodo de la clase WebDriver para cerrar el objeto o instancia.
    }

    public void aceptCookie(){
        driver.findElement(By.xpath("//button[@class='cookie-alert-extended-button']")).click();
    }

    public void searchProduct(){
        driver.findElement(By.cssSelector("input#mainsearch-input")).sendKeys("zumo");
        driver.findElement(By.cssSelector("button.primary")).click();
    }

}
