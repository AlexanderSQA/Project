import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestRunner extends BaseTest {
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestRunner.class);

    @Test
    public void headless() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.xpath("//*[@id=\"search_form_input_homepage\"]")).sendKeys("ОТУС", Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"r1-0\"]/div/h2")).getText(), "Онлайн‑курсы для профессионалов, дистанционное обучение...");
    }

    @Test
    public void fullScreen() {
        driver.manage().window().fullscreen();
        logger.info(driver.manage().window().getSize());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
        driver.findElement(By.xpath("//*[@id=\"vdo_ai_cross\"]")).click();
        driver.findElement(By.xpath("//li[3]/span[@class='image-block']/a[@class='image-zoom']/div[@class = 'content-overlay']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"fullResImage\"]")).getAttribute("src"), "https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/assets/images/p3.jpg");
    }

    @Test
    public void printCookieInLog(){
        driver.manage().window().maximize();
        logger.info(driver.manage().window().getSize());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        OtusMainPage otusMainPage = new OtusMainPage(driver);
        otusMainPage.openMainPage();
        otusMainPage.auth();

        logger.info(driver.manage().getCookies());

    }
}
