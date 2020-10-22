//import org.junit.jupiter.api.Assertions.assertThrows
import collection.mutable.Stack
import org.scalatest.FlatSpec

class StackSpec extends FlatSpec {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    println(stack.elems)
    assertResult(List(2,1)) {
      stack.elems
    }
    assert(stack.pop() === 2)
    assert(stack.pop() === 1)

  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[String]
    assertThrows[NoSuchElementException] {
      emptyStack.pop()
    }
  }

  it should "throw java.lang.NumberFormatException if an empty stack is popped" in {
    val s = "foo"
    assertThrows[java.lang.NumberFormatException] {
      s.toInt
    }
  }

  it should " output an int of 5" in {
    val s = "5"
    val number = s.toInt
    assert(number === 5 )

  }


}