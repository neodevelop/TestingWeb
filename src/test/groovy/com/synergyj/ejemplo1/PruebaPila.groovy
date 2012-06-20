package com.synergyj.ejemplo1

class NonEmptyPilaSimpleTest extends GroovyTestCase {
  private stack

  void setUp() {
    stack = new PilaSimple()
    [ "a", "b", "c" ].each{ x -> stack.push x }
  }

  void testPreConditions() {
    assert !stack.isEmpty()
  }

  void testShouldAddToTheTopWhenSentPush() {
    stack.push "d"
    assert stack.peek() == "d"
  }

  void testShouldBeUnchangedWhenSentPushThenPop() {
    stack.push "anything"
    stack.pop()
    assert stack.peek() == "c"
  }

  void testShouldReturnTheTopItemWhenSentPeek() {
    assert stack.peek() == "c"
  }

  void testShouldNotRemoveTheTopItemWhenSentPeek() {
    assert stack.peek() == "c"
    assert stack.peek() == "c"
  }

  void testShouldReturnTheTopItemWhenSentPop() {
    assert stack.pop() == "c"
  }

  void testShouldRemoveTheTopItemWhenSentPop() {
    assert stack.pop() == "c"
    assert stack.pop() == "b"
  }

}

class EmptyPilaSimpleTest extends GroovyTestCase {
  private stack = new PilaSimple()

  void testPreConditions() {
    assert stack.isEmpty()
  }

  void testShouldNoLongerBeEmptyAfterPush() {
    stack.push "anything"
    assert !stack.isEmpty()
  }

  void testShouldComplainWhenSentPeek() {
    shouldFail(RuntimeException) {
      stack.peek()
    }
  }

  void testShouldComplainWhenSentPop() {
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