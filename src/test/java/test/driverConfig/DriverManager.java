package test.driverConfig;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import test.constants.Navegador;

import java.util.HashMap;
import java.util.Map;


public class DriverManager {

	private WebDriver driver;
	private DesiredCapabilities capabilities = new DesiredCapabilities();
	private String extensionDriver = "";

	private static final String USERNAME = System.getProperty("user", "defaultUser");

	private static final String AUTOMATE_KEY = System.getProperty("key", "defaultKey");

	protected void resolveDriver(Navegador nav, String ambURL) {
		//  MetodosGenericos.setReporte(nav.toString());
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("\nSistema operativo ->" + System.getProperty("os.name").toLowerCase() + " " +System.getProperty("os.version").toLowerCase() +"\n");
		if (!os.contains("mac"))
			this.extensionDriver = ".exe";
		System.out.println(nav);
		Map<String, Object> browserStackOptions = new HashMap<>();
		switch (nav) {
			case Chrome:
				System.out.println("Se selecciona Chrome");
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-dev-shm-usage");
				chromeOptions.addArguments("--no-sandbox");
				chromeOptions.addArguments("--disable-gpu");
				chromeOptions.addArguments("--remote-allow-origins=*");
				chromeOptions.addArguments("--ignore-ssl-errors=yes");
				this.driver = new ChromeDriver(chromeOptions);
				this.driver.manage().deleteAllCookies();
				this.driver.manage().window().maximize();
				this.driver.get(ambURL);
				break;
			case Firefox:
				System.out.println("Se selecciona Firefox");
				WebDriverManager.firefoxdriver().setup();
				this.driver = (WebDriver) new FirefoxDriver();
				this.capabilities.setBrowserName("Firefox");
				this.driver.manage().window().maximize();
				this.driver.get(ambURL);
				break;
			case Edge:
				System.out.println("Se selecciona Edge");
				EdgeOptions edgeOptions = new EdgeOptions();
				WebDriverManager.edgedriver().setup();
				edgeOptions.addArguments("--remote-allow-origins=*");
				this.driver = new EdgeDriver(edgeOptions);
				this.driver.manage().deleteAllCookies();
				break;
			case Safari:
				System.out.println("Se selecciona Safari");
				WebDriverManager.safaridriver().setup();
				this.driver = (WebDriver) new SafariDriver();
				this.capabilities.setBrowserName("Safari");
				this.driver.manage().window().maximize();
				this.driver.get(ambURL);
				break;

			default:
				System.out.println("No es posible lanzar el navegador, no se reconoce el navegador: " + nav);
				break;
		}
		this.driver.manage().window().maximize();
		this.driver.get(ambURL);

	}


	protected WebDriver getDriver() {
		if (driver == null) {
			return driver;
		} else {
			return driver;
		}
	}


}
