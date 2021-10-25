package automationModules;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import pageObjects.ResultsPage;
import support.Browser;
import support.Car;
import support.Config;

import java.util.List;

import static support.Browser.driver;
import static support.Constants.regInput;
import static support.ReadAndExtractCsv.regNumberList;
import static support.ReadAndExtractCsv.vehicleInfo;
import static support.Utils.waitForElement;


public class CarCheckTest {

    public HomePage homePage = new HomePage();
    public ResultsPage resultsPage = new ResultsPage();

    //Test setup
    @BeforeTest
    public void testSetup() {
        Config.initParams();
        Browser.start();
    }

    @Test(dataProvider = "testData")
    public void carCheck(String reg) {
        driver.get(Config.environment);
        homePage.enterCarReg(reg);
        homePage.freeCheck();
        List<Car> cars = vehicleInfo();
        waitForElement(driver, regInput, 5000);

        Assert.assertEquals(reg.replaceAll("\\s", ""), resultsPage.getReg(), "Car : " + reg + " not present");
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getRegistration().equals(resultsPage.getReg())) {
                SoftAssert softAssert = new SoftAssert();
                softAssert.assertEquals(resultsPage.getReg(), cars.get(i).getRegistration(), "Car : " + cars.get(i).getRegistration() + " not present");
                softAssert.assertEquals(resultsPage.getMake(), cars.get(i).getMake(), "Car : " + cars.get(i).getMake() + " not present");
                softAssert.assertEquals(resultsPage.getModel(), cars.get(i).getModel(), "Car : " + cars.get(i).getModel() + " not present");
                softAssert.assertEquals(resultsPage.getColour(), cars.get(i).getColour(), "Car : " + cars.get(i).getColour() + " not present");
                softAssert.assertEquals(resultsPage.getYear(), cars.get(i).getYear(), "Car : " + cars.get(i).getYear() + " not present");
                softAssert.assertAll();
            }
        }
    }

    //Dataprovider for passing in input data
    @DataProvider(name = "testData")
    public Object[] passData() {
        List<String> regList = regNumberList();
        Object[] dataObject = regList.toArray();
        return dataObject;
    }

    @AfterTest
    public void shutDown() {
        Browser.close();
    }
}
