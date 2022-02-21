import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PicturePage extends AbstractPage{

    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(PicturePage.class);
    private By cross = By.xpath("//*[@id=\"vdo_ai_cross\"]");
    private By picture = By.xpath("//li[3]/span[@class='image-block']/a[@class='image-zoom']/div[@class = 'content-overlay']");
    protected By modalWindow = By.xpath("//*[@id=\"fullResImage\"]");

    public PicturePage(WebDriver driver) {
        super(driver);
    }


    public void openPage(){
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
        logger.info("Сайт открыт");
    }

    public void openPicture(){
        driver.findElement(cross).click();
        driver.findElement(picture).click();
    }
}
