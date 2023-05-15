package testing.pageObject;

import org.openqa.selenium.By;
import testing.utils.Initializer;

public class ShopPage extends Initializer {
    By shopLink = By.id("menu-item-51");
    By searchTxb = By.id("wp-block-search__input-1");
    By searchBtn = By.xpath("//*[@id=\"block-2\"]/form/div/button");

    public void clickShopLink() {
        driver.findElement(shopLink).click();
    }

    public void searchBottle(String bottleName) {
        driver.findElement(searchTxb).sendKeys(bottleName);
    }

    public void clickSearch() {
        driver.findElement(searchBtn).click();
    }
}
