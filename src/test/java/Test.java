import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\test\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://a.testaddressbook.com/sign_in");

        //1 тест - Логин
        driver.findElement(By.id("session_email")).sendKeys("Leha148@gmail.com");
        driver.findElement(By.name("session[password]")).sendKeys("Defender198605");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();

        driver.findElement(By.xpath("//a[@data-test='addresses']")).click();

        //2 тест - Добавление адреса
        driver.findElement(By.xpath("//a[@data-test='create']")).click();
        driver.findElement(By.id("address_first_name")).sendKeys("Gusenkov");
        driver.findElement(By.name("address[last_name]")).sendKeys("Aleksey");
        driver.findElement(By.id("address_street_address")).sendKeys("Voroshilova 17/13");
        driver.findElement(By.name("address[address2]")).sendKeys("Timiryazeva 38/2");
        driver.findElement(By.id("address_city")).sendKeys("Krasnopolie");
        driver.findElement(By.cssSelector("option[value='CA']")).click();
        driver.findElement(By.id("address_zip_code")).sendKeys("213561");
        driver.findElement(By.xpath("//input[@value='us']")).click();
        driver.findElement(By.name("address[birthday]")).sendKeys("05.10.1986");
        driver.findElement(By.id("address_color")).sendKeys("#B00C0C");
        driver.findElement(By.cssSelector("input[id='address_age']")).sendKeys("34");
        driver.findElement(By.name("address[website]")).sendKeys("http://krajkx.by");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("+375255123070");
        driver.findElement(By.id("address_interest_climb")).click();
        driver.findElement(By.name("address[note]")).sendKeys("Frend");
        driver.findElement(By.xpath("//input[@name='commit']")).click();

        //3 тест - Изменение адреса
        driver.findElement(By.cssSelector("a[data-test='edit']")).click();
        driver.findElement(By.id("address_first_name")).clear();
        driver.findElement(By.id("address_first_name")).sendKeys("Vasilkov");
        driver.findElement(By.id("address_city")).clear();
        driver.findElement(By.id("address_city")).sendKeys("Los Angeles");
        driver.findElement(By.id("address_interest_climb")).click();
        driver.findElement(By.id("address_interest_dance")).click();
        driver.findElement(By.cssSelector("input[data-disable-with='Update Address']")).click();

        //4 тест - Удаление адреса
        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Destroy')]")).click();
        driver.switchTo().alert().accept();// нажимает "OK" ввсплывающем окне

        //5 тест - Выход пользователя
        driver.findElement(By.cssSelector("a[data-test='sign-out']")).click();

        
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
