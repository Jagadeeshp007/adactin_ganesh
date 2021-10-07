package org.TestNG_file;

import org.helper.File_Reader_Manager;
import org.openqa.selenium.WebDriver;
import org.pom.sdp.PomManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Adactin_Pjt.Baseclass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestNg_Project extends Baseclass {

	public static WebDriver driver;

	public static PomManager pom;

	ExtentReports exrep;
	ExtentTest test;
	ExtentSparkReporter sparkrep;

	@BeforeTest
	private void configure() {

		sparkrep = new ExtentSparkReporter(".//Report//TestNG_Extent.html");

		exrep = new ExtentReports();

		exrep.attachReporter(sparkrep);

		test = exrep.createTest("configure");
	}

	@BeforeClass
	private void browser_Lunch() throws Throwable {
		String browser = File_Reader_Manager.filereader().getconfigure().browser();
		driver = browser(browser);
		pom = new PomManager(driver);

		String url = File_Reader_Manager.filereader().getconfigure().geturl();
		geturl(url);

	}

	@Test(priority = 1)
	private void home_Page() throws Throwable {

		test = exrep.createTest("Home Page");

		String username = File_Reader_Manager.filereader().getconfigure().getusername();
		inputValue(pom.login().getusename(), username);

		String password = File_Reader_Manager.filereader().getconfigure().getpassword();
		inputValue(pom.login().getPassword(), password);

		clickonevent(pom.login().getLogin());

	}

	@Test(priority = 2)
	private void search_hotel() throws Throwable {

		test = exrep.createTest("Search Hotel");

		String location = File_Reader_Manager.filereader().getconfigure().getlocation();
		inputValue(pom.getSearch_Hotel().getLocation(), location);

		String hotel = File_Reader_Manager.filereader().getconfigure().gethotel();
		inputValue(pom.getSearch_Hotel().getHotels(), hotel);

		String room_type = File_Reader_Manager.filereader().getconfigure().getroom_type();
		inputValue(pom.getSearch_Hotel().getRoom_type(), room_type);

		String Norooms = File_Reader_Manager.filereader().getconfigure().getnumofrooms();
		inputValue(pom.getSearch_Hotel().getNumber_of_rooms(), Norooms);

		String checkin = File_Reader_Manager.filereader().getconfigure().getdate_checkin();
		inputValue(pom.getSearch_Hotel().getDatein(), checkin);

		String checkout = File_Reader_Manager.filereader().getconfigure().getdatecheckout();
		inputValue(pom.getSearch_Hotel().getDateout(), checkout);

		String adult = File_Reader_Manager.filereader().getconfigure().getadults();
		inputValue(pom.getSearch_Hotel().getAdult_room(), adult);

		String children = File_Reader_Manager.filereader().getconfigure().getchildren();
		inputValue(pom.getSearch_Hotel().getChild_room(), children);

		clickonevent(pom.getSearch_Hotel().getSearch());

	}

	@Test(priority = 3)
	private void select_Hotel() {
		clickonevent(pom.getselect_hotel().getCheckbox());

		clickonevent(pom.getselect_hotel().getcontinu());

		test = exrep.createTest("Select Hotel");
	}

	@Test(priority = 4)
	private void book_Now() throws Throwable {

		test = exrep.createTest("Book Now");
		String firstname = File_Reader_Manager.filereader().getconfigure().getFirstname();
		inputValue(pom.getbook_hotel().getFirstname(), firstname);

		String lastname = File_Reader_Manager.filereader().getconfigure().getLastname();
		inputValue(pom.getbook_hotel().getLastname(), lastname);

		String address = File_Reader_Manager.filereader().getconfigure().getaddress();
		inputValue(pom.getbook_hotel().getAddress(), address);

		String creditcard = File_Reader_Manager.filereader().getconfigure().getcreditcard();
		inputValue(pom.getbook_hotel().getCc_num(), creditcard);

		String cardtype = File_Reader_Manager.filereader().getconfigure().getcardtype();
		inputValue(pom.getbook_hotel().getCredit_type(), cardtype);

		String month = File_Reader_Manager.filereader().getconfigure().getexpirymonth();
		inputValue(pom.getbook_hotel().getMonth(), month);

		String year = File_Reader_Manager.filereader().getconfigure().getexpiryyear();
		inputValue(pom.getbook_hotel().getYear(), year);

		String cvv = File_Reader_Manager.filereader().getconfigure().getcvv();
		inputValue(pom.getbook_hotel().getCvv_num(), cvv);

		clickonevent(pom.getbook_hotel().book_now());
		waittime(30);

	}

	@Test(priority = 5)
	private void book_Confirm() throws Throwable {

		test = exrep.createTest("Book Confirm");
		clickonevent(pom.getbook_confirmation().getItinerary());

		takescreen(".\\screenshot\\maven_project.png");
		clickonevent(pom.booked_itinerary().getLogout());
		Thread.sleep(4);

	}

	@AfterClass
	private void browser_close() {

		driver.close();
	}

	@AfterTest
	private void flush_1() {
		exrep.flush();
	}
}
