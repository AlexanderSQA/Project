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
        driver.quit();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        DuckduckqoPage duckduckqoPage = new DuckduckqoPage(driver);
        duckduckqoPage.openPage();

        duckduckqoPage.searching();
        Assert.assertEquals(driver.findElement(duckduckqoPage.firstPosition).getText(), "Онлайн‑курсы для профессионалов, дистанционное обучение...");
    }

    @Test
    public void fullScreen() {
        driver.manage().window().fullscreen();
        logger.info(driver.manage().window().getSize());

        PicturePage picturePage = new PicturePage(driver);
        picturePage.openPage();
        picturePage.openPicture();
        Assert.assertEquals(driver.findElement(picturePage.modalWindow).getAttribute("src"), "https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/assets/images/p3.jpg");
    }

    @Test
    public void printCookieInLog() {
        driver.manage().window().maximize();
        logger.info(driver.manage().window().getSize());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        OtusMainPage otusMainPage = new OtusMainPage(driver);
        otusMainPage.openMainPage();
        otusMainPage.auth();

        logger.info(driver.manage().getCookies());

    }
}
