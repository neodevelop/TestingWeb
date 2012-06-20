@Grapes([
  @Grab("org.codehaus.geb:geb-core:0.7.0"),
  @Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.23.1"),
  @Grab("org.seleniumhq.selenium:selenium-support:2.23.1")
])
import geb.Browser

Browser.drive {
  go "http://entrenamiento.synergyj.com/signup"

  assert title == "SynergyJ - Grain"

  $("form#registerForm").with {
    email = "novalid"
    password = "passwd"
    confirmPassword = "different"
    def submitButton = $("input[type=submit]")
    Thread.sleep(3000) // Una simple pausa
    submitButton.click()
  }

  assert title == "SynergyJ - Grain"

  Thread.sleep(5000) // Una simple pausa
}