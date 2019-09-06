package stepdefinations.mobile;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.BaseTest;

/**
 * @author smali
 */
public class ContactManagerAppSteps {

    private WebDriver driver;

    public ContactManagerAppSteps() {
        this.driver = BaseTest.getDriver();
    }

    @Given("^I open the application$")
    public void i_open_the_application() {
        // Validating if application is opened
        Assert.assertTrue(driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).isDisplayed());

    }

    @When("^I tab on addContactButton$")
    public void i_tap_on_addContactButton() {
        // Clicking add button
        driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();
    }

    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_enter_Contact_Name_and_Contact_Phone(String contactName, String contactNumber) {

        // Sending ContactName and ContactNumber
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys(contactName);
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys(contactNumber);
    }

    @Then("^I tab to save button$")
    public void i_tab_to_save_button() {

        // Hiding keyboard from phone
        driver.navigate().back();

        // Clicking on save button to add employee
        driver.findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).click();
    }

    @When("^I check on show invisible contact$")
    public void i_check_on_invisible_buttom() {

        // Validating if invisiable is displayed
        Assert.assertTrue(driver.findElement(By.id("com.example.android.contactmanager:id/showInvisible")).isDisplayed());

        // Clicking on checkbox
        driver.findElement(By.id("com.example.android.contactmanager:id/showInvisible")).click();
    }

    @Then("^I can see invisible contact list$")
    public void i_can_see_invisible_contact_list(){

        // Validating if contact list widget is displayed
        Assert.assertTrue(driver.findElement(By.id("com.example.android.contactmanager:id/contactList")).isDisplayed());
    }

}
