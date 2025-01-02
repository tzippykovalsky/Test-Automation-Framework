package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {

    public Login(WebDriver driver) {
       super(driver);
    }
    @FindBy(id = "userName")
    private WebElement userName;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login")
    private WebElement loginBtn;

    public void loginAction(String userName,String password)
    {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginBtn.click();
    }
}
