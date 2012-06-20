package com.synergyj.ejemplo2

import org.junit.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.safari.SafariDriver
import org.junit.Ignore
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor

class SimpleWebTest {

  // Probando una navegación simple
  @Test
  public void testHtmlDriver(){
    WebDriver driver = new HtmlUnitDriver()
    driver.get("http://entrenamiento.synergyj.com/")
    assert "SynergyJ - Grain Home" == driver.title
  }

  @Test
  public void testFirefoxDriver(){
    WebDriver driver = new FirefoxDriver()
    driver.get("http://entrenamiento.synergyj.com/")
    assert "SynergyJ - Grain Home" == driver.title
    // Seleccionando todos los elementos2
    List<WebElement> elementos =  driver.findElementsByCssSelector("*")
    elementos.each{ e ->
      println e.properties
    }
  }

  @Test
  public void testChromeDriver(){
    WebDriver driver = new ChromeDriver()
    driver.get("http://entrenamiento.synergyj.com/")
    assert "SynergyJ - Grain Home" == driver.title
    // Buscando con Javascript
    WebElement element = (WebElement) ((JavascriptExecutor)driver).executeScript("return \$('div#nav ul li a')[1]")
    assert element.text == 'Calendar'
    // Haciendo click a un elemento
    element.click()
  }

  //@Test
  //@Ignore
  /*public void _testSafariDriver(){
    WebDriver driver = new SafariDriver()
    driver.get("http://entrenamiento.synergyj.com/")
    assert "SynergyJ - Grain Home" == driver.title
  }*/
}
