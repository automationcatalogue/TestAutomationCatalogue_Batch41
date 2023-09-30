package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class OrangeHRM_StepDefinition {
    static WebDriver driver;
    @Given("OrangeHRM application is loaded")
    public void orangeHRM_load(){
        driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");
        driver.manage().window().maximize();
        System.out.println("Browser window is maximized");
        driver.get("https://automationo-trials710.orangehrmlive.com/");
        System.out.println("OrangeHRM website is loaded");
    }

    @When("User entered username as {string}")
    public void enterUserName(String userName){
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userName);
        System.out.println(userName+" is entered as UserName");
    }

    @And("User entered password as {string}")
    public void enterPassword(String password){
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
        System.out.println(password+" is entered as Password");
    }

    @And("User Clicks on Login button")
    public void clickLogin(){
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is clicked");
    }

    @Then("User verified Login is successful")
    public void verifyLogin(){
        boolean isPresent = driver.findElement(By.xpath("//i[text()='oxd_home_menu']")).isDisplayed();
        Assert.assertTrue(isPresent,"Home Menu icon is not displayed");
        System.out.println("Home Menu icon is displayed and Login is successful");
    }

    @And("User Verified title of the Homepage")
    public void verifyTitle(){
        String actualTitle = driver.getTitle();
        String expectedTitle="Employee Management";
        Assert.assertEquals(actualTitle,expectedTitle,"Title of the webpage is not matched");
        System.out.println("Title of the webpage is matched and verified");
    }

}
