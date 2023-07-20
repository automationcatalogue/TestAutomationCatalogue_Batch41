package pages;

import org.openqa.selenium.By;

public class DemoWebshop_AddressesPage {
    public static By btn_AddNew = By.xpath("//input[@value='Add new']");
    public static By txtbx_FirstName = By.cssSelector("#Address_FirstName");
    public static By txtbx_LastName = By.cssSelector("#Address_LastName");
    public static By link_mailID = By.cssSelector("#Address_Email");
    public static By txtbx_companyName = By.cssSelector("#Address_Company");
    public static By dropdown_Country = By.xpath("//select[@id='Address_CountryId']");
    public static By txtbx_City = By.cssSelector("#Address_City");
    public static By txtbx_Address1 = By.cssSelector("#Address_Address1");
    public static By txtbx_Address2 = By.cssSelector("#Address_Address2");
    public static By txtbx_Zipcode = By.cssSelector("#Address_ZipPostalCode");
    public static By txtbx_Phonenumber = By.cssSelector("#Address_PhoneNumber");
    public static By txtbx_Faxnumber = By.cssSelector("#Address_FaxNumber");
    public static By btn_Save = By.xpath("//input[@value='Save']");

}

