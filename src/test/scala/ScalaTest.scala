import org.scalatest.FunSuite
import com.ci.Person

class ScalaTest extends FunSuite {

  test("the name is set correctly in constructor") {
    val p = Person("Barney Rubble")
    assert(p.name == "Barney Rubble")
  }

  test("a Person's name can be changed") {
    val p = Person("Chad Johnson")
    p.name = "Ochocinco"
    assert(p.name == "Ochocinco")
  }

}
