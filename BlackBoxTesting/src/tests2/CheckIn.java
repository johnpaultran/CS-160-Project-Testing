package tests2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.Set;

public class CheckIn {

    public static void main(String[] args) throws InterruptedException {
        // set chrome driver and open app in maximized window
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JP Tran\\Downloads\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--profile-directory=Default");
        options.addArguments("--whitelisted-ips");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-plugins-discovery");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://car-eservation.netlify.app/");
        Thread.sleep(1000);

        // login to site
        WebElement loginBtn = driver.findElement(By.xpath("//a[@href='/login']"));
        loginBtn.click();
        WebElement loginGoogleBtn = driver.findElement(By.xpath("//button[@class='LoginPage_loginBtn__XiDZv']"));
        loginGoogleBtn.click();
        Thread.sleep(2000);

        // switch to pop up window
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String p = it.next();
        String c = it.next();
        driver.switchTo().window(c);
        Thread.sleep(2000);

        // login to Google
        driver.getWindowHandles();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("cs160blackbox@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234!@#$qwer");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button")).click();
        Thread.sleep(3000);

        // switch to main window and press view reservations
        driver.switchTo().window(p);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/reservations']")).click();

        // press check in
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div[1]/button")).click();

        // quit driver
        Thread.sleep(3000);
        driver.quit();
    }
}
