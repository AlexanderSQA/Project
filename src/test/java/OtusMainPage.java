import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtusMainPage extends AbstractPage{

    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(OtusMainPage.class);

    private By authButton = By.xpath("//header[2]/div/div[3]/div/div[1]/button");
    private By loginField = By.xpath("//div[2]/form/div[2]/input");
    private By passwordField = By.xpath("//div[2]/form/div[3]/input");
    private By enterButton = By.xpath("//div[2]/form/div[4]/button");
    String login = System.getProperty("login");
    String password = System.getProperty("pass");

    public OtusMainPage(WebDriver driver) {
        super(driver);
    }


    public void openMainPage() {
        driver.get("https://otus.ru/");
        logger.info("Сайт открыт");
    }

    public void auth() {
        driver.findElement(authButton).click();
        logger.info("Форма авторизации открыта");
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(enterButton).submit();
        logger.info("Авторизация прошла успешно");
    }
}
