package testBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	@BeforeClass
	@Parameters({"browser", "headless"})
	public void setup(String br, String bh) {
		rb = ResourceBundle.getBundle("config");
		logger = LogManager.getLogger(this.getClass());
		if (br.equals("chrome")){
		    WebDriverManager.chromedriver().setup();
		    ChromeOptions options = new ChromeOptions();
		    if (bh.equals("true")) {
		    	options.addArguments("--headless");
		    }
		    driver = new ChromeDriver(options);
		}
		else if (br.equals("firefox")){
		    WebDriverManager.firefoxdriver().setup();
		    FirefoxOptions options = new FirefoxOptions();
		    if (bh.equals("true")) {
		    	options.addArguments("--headless");
		    }
		    driver = new FirefoxDriver(options);
		}
		else {
		    WebDriverManager.edgedriver().setup();
		    EdgeOptions options = new EdgeOptions();
		    if (bh.equals("true")) {
		    	options.addArguments("--headless");
		    }
		    driver = new EdgeDriver(options);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("url"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public static String generateRandomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }
	
	public static String generateRandomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }
	
	public static String generateRandomAlphanumeric() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
	

	
	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
}