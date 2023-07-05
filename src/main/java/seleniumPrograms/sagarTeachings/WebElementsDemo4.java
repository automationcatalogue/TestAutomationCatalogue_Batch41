package seleniumPrograms.sagarTeachings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsDemo4 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser window is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome Browser window is maximized");

        driver.get("https://automation41-trials79.orangehrmlive.com");
        System.out.println("Website is loaded");

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div[4]/button")).click();

        Thread.sleep(8000);

        WebElement element_Name = driver.findElement(By.xpath("//*[@id=\"sidebar-profile-picture\"]/a"));
        String str = element_Name.getText();
        System.out.println("UserName is :"+str);

        if(str.equalsIgnoreCase("Jacqueline Wagner")){
            System.out.println("Login is successful");
        }else{
            System.out.println("Login is failed");
        }

        String url =driver.getCurrentUrl();
        System.out.println("Latest URL is :"+url);

        String pagesource = driver.getPageSource();
        System.out.println(pagesource);

        String str2 =element_Name.getAttribute("href");
        System.out.println(str2);

        str2 =element_Name.getTagName();
        System.out.println("TagName is :"+str2);

        WebElement element_MyActions = driver.findElement(By.xpath("//*[@id=\"widget.id\"]/span/span/my-actions-widget/div/div/div[1]/span[2]"));
        String str1 =element_MyActions.getAttribute("class");
        System.out.println(str1);

        int a =element_MyActions.getLocation().getX();
        System.out.println("X coordinate value is :"+a);

        int b = element_MyActions.getLocation().getY();
        System.out.println("Y coordinate value is :"+b);

        WebElement element = driver.findElement(By.xpath("//*[@id=\"topbar\"]/ul[1]/li/div"));
        String str3 = element.getCssValue("color");
        System.out.println("color of the element is :"+str3);

        str3=element.getCssValue("font-size");
        System.out.println("Font-size is :"+str3);

        str3=element.getCssValue("font-family");
        System.out.println("Font-family is :"+str3);

        int c = element.getSize().getHeight();
        System.out.println("Height of the element is :"+c);

        int d = element.getSize().getWidth();
        System.out.println("Width of the element is :"+d);





    }
}
