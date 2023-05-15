package testing.pageObject;

import org.openqa.selenium.By;
import testing.utils.Initializer;

public class MyAccountPage extends Initializer {
    By myAccountBtn = By.id("menu-item-57");
    By loginBtn = By.id("btnSubmit");
    By usernametxt=By.id("username");
    By passwordtxt=By.id("password");

    public void clickMyAccount(){
        driver.findElement(myAccountBtn).click();
    }

    public void clickloginBtn(){
        driver.findElement(loginBtn).click();
    }

    public void enterUsername(String username){
        driver.findElement(usernametxt).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordtxt).sendKeys(password);
    }
}
