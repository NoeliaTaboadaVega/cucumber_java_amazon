package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    protected static WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 

    static {
        WebDriverManager.chromedriver().setup();
        //Inicializa la variable estatica ´driver´con una instancia de ChromeDriver
        driver = new ChromeDriver();
    }

    /*Este es el constuctor de BasePage que acepta un objeto WebDriver como argumento */
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }

    /*Metodo estatico para navegar a una URL*/
    public static void navigateTo(String url){
        driver.get(url);
    }

    /*Encuentra y devuelve un WebElement en la pagina utilizando un locator XPath
     * esperando a que este presente en el DOM */
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    /*clickea en el elemento luego de buscarlo*/
    public void clickElement(String locator){
        Find(locator).click();
    }
    //Cierra el navegador
    public static void closeBrowser(){
        driver.quit();
    }
}