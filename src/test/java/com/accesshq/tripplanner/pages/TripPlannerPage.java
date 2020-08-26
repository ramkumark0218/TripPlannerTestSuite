package com.accesshq.tripplanner.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.accesshq.tripplanner.common.CommonUtil;

public class TripPlannerPage {
	
	private WebDriver driver;
	CommonUtil util = new CommonUtil();
	Properties prop;
	
	//List of web elements present of the Trip Planner page will be listed here.
	
	@FindBy(id ="search-input-From")
	private WebElement fromStationTB;
	@FindBy(id="suggestion-From-0")
	private WebElement fromStationListDD;
	
	@FindBy(id = "search-input-To")
	private WebElement toStationTB;
	
	@FindBy(id="suggestion-To-0")
	private WebElement toStationListDD;
	
	@FindBy(id="search-button")
	private WebElement goBtn;
	
	@FindBy(xpath="//*[@ng-repeat='trip in tripResultsVm.trips track by $index']")
	private List<WebElement> resultList;
	
	
	//**Other web elements will be listed here.
	
	
	
	//Methods related to Trip Planner Page.
	
		public TripPlannerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	/*
	 * Getter and Setter methods to fetch and set the values of the properties 
	 * from the outside the class.
	 */
	
	public WebElement getFromStationTB() {
		return fromStationTB;
	}


	public void setFromStationTB(WebElement fromStationTB) {
		this.fromStationTB = fromStationTB;
	}


	public WebElement getToStationTB() {
		return toStationTB;
	}


	public void setToStationTB(WebElement toStationTB) {
		this.toStationTB = toStationTB;
	}
	
	public List<WebElement> getResultList() {
		return resultList;
	}


	//Custom Methods
	
	public void clickOnGoBtn(){
		
		prop = util.LoadPropertiesfile();
			
		fromStationTB.sendKeys(prop.getProperty("fromStation"));
		util.waitForPageToLoadImplicit(driver);
		fromStationListDD.click();

		toStationTB.sendKeys(prop.getProperty("toStation"));
		util.waitForPageToLoadImplicit(driver);
		toStationListDD.click();
		
		goBtn.click();
		
	}
	
	
	

}
	