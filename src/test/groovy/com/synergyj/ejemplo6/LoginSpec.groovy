package com.synergyj.ejemplo6

import geb.spock.GebSpec

class LoginSpec extends GebSpec {
  
  def "presentar la página de inicio"(){
    when: "Abrimos el navegador y visitamos main"
      to HomePage
    then: "Corroboramos estar en main"
      at HomePage
    expect: "El vínculo de login"
      assert menuOption(3).text() ==~ /Login/
  }

  def "validación de login con datos erroneos"(){
    setup: "Siempre comenzamos desde el Home"
      to HomePage
    when: "Esperamos a que cargue y presionamos Login"
      waitFor { at HomePage  }
      menuOption(3).click()
    then: "Esperamos la página de login"
      waitFor { at LoginPage }
    when: "Introducimos valores erroneos para Login y contraseña"
      username.value(usernameTest)
      password.value(passwordTest)
    and: "Enviamos la forma de login"
      loginSubmit.click()
    then: "Usuario y contraseñas incorrectos"
      waitFor { at LoginPage }
    expect: "Validamos que efectivamente es la página de Login"
      assert at(LoginPage)
    where:
      usernameTest    |   passwordTest
      "nouser"        |   "nopassword"
      "nouser2@mail"  |   "otropass"
  }

}
