package com.synergyj.ejemplo6

import geb.Page

// Definición de la página de Login
class LoginPage extends Page {
  static at = { title.endsWith("Login") }
  static content = {
    username { $("#username") }
    password { $("#password") }
    loginSubmit { $("#loginSubmit") }
  }
}