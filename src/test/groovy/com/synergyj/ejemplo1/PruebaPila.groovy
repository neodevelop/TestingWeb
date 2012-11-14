package com.synergyj.ejemplo1

// Clase groovy que hereda de GTC
class NonEmptyPilaSimpleTest extends GroovyTestCase {
  // Definiciuón de nuestro elemento a probar
  private stack

  // Al igual que en JUnit podemos contar con este método
  void setUp() {
    // Inicializació del elemento
    stack = new PilaSimple()
    // Agregamos 3 elementos a la pila
    [ "a", "b", "c" ].each{ x -> stack.push x }
  }

  // Los métodos de prueba inician con la palabra 'test'
  void testPreCondiciones() {
    // La pila no esta vacia
    assert !stack.isEmpty()
  }

  void testPushAndPeek() {
    // Agregamos un elemeneto
    stack.push "d"
    // Observamos el último elemento agregado
    assert stack.peek() == "d"
  }

  void testPushPopAndPeek() {
    // Introducimos un elemento
    stack.push "anything"
    // Sacamos el elemento
    stack.pop()
    // Observamos el elemento en el tope de la pila
    assert stack.peek() == "c"
  }

}

class EmptyPilaSimpleTest extends GroovyTestCase {
  // Definición de la pila
  private stack = new PilaSimple()

  // La pila esta vacía
  void testPreConditions() {
    assert stack.isEmpty()
  }

  // Como la pila esta vacía esto arroja excepcion
  void testPeekWithEmptyStack() {
    // Uso de shouldFail, para que tega exito debe arrojar excepción
    shouldFail(RuntimeException) {
      stack.peek()
    }
  }

  void testPopWithEmptyStack() {
    shouldFail(RuntimeException) {
      stack.pop()
    }
  }
}

class FullPilaSimpleTest extends GroovyTestCase {
  private stack

  void setUp() {
    stack = new PilaSimple()
    (1..PilaSimple.MAXSIZE).each{ x -> stack.push x }
  }

  void testPreConditions() {
    assert stack.isFull()
  }

  void testShouldRemainFullAfterPeek() {
    stack.peek()
    assert stack.isFull()
  }

  void testShouldNoLongerBeFullAfterPop() {
    stack.pop()
    assert !stack.isFull()
  }

  void testShouldComplainOnPush() {
    shouldFail(RuntimeException) {
      stack.push "anything"
    }
  }
}

class AlmostFullPilaSimpleTest extends GroovyTestCase {
  private stack

  void setUp() {
    stack = new PilaSimple()
    (1..<PilaSimple.MAXSIZE).each{ x -> stack.push x }
  }

  void testPreConditions() {
    assert !stack.isFull()
  }

  void testShouldBecomeFullAfterPush() {
    stack.push "anything"
    assert stack.isFull()
  }
}

class AlmostEmptyPilaSimpleTest extends GroovyTestCase {
  private stack

  void setUp() {
    stack = new PilaSimple()
    stack.push "anything"
  }

  void testPreConditions() {
    assert !stack.isEmpty()
  }

  void testShouldRemainNotEmptyAfterPeek() {
    stack.peek()
    testPreConditions()
  }

  void testShouldBecomeEmptyAfterPop() {
    stack.pop()
    assert stack.isEmpty()
  }
}