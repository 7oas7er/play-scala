import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.test.FakeRequest
import play.api.test.Helpers._

import scala.util.matching.Regex

class NetrunnerSpec extends PlaySpec with GuiceOneAppPerSuite {

  def listOfIDRegex(count: Int): Regex = {
    ("""(\d{1,3},){""" + (count-1) + """}\d{1,3}""").r
  }

  "/netrunner" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner")).get) mustBe OK
    }
  }

  "/netrunner" should {
    "send html" in {
      contentType(route(app, FakeRequest(GET, "/netrunner")).get) mustBe Some("text/html")
    }
  }

  "/netrunner" should {
    "render the card list page" in {
      contentAsString(route(app, FakeRequest(GET, "/netrunner")).get) must include ("Executive File Clerk")
    }
  }

  "/netrunner/starter/runner" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/starter/runner")).get) mustBe OK
    }
  }

  "/netrunner/starter/runner" should {
    "send html" in {
      contentType(route(app, FakeRequest(GET, "/netrunner/starter/runner")).get) mustBe Some("text/html")
    }
  }

  "/netrunner/starter/runner" should {
    "generates 60 IDs" in {
      val body = contentAsString(route(app, FakeRequest(GET, "/netrunner/starter/runner")).get)
      assert(listOfIDRegex(60).findFirstIn(body) != None, "The list of IDs has not been found.")
    }
  }

  "/netrunner/starter/corporation" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/starter/corporation")).get) mustBe OK
    }
  }

  "/netrunner/starter/corporation" should {
    "send html" in {
      contentType(route(app, FakeRequest(GET, "/netrunner/starter/corporation")).get) mustBe Some("text/html")
    }
  }

  "/netrunner/starter/corporation" should {
    "generates 60 IDs" in {
      val body = contentAsString(route(app, FakeRequest(GET, "/netrunner/starter/corporation")).get)
      assert(listOfIDRegex(60).findFirstIn(body) != None, "The list of IDs has not been found.")
    }
  }

  "/netrunner/booster/limited" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/booster/limited")).get) mustBe OK
    }
  }

  "/netrunner/booster/limited" should {
    "send html" in {
      contentType(route(app, FakeRequest(GET, "/netrunner/booster/limited")).get) mustBe Some("text/html")
    }
  }

  "/netrunner/booster/limited" should {
    "generates 15 IDs" in {
      val body = contentAsString(route(app, FakeRequest(GET, "/netrunner/booster/limited")).get)
      assert(listOfIDRegex(15).findFirstIn(body) != None, "The list of IDs has not been found.")
    }
  }

  "/netrunner/booster/proteus" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/booster/proteus")).get) mustBe OK
    }
  }

  "/netrunner/booster/proteus" should {
    "send html" in {
      contentType(route(app, FakeRequest(GET, "/netrunner/booster/proteus")).get) mustBe Some("text/html")
    }
  }

  "/netrunner/booster/proteus" should {
    "generates 15 IDs" in {
      val body = contentAsString(route(app, FakeRequest(GET, "/netrunner/booster/proteus")).get)
      assert(listOfIDRegex(15).findFirstIn(body) != None, "The list of IDs has not been found.")
    }
  }

  "/netrunner/booster/classic" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/booster/classic")).get) mustBe OK
    }
  }

  "/netrunner/booster/classic" should {
    "send html" in {
      contentType(route(app, FakeRequest(GET, "/netrunner/booster/classic")).get) mustBe Some("text/html")
    }
  }

  "/netrunner/booster/classic" should {
    "generates 8 IDs" in {
      val body = contentAsString(route(app, FakeRequest(GET, "/netrunner/booster/classic")).get)
      assert(listOfIDRegex(8).findFirstIn(body) != None, "The list of IDs has not been found.")
    }
  }

}
