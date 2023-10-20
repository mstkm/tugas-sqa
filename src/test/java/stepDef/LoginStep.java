package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStep {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("Login Page Saucedemo Web")
    public void login_page_saucedemo_web(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String loginLogo = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginLogo, "Swag Labs");
    }

    @When("User input registered username")
    public void user_input_registered_username(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User input registered password")
    public void user_input_registered_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click login button")
    public void user_click_login_button() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("List product page displayed")
    public void list_product_page_displayed() {
        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(title, "Products");
    }

    @And("User input unregistered password")
    public void user_input_unregistered_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce222");
    }

    @Then("Error login message displayed")
    public void error_login_message_displayed() {
        String title = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(title, "Epic sadface: Username and password do not match any user in this service");
    }
}
