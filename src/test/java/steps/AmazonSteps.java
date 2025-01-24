package steps;



import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.*;

import pages.PaginaPrincipal;


public class AmazonSteps {
    
    PaginaPrincipal amazon = new PaginaPrincipal();

    @Given("^the user navigates to www.amazon.com$")
    public void navigateToAmazon(){
        amazon.navigateToAmazon();
    }

    @And("^searches for (.+)$")
    public void enterSearchCriteria(String criteria){
        amazon.enterSearchCriteria(criteria);
        amazon.clickSearch();
    }

    @And("^navigates to the page number (.+)$")
    public void navigateToSecondPage( String pageNumber){
        amazon.goToPage(pageNumber);
    }

    @And("^selecs the third item$")
    public void selecsThirItem(){
        amazon.pick3rdItem();
    }

    @Then("^the user is able to add it to the carst$")
    public void itemCanBeAddedToTheCart(){
        amazon.addToCart();
        Assert.assertEquals("Agregado al carrito", amazon.addedToCartMessage());
    }
}
