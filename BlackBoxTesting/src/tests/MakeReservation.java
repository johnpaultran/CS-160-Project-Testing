package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.Set;

public class MakeReservation {

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

        // switch to main window and press reserve a spot
        driver.switchTo().window(p);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='ViewPage_reserveBtn__VDIy6']")).click();
        Thread.sleep(3000);

        // fill out reservation form
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Catherine");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Nguyen");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("cs160blackbox@gmail.com");
        driver.findElement(By.xpath("//input[@name='license']")).sendKeys("69CAT69");
        driver.findElement(By.xpath("//button[@value='B']")).click();
        Thread.sleep(1000);

        // submit reservation and quit
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div/button")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
