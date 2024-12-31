package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BasePageObject {

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
