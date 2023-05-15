package testing.stepDef;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testing.pageObject.CartPage;
import testing.pageObject.MyAccountPage;
import testing.pageObject.SearchResultPage;
import testing.pageObject.ShopPage;
import testing.utils.Initializer;


public class Stepdefs extends Initializer {
    Initializer initializer = new Initializer();
    MyAccountPage homePage = new MyAccountPage();
    ShopPage shopPage = new ShopPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    CartPage cartPage = new CartPage();

    @After
    public void cleanup(Scenario scenario) {
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        driver.close();
    }

    @Given("I am on {string} home page using{string}")
    public void iAmOnHomePageUsing(String website, String browser) throws Exception {
        initializer.initializeDriver(website, browser);
    }

    @When("I click My account enter {string} and {string}")
    public void iClickMyAccountEnterAnd(String username, String password) {
//        homePage.clickMyAccount();
        homePage.enterUsername(username);
        homePage.enterPassword(password);
    }

    @Then("I click login button")
    public void iClickLoginButton() {
        homePage.clickloginBtn();
    }

    @And("I click Shop from the menu items")
    public void iClickShopFromTheMenuItems() {
        shopPage.clickShopLink();
    }

    @And("I search for {string}")
    public void iSearchFor(String bottleName) {
        shopPage.searchBottle(bottleName);
        shopPage.clickSearch();
    }


    @Then("I select Bottle")
    public void iSelectBottle() {
        searchResultPage.selectBottle();
        searchResultPage.addToCart();
    }

    @And("I place order")
    public void iPlaceOrder() throws InterruptedException {
        cartPage.proceedToCheckout();
        cartPage.placeOrder();
        String OrderNum = cartPage.getOrderNum();

        System.out.println(OrderNum);
    }
}
