package com.accesshq.tripplanner.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.accesshq.tripplanner.common.CommonUtil;
import com.accesshq.tripplanner.pages.TripPlannerPage;

public class TripPlannerTest extends CommonUtil {
	
		
		private WebDriver driver;
		TripPlannerPage trippage;
				
				
		@BeforeMethod
		public void setUp(){
			driver = getDriver();			
		}
		
		//Test to validate the "scenario: A trip request can be executed and results returned"
		@Test
		public void validateListOfTripReturned(){
			
			trippage = new TripPlannerPage(driver);
			trippage.clickOnGoBtn();
			waitForPageToLoadImplicit(driver);
			
			Assert.assertFalse(trippage.getResultList().isEmpty());			
		}
		
				
		@AfterMethod
		public void tearDown(){
			driver.close();
			driver.quit();
		}
	
	 
}
