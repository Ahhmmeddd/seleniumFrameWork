package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase
{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 
	MyAccountPage myAccountObject ; 
	String oldPassword = "12345678" ; 
	String newPassword = "123456" ; 
	String firstName = "ahmed" ; 
	String lastName = "mokhtar" ; 
	String email = "ahmedsfadsd@gmailk15.com" ; 
	

	@Test(priority=1)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration(firstName, lastName, email, oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	@Test(priority = 2)
	public void clickOnLogInLink() 
	{
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, oldPassword);
	}
	@Test(priority = 3)
	public void userCanChangePassword()
	{
		registerObject = new UserRegistrationPage(driver);
		registerObject.openMyAccountPage();
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);
		myAccountObject.closeAccount();
	}
	@Test(priority = 4)
	public void userCanLogOut()
	{
		registerObject = new UserRegistrationPage(driver);
		registerObject.userLogout();
	}
	@Test(priority = 5)
	public void userCanLogIn()
	{
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, newPassword);
	}
	@Test(priority = 6)
	public void userCanLogOutAgain()
	{
		registerObject = new UserRegistrationPage(driver);
		registerObject.userLogout();
	}
	
	
}
