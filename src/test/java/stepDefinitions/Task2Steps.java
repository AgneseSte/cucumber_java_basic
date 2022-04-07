package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.*;

public class Task2Steps {
    private WebDriver driver;

    public Task2Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on list_of_people_with_jobs page$")
    public void iAmOnPeopleJobsStartPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }

    @When("^I click Add person$")
    public void clickAddPerson() throws Throwable {
        driver.findElement(By.xpath("//*[text()='Add person']")).click();
    }

    @And("^I enter person name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter person job: \"([^\"]*)\"$")
    public void iEnterAge(String job) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^I click Add$")
    public void clickAdd() throws Throwable {
        driver.findElement(By.xpath("//*[text()='Add']")).click();
    }

    List<WebElement> personList;
    List<WebElement> jobList;

    @When("^I save existing list$")
    public void saveExistingList() throws Throwable {
        personList = driver.findElements(By.className("w3-xlarge"));
        jobList = driver.findElements(By.className("job"));
    }

    @Then("^I check the list of people has been changed$")
    public void checkListHasBeenChanged() throws Throwable {
        List<WebElement> listOfPeoples = driver.findElements(By.className("w3-xlarge"));
        List<WebElement> listOfJobs = driver.findElements(By.className("job"));
        assertFalse(personList == listOfPeoples);
        assertFalse(jobList == listOfJobs);

    }

    @Then("^reset to the the original list$")
    public void clickResetList() throws Throwable {
        driver.findElement(By.xpath("//*[text()='Reset List']")).click();
    }

    @Then("^I click to edit person$")
    public void clickToEditPerson() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"person2\"]/span[2]/i")).click();
    }

    @And("^I click Edit$")
    public void clickEdit() throws Throwable {
        driver.findElement(By.xpath("//*[text()='Edit']")).click();
    }

    @Then("^I click to delete person$")
    public void clickToDeletePerson() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[1]")).click();
    }

    @And("^I click Clear all fields$")
    public void clickClearFields() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @And("^I check input fields are empty$")
    public void inputFieldsAreEmpty() throws Throwable {
        assertTrue(driver.findElement(By.id("name")).getText().isEmpty());
        assertTrue(driver.findElement(By.id("job")).getText().isEmpty());
    }

}
