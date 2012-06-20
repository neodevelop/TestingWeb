package com.synergyj.ejemplo6

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
