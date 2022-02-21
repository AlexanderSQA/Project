import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DuckduckqoPage extends AbstractPage{
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(DuckduckqoPage.class);
    private By searchField = By.xpath("//*[@id=\"search_form_input_homepage\"]");
    protected By firstPosition = By.xpath("//*[@id=\"r1-0\"]/div/h2");

    public DuckduckqoPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://duckduckgo.com/");
        logger.info("Сайт открыт");
    }

    public void searching(){
        driver.findElement(searchField).sendKeys("ОТУС", Keys.ENTER);
        logger.info("Элемент найден");
    }
}
