package com.synergyj.ejemplo1

// Definición de la clase pila
class PilaSimple {
  static MAXSIZE = 10 // Número máximo de elementos para la pila
  private items = [] // Almacenamietno de la pila

  // Método que coloca un elemento en la pila
  def push(object) {
    // Si superamos el tamaño de la pila entonces arrojamos error
    if (items.size() == MAXSIZE) throw new RuntimeException("Pila llena")
    // En caso contrario solo agregamos el elemento
    items << object
  }

  // Método que saca el elemento de la pila
  def pop() {
    // Si no hay objetos en la pila entonces arrojamos error
    if (!items) throw new RuntimeException("La pila está vacía")
    // Quitamos el ultimo elemento de la pila
    items.pop()
  }

  // Observamos cual es el ultimo elemento insertado sin quitarlo
  def peek() {
    if (!items) throw new RuntimeException("La pila está vacía")
    // Uso de azúcar sintáctica de Groovy
    items[-1]
  }

  // Método que determina si la pila esta vacía
  boolean isEmpty() {
    items.isEmpty()
  }

  // Método que determina si la pila esta llena
  boolean isFull() {
    items.size() == MAXSIZE
  }
}
