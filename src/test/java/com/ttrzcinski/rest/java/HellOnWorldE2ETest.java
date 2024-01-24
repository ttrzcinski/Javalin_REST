package com.ttrzcinski.rest.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.assertj.core.api.Assertions.assertThat;

public class HellOnWorldE2ETest {

    private final HellApp app = new HellApp(); // inject any dependencies you might have

    // TODO UNREM, WHEN FIXED: org.openqa.selenium.WebDriverException: unknown error: DevToolsActivePort file doesn't exist
    @Disabled()
    @Test
    public void UI_contains_correct_heading() {
        int testedPort = 7000; // 1234
        String testedUrl = String.format("http://localhost:%d/ui", testedPort);

        app.start(testedPort);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        WebDriver driver = new ChromeDriver(options);
        driver.get(testedUrl);
        assertThat(driver.getPageSource()).contains("<h1>Demon UI</h1>");
        driver.quit();
        app.stop();
    }

}

