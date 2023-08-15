package auto_runner;

import org.testng.annotations.*;

import io.cucumber.testng.*;

@CucumberOptions(
		features = "src/test/java/features",
		glue = "glue_code",
		plugin = {"json:Results/cucumber_json/cucumber.json"}
//		,tags = ""
		)
public class cucumber_runner {
	
	private TestNGCucumberRunner testng_cucumber_runner;
	
	@BeforeClass(alwaysRun = true)
	public void set_up_class() throws Throwable{
		testng_cucumber_runner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void scenario(PickleWrapper pickle, FeatureWrapper cucumber_feature) {
		testng_cucumber_runner.runScenario(pickle.getPickle());
	}
	
	@DataProvider(name = "features")
	public Object[][] scenarios(){
		if(testng_cucumber_runner == null) {
			System.out.println("Runnner is returning null: dataprovider");
			testng_cucumber_runner = new TestNGCucumberRunner(this.getClass());
		}
		else {
			System.out.println("Runner is not null: dataprovider");
		}
		return testng_cucumber_runner.provideScenarios();
	}
	
	@AfterClass(alwaysRun = true)
	public void tear_down_class() throws Throwable{
		try {
			testng_cucumber_runner.finish();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite(alwaysRun = true)
	public void terminate_driver() throws Throwable{
		try {
			Process p = Runtime.getRuntime().exec("taskkill /im chromedriver.exe -f");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
