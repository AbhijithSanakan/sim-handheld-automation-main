package com.framework.automation.utils;

import com.framework.automation.drivers.DriverFactory;
import com.framework.automation.framework.support.ApplicationProp;
import com.framework.automation.framework.support.ConfigProp;
import com.framework.automation.framework.support.DriverDataHolder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.yaml.snakeyaml.Yaml;
import javax.imageio.ImageIO;

/**
 * This TestUtil class consists of all testing or framework related utils
 *
 * @since 05-16-2019
 * @version 3.2
 *
 */
public class TestUtil {

	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public static Properties config = new Properties();
	static Logger logger = LogManager.getLogger(TestUtil.class);
	static StringBuilder request_sb = new StringBuilder();
	static String requestTimeStamp;
	static String responseTimeStamp;
	static StringBuilder response_sb = new StringBuilder();
	static String env;

	static {
		try {
			env = System.getProperty("Env");
			InputStream str = new FileInputStream("config.Properties");
			config.load(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The browserConfig method is used to get the browser details from scenario outlines and put it into the driver
	 * data hash map table
	 *
	 * @param -String browser name
	 * @return
	 * @throws
	 * @see -
	 * @since 05-16-2019
	 * @version 1.8
	 *
	 */
	public static void browserConfig(String browserName) {

		String browserDetails;
		browserDetails = ConfigProp.getPropertyValue("browser_" + browserName);

		if (browserDetails == null || browserDetails == "") {
			browserDetails = ConfigProp.getPropertyValue("browser_default");
		}

		Map<String, String> tempMap = new HashMap<String, String>();
		String[] elements = browserDetails.split(",");
		for (String s1 : elements) {
			String[] keyValue = s1.split("=");
			tempMap.put(keyValue[0].toString(), keyValue[1].toString());
		}

		DriverDataHolder.init(tempMap);
		System.out.println("DriverDataHolder set value");
	}

	/**
	 * The cloudConfig method is used to get the cloud native app OS details from scenario outlines and put it into the
	 * driver data hash map table
	 * This is used for iOS and Android native apps only
	 *
	 * @param -String os name name
	 * @return
	 * @throws
	 * @see -
	 * @since 08-28-2019
	 * @version 1.4
	 *
	 */
	public static void cloudConfig(String cloudplatform) throws Exception{
		Map<String, String> propertiesMap = new HashMap<String, String>();
		if(ConfigProp.getPropertyValue("cloud_" + cloudplatform)==null || ConfigProp.getPropertyValue("cloud_" + cloudplatform).isEmpty()){
			throw new Exception("Cloud capabilities is empty.Please configure properties file with appropriate data");
		}
		else{

			String[] elements = ConfigProp.getPropertyValue("cloud_" + cloudplatform).split(",");
			for (String s1 : elements) {
				String[] keyValue = s1.split("=");
				propertiesMap.put(keyValue[0].toString(), keyValue[1].toString());
			}
		}
		DriverDataHolder.init(propertiesMap);
	}

	/**
	 * The mobileConfig method is used to get the mobile details from scenario outlines and put it into the driver
	 * data hash map table
	 *
	 * @param -String device name
	 * @return
	 * @throws
	 * @see -
	 * @since 07-16-2019
	 * @version 1.8
	 *
	 */
	public static void mobileConfig(String deviceName) {

		String browserDetails;
		browserDetails = ConfigProp.getPropertyValue("mobile_" + deviceName);

		if (browserDetails == null || browserDetails == "") {
			browserDetails = ConfigProp.getPropertyValue("browser_default");
		}

		Map<String, String> tempMap = new HashMap<String, String>();
		String[] elements = browserDetails.split(",");
		for (String s1 : elements) {
			String[] keyValue = s1.split("=");
			tempMap.put(keyValue[0].toString(), keyValue[1].toString());
		}

		DriverDataHolder.init(tempMap);
	}



	/**
	 * The ApplicationConfig method is used to get the application configuration details from scenario outlines and put it into the Application
	 * data hash map table
	 *
	 * @param -String environmentName
	 * @return
	 * @throws
	 * @see -
	 * @since 11-04-2019
	 * @version 1.0
	 *
	 */
	public static void ApplicationConfig(String environmentName) {
		Yaml yaml = new Yaml();
		try {
			InputStream file = new FileInputStream("environment.yaml");
			Object environmentTmp = yaml.load(file);
			if (!(environmentTmp instanceof Map))
				throw new IOException("File not formatted correctly");

			Map<String, Object> environment = (Map<String, Object>) environmentTmp;
			Map<String, Object> selected_environment = (Map<String, Object>) environment.get(environmentName);
			ApplicationProp.init(selected_environment);
			System.out.println("App Prop init called");

		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Issue in setting up the Application environment properties");
			Allure.description("Issue in setting up the Application environment properties");
		}

	}

	/**
	 * The RepositoryConfig method is used to get the Repository configuration details from scenario outlines and put it into the Repository
	 * data hash map table
	 *
	 * @param -String environmentName
	 * @return
	 * @throws
	 * @see -
	 * @since 25-05-2020
	 * @version 1.0
	 *
	 */
	public static Map<String, Object> RepositoryConfig(String repoFileLocation, String Component) {
		Yaml yaml = new Yaml();
		try {
			InputStream file = new FileInputStream(repoFileLocation);
			Object RepositoryTmp = yaml.load(file);
			if (!(RepositoryTmp instanceof Map))
				throw new IOException("File not formatted correctly");

			Map<String, Object> Repository = (Map<String, Object>) RepositoryTmp;
			Map<String, Object> selected_component = (Map<String, Object>) Repository.get(Component);
			return selected_component;
		}
		catch (Exception e)
		{
			System.out.println("Issue in setting up the Repository properties" + e);
			Allure.description("Issue in setting up the Repository properties");
			return null;
		}
	}

	/**
	 * The takeScreenShot method is used to take screenshot of web/mobile and save it in a common location in framework
	 *
	 * @param -
	 * @return Inputstream
	 * @throws
	 * @see -
	 * @since 04-10-2019
	 * @version 1.0
	 *
	 */
	public static InputStream takeScreenShot() {
		InputStream is = null;
		try {
			File src = ((TakesScreenshot) DriverFactory.getDriver())
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("screenshots/page2.png"));
			is = Files.newInputStream(Paths.get("screenshots/page2.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

	/**
	 * The takewinScreenShot method is used to take screenshot of desktop applications and save it in a common location in framework
	 *
	 * @param -
	 * @return Inputstream
	 * @throws
	 * @see -
	 * @since 07-23-2019
	 * @version 1.0
	 *
	 */
	public static InputStream takewinScreenShot() {
		InputStream is = null;
		try {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRectangle = new Rectangle(screenSize);
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(screenRectangle);
			ImageIO.write(image, "png", new File("screenshots/page2.png"));
			is = Files.newInputStream(Paths.get("screenshots/page2.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

	/**
	 * The updateTestHistoryId method is used to report as different test cases in Allure report, in case we execute
	 * multiple examples of scenario outline
	 * This is a work around for an allure report with TestnG while running multiple examples to split up each as cases
	 *
	 * @param -
	 * @return
	 * @throws
	 * @see -
	 * @since 08-28-2019
	 * @version 1.4
	 *
	 */
	public static void updateTestHistoryId(){

		AllureLifecycle lifecycle = Allure.getLifecycle();
		Allure.setLifecycle(lifecycle);
		lifecycle.updateTestCase(testResult ->
	    {
			Date date = new Date();
	    	testResult.setHistoryId(testResult.getTestCaseId() +" "+ testResult.getFullName() +" "+ testResult.getParameters());
	    	testResult.setName(testResult.getName() +":"+testResult.getParameters().get(1).getValue() + " - " + sdf.format(date));
	    	testResult.getParameters().clear();

	    });
	}

	public static void updateErrorDetailsToReport(String message, String exception) {
		try {
			RunLog.error(message + "::::" + exception);
			Allure.description(message + "\n more details : failed Reason - " + exception);
			Assert.fail(message + "\n" + exception);

		} catch (Exception e) {
			RunLog.error("The error logging updateErrorDetailsToReport method failed");
		}
	}


	/**
	 * The updateErrorDetailsToReport method is used to report as error description in Allure report with auto screenshots,
	 * it also assert fails with the corresponding conditions and add error logs
	 *
	 * @param - String method name
	 * @param - String message
	 * @param - String exception
	 */
	public static void updateErrorDetailsToReport(String message, String methodName, String exception) {
		try {
			RunLog.error(methodName + "::::" + message + "::::" + exception);
			Allure.description(message + "\n more details : failed in method" + methodName + ":::" + exception);
			Assert.fail(message + "\n" + exception);
		} catch (Exception e) {
			RunLog.error("The error logging updateErrorDetailsToReport method failed");
		}
	}

	public static List<String> read_image(){
			List<String> image_text_list = new ArrayList<>();
			String input_file = "C:\\Tools\\Automation\\bddFramework\\screenshots\\page2.png";
			String output_file = "screenshots/screenshotsText";
			String tesseract_install_path = "C:\\Program Files (x86)\\Tesseract-OC\\tesseract.exe";
			Runtime rt = Runtime.getRuntime();
			Process proc = null;
			try
			{
			proc = rt.exec("C:\\Program Files (x86)\\Tesseract-OCR\\tesseract.exe C:\\Tools\\Automation\\bddFramework\\screenshots\\page2.png screenshots/screenshotsText");
			Thread.sleep(2000);
			proc.destroyForcibly();
			image_text_list =read_a_file(output_file+".txt");
			//System.out.println(image_text_list);
		} catch (Exception e) {
			e.printStackTrace();
			proc.destroyForcibly();
		}
		return image_text_list;
	}

	public static List<String> read_image_cmd()
	{
		List<String> image_text_list = new ArrayList<>();
		String input_file="C:\\Tools\\Automation\\bddFramework\\screenshots\\page2.png";
		String output_file="screenshots/screenshotsText";
		String tesseract_install_path="C:\\Program Files (x86)\\Tesseract-OC\\tesseract.exe";
		String[] command =
				{
						"cmd",
				};
		Process p = null;
		try {
			p = Runtime.getRuntime().exec(command);
			new Thread(new SyncPipeReadingImage(p.getErrorStream(), System.err)).start();
			new Thread(new SyncPipeReadingImage(p.getInputStream(), System.out)).start();
			PrintWriter stdin = new PrintWriter(p.getOutputStream());
			stdin.println("\""+tesseract_install_path+"\" \""+input_file+"\" \""+output_file+"\" -l eng");
			stdin.close();
			p.waitFor();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			p.destroyForcibly();
			image_text_list =read_a_file(output_file+".txt");
			System.out.println(image_text_list);
		} catch (Exception e) {
			e.printStackTrace();
			p.destroyForcibly();
		}
		return image_text_list;
	}


	public static List<String> read_a_file(String file_name) {
		BufferedReader br = null;
		List<String> read_string = new ArrayList<>();
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(file_name));
			while ((sCurrentLine = br.readLine()) != null) {
				read_string.add(sCurrentLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return read_string;
	}


}
