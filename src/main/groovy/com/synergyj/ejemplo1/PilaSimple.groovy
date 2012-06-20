package com.synergyj.ejemplo1

class PilaSimple {
  static MAXSIZE = 10
  private items = []

  def push(object) {
    if (items.size() == MAXSIZE) throw new RuntimeException("Pila llena")
    items << object
  }

  def pop() {
    if (!items) throw new RuntimeException("La pila está vacía")
    items.pop()
  }

  def peek() {
    if (!items) throw new RuntimeException("La pila está vacía")
    items[-1]
  }

  boolean isEmpty() {
    items.isEmpty()
  }

  boolean isFull() {
    items.size() == MAXSIZE
  }
}
