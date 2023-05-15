package testing.pageObject;

import org.openqa.selenium.By;
import testing.utils.Initializer;

public class CartPage extends Initializer {

    By proceedToCheckoutBtn = By.xpath("//*[@id=\"post-52\"]/div/div/div[2]/div/div/a");
    By placeOrderBtn = By.xpath("//*[@id=\"place_order\"]");
    By getOrderNumber = By.xpath("//*[@id=\"post-54\"]/div/div/div/ul/li[1]/strong");

    public void proceedToCheckout() {
        driver.findElement(proceedToCheckoutBtn).click();
    }

    public void placeOrder() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(placeOrderBtn).click();
    }

    public String getOrderNum() throws InterruptedException {
        Thread.sleep(6000);
        driver.findElement(getOrderNumber).getText();
        return null;
    }
}
