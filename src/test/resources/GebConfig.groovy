

import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver

driver = {
	//def driver = new HtmlUnitDriver()
  //def driver = new ChromeDriver()
  def driver = new FirefoxDriver()
	//driver.javascriptEnabled = true
	driver
}

waiting {
	timeout = 5
}

environments {
	chrome {
		driver = { new ChromeDriver() }
	}
	firefox {
		driver = { new FirefoxDriver() }
	}
}