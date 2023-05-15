package testing.pageObject;

import org.openqa.selenium.By;
import testing.utils.Initializer;

public class SearchResultPage extends Initializer {
    By selectSearchBottle = By.xpath("/html/body/div/div/div/div/div/div[2]/div[1]/div/div/div[2]/a/div");
    By addToCartBtn = By.xpath("//*[@id=\"product-125\"]/div[2]/form/button");

    public void selectBottle() {
        driver.findElement(selectSearchBottle).click();
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }
}
