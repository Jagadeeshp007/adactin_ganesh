package org.setp_def;

import org.helper.File_Reader_Manager;
import org.openqa.selenium.WebDriver;
import org.pom.sdp.PomManager;
import org.test_runner.Test_Runner;

import com.Adactin_Pjt.Baseclass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Setp_Definition extends Baseclass {

	public static WebDriver driver = Test_Runner.driver;

	public static PomManager pom = new PomManager(driver);
	
	@Before
	public static void beforeHooks(Scenario s) throws Throwable {
		String status = s.getStatus();
		System.out.println("Before Hooks Status : " + status);
		if (s.isFailed()) {
			System.out.println("failed 1");
		}
	}

	@After
	public static void afterHooks(Scenario s) throws Throwable {

		String status = s.getStatus();
		System.out.println("After Hooks Status : " + status);
		if (s.isFailed()) {
			System.out.println("failed 2");
		}
	}

	@Given("^user Launch The Adactin Application$")
	public void user_Launch_The_Adactin_Application() throws Throwable {
		String geturl = File_Reader_Manager.filereader().getconfigure().geturl();
		geturl(geturl);

	}

	@When("^user Enter The \"([^\"]*)\" In Username Field$")
	public void user_Enter_The_In_Username_Field(String username) throws Throwable {
		inputValue(pom.login().getusename(), username);

	}

	@When("^user Enter The \"([^\"]*)\" In Password Field$")
	public void user_Enter_The_In_Password_Field(String password) throws Throwable {
		inputValue(pom.login().getPassword(), password);
	}

	@Then("^user Click The Login Button To Navigate The Search Hotel Page$")
	public void user_Click_The_Login_Button_To_Navigate_The_Search_Hotel_Page() throws Throwable {
		clickonevent(pom.login().getLogin());
		waittime(30);
	}

	@When("^user Select The Hotel \"([^\"]*)\"$")
	public void user_Select_The_Hotel(String location) throws Throwable {
		inputValue(pom.getSearch_Hotel().getLocation(), location);
	}

	@When("^user Select The \"([^\"]*)\"$")
	public void user_Select_The(String hotel) throws Throwable {
		inputValue(pom.getSearch_Hotel().getHotels(), hotel);
	}

	@When("^user Select The Room Type$")
	public void user_Select_The_Room_Type() throws Throwable {
		String room_type = File_Reader_Manager.filereader().getconfigure().getroom_type();
		inputValue(pom.getSearch_Hotel().getRoom_type(), room_type);
	}

	@When("^user Select The Number Of Rooms$")
	public void user_Select_The_Number_Of_Rooms() throws Throwable {
		String Norooms = File_Reader_Manager.filereader().getconfigure().getnumofrooms();
		inputValue(pom.getSearch_Hotel().getNumber_of_rooms(), Norooms);
	}

	@When("^user Enter The Check In Date$")
	public void user_Enter_The_Check_In_Date() throws Throwable {
		String checkin = File_Reader_Manager.filereader().getconfigure().getdate_checkin();
		inputValue(pom.getSearch_Hotel().getDatein(), checkin);
	}

	@When("^User Enter The Check Out Date$")
	public void user_Enter_The_Check_Out_Date() throws Throwable {
		String checkout = File_Reader_Manager.filereader().getconfigure().getdatecheckout();
		inputValue(pom.getSearch_Hotel().getDateout(), checkout);
	}

	@When("^user Select The Adults Per Room$")
	public void user_Select_The_Adults_Per_Room() throws Throwable {
		String adult = File_Reader_Manager.filereader().getconfigure().getadults();
		inputValue(pom.getSearch_Hotel().getAdult_room(), adult);
	}

	@When("^user Select The Children Per Room$")
	public void user_Select_The_Children_Per_Room() throws Throwable {
		String children = File_Reader_Manager.filereader().getconfigure().getchildren();
		inputValue(pom.getSearch_Hotel().getChild_room(), children);
	}

	@Then("^user Click The Search Button To Navigate The Select Hotel Page$")
	public void user_Click_The_Search_Button_To_Navigate_The_Select_Hotel_Page() throws Throwable {
		clickonevent(pom.getSearch_Hotel().getSearch());
		waittime(30);
	}

	@When("^user Click To Select The Hotel$")
	public void user_Click_To_Select_The_Hotel() throws Throwable {
		clickonevent(pom.getselect_hotel().getCheckbox());
	}

	@Then("^user Click The Continue Button To Navigate The BooK Hotel$")
	public void user_Click_The_Continue_Button_To_Navigate_The_BooK_Hotel() throws Throwable {
		clickonevent(pom.getselect_hotel().getcontinu());
		waittime(30);
	}

	@When("^user Enter The First Name In First Name Field$")
	public void user_Enter_The_First_Name_In_First_Name_Field() throws Throwable {
		String firstname = File_Reader_Manager.filereader().getconfigure().getFirstname();
		inputValue(pom.getbook_hotel().getFirstname(), firstname);
	}

	@When("^user Enter The Last Name In Last Name Field$")
	public void user_Enter_The_Last_Name_In_Last_Name_Field() throws Throwable {
		String lastname = File_Reader_Manager.filereader().getconfigure().getLastname();
		inputValue(pom.getbook_hotel().getLastname(), lastname);
	}

	@When("^user Enter The Address In Address Field$")
	public void user_Enter_The_Address_In_Address_Field() throws Throwable {
		String address = File_Reader_Manager.filereader().getconfigure().getaddress();
		inputValue(pom.getbook_hotel().getAddress(), address);
	}

	@When("^user Enter The Credit Card No IN Credit Card Field$")
	public void user_Enter_The_Credit_Card_No_IN_Credit_Card_Field() throws Throwable {
		String creditcard = File_Reader_Manager.filereader().getconfigure().getcreditcard();
		inputValue(pom.getbook_hotel().getCc_num(), creditcard);
	}

	@When("^user Select The Card Type$")
	public void user_Select_The_Card_Type() throws Throwable {
		String cardtype = File_Reader_Manager.filereader().getconfigure().getcardtype();
		inputValue(pom.getbook_hotel().getCredit_type(), cardtype);
	}

	@When("^user Select The Expiry Month$")
	public void user_Select_The_Expiry_Month() throws Throwable {
		String month = File_Reader_Manager.filereader().getconfigure().getexpirymonth();
		inputValue(pom.getbook_hotel().getMonth(), month);
	}

	@When("^user Select The Expiry Year$")
	public void user_Select_The_Expiry_Year() throws Throwable {
		String year = File_Reader_Manager.filereader().getconfigure().getexpiryyear();
		inputValue(pom.getbook_hotel().getYear(), year);
	}

	@When("^user Enter The Cvv Number In Cvv Field$")
	public void user_Enter_The_Cvv_Number_In_Cvv_Field() throws Throwable {
		String cvv = File_Reader_Manager.filereader().getconfigure().getcvv();
		inputValue(pom.getbook_hotel().getCvv_num(), cvv);
	}

	@Then("^user Click The Book Now Button To Navigate The Booking Confirm Page$")
	public void user_Click_The_Book_Now_Button_To_Navigate_The_Booking_Confirm_Page() throws Throwable {
		clickonevent(pom.getbook_hotel().book_now());
		waittime(30);
		}

	@Then("^user Click The My Itinerary Button To Navigate Booked Itinerary Page$")
	public void user_Click_The_My_Itinerary_Button_To_Navigate_Booked_Itinerary_Page() throws Throwable {
		clickonevent(pom.getbook_confirmation().getItinerary());
	}

	@Then("^user Click The Logout Button To Logout The Our Account$")
	public void user_Click_The_Logout_Button_To_Logout_The_Our_Account() throws Throwable {
		takescreen(".\\screenshot\\cucumber_project.png");
		clickonevent(pom.booked_itinerary().getLogout());

	}

}
