package emulator;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.fetch.Fetch;
import org.openqa.selenium.devtools.v131.fetch.model.HeaderEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkMocking2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));

        devTools.addListener(Fetch.requestPaused(), request -> {
            if (request.getRequest().getUrl().contains("shetty") && request.getRequest().getUrl().contains("specificParameter")) {
                String mockedUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
                System.out.println("Mocked URL: " + mockedUrl);
                devTools.send(Fetch.continueRequest(
                        request.getRequestId(), 
                        Optional.of(mockedUrl),  
                        Optional.of(request.getRequest().getMethod()), 
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty()));
            } else {
                devTools.send(Fetch.continueRequest(
                        request.getRequestId(), 
                        Optional.of(request.getRequest().getUrl()), 
                        Optional.of(request.getRequest().getMethod()), 
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty()));
            }
        });

        

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[contains(text(),'Virtual Library')]")).click();

        // Use explicit wait instead of Thread.sleep
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        System.out.println(driver.findElement(By.cssSelector("p")).getText());

        driver.quit();
    }
}