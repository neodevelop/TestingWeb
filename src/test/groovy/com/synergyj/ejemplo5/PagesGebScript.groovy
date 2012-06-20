@Grapes([
@Grab("org.codehaus.geb:geb-core:0.7.0"),
@Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.23.1"),
@Grab("org.seleniumhq.selenium:selenium-support:2.23.1")
])
import geb.Browser
import geb.Page

// Definición de la página de inicio
class HomePage extends Page{
  // Está sera la URL a la que se llamará cuando se invoque esta clase
  static url = "http://entrenamiento.synergyj.com"
  // Checkers
  static at = { title == "SynergyJ - Grain Home" }
  // Definición del contenido que podrá usarse para la navegación
  static content = {
    menuLinks { $("#nav ul li a") } // Selectores de jQuery y CSS
    menuOption { i -> menuLinks[i] } // Un closure que recibe 'i' para obtener una posición del arreglo menuLinks
  }
}

// Definición de la página de Login
class LoginPage extends Page {
  static at = { title.endsWith("Login") }
  static content = {
    username { $("#username") }
    password { $("#password") }
    loginSubmit { $("#loginSubmit") }
  }
}

Browser.drive {
  to HomePage
  assert at(HomePage)
  assert menuOption(3).text() ==~ /Login/
  menuOption(3).click()
  waitFor { at LoginPage }
  assert at(LoginPage)
  username.value("user@noexist.com")
  password.value("nopassword")
  loginSubmit.click()
  waitFor { at LoginPage }
  assert at(LoginPage)
}