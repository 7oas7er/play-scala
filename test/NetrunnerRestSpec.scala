import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.test.FakeRequest
import play.api.test.Helpers._

import scala.util.matching.Regex

class NetrunnerRestSpec extends PlaySpec with GuiceOneAppPerSuite {

  def listOfIDRegex(count: Int): Regex = {
    ("""(\d{1,3},){""" + (count-1) + """}\d{1,3}""").r
  }

  "/netrunner/rest/cards" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/cards")).get) mustBe OK
    }
  }

  "/netrunner/rest/cards" should {
    "send html" in {
      contentType(route(app, FakeRequest(GET, "/netrunner/rest/cards")).get) mustBe Some("application/json")
    }
  }

  "/netrunner/rest/cards" should {
    "return the cards" in {
      contentAsJson(route(app, FakeRequest(GET, "/netrunner/rest/cards")).get).toString() must include ("Executive File Clerk")
    }
  }

  "/netrunner/rest/cards" should {
    "generates the list of 580 IDs" in {
      val body = contentAsJson(route(app, FakeRequest(GET, "/netrunner/rest/cards")).get).toString()
      assert(listOfIDRegex(580).findFirstIn(body) != None, "The list of IDs has not been found.")
    }
  }

  "/netrunner/rest/cards/ids" should {
    "return 404" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/cards/ids")).get) mustBe NOT_FOUND
    }
  }

  "/netrunner/rest/cards/ids/7" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/cards/ids/7")).get) mustBe OK
    }
  }

  "/netrunner/rest/cards/ids/7," should {
    "return 404" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/cards/ids/7,")).get) mustBe NOT_FOUND
    }
  }

  "/netrunner/rest/cards/ids/7,8" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/cards/ids/7,8")).get) mustBe OK
    }
  }

  "/netrunner/rest/cards/ids/77,88" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/cards/ids/77,88")).get) mustBe OK
    }
  }

  "/netrunner/rest/cards/ids/123,231" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/cards/ids/123,231")).get) mustBe OK
    }
  }

  "/netrunner/rest/cards/ids/1234,1234" should {
    "return 404" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/cards/ids/1234,1234")).get) mustBe NOT_FOUND
    }
  }

  "/netrunner/rest/cards/ids/a,b" should {
    "return 404" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/cards/ids/a,b")).get) mustBe NOT_FOUND
    }
  }

  "/netrunner/rest/cards/ids/1,2,3,4" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/cards/ids/1,2,3,4")).get) mustBe OK
    }
  }

  "/netrunner/rest/cards/ids/1,2,3,4" should {
    "generates 4 IDs" in {
      val body = contentAsJson(route(app, FakeRequest(GET, "/netrunner/rest/cards/ids/1,2,3,4")).get).toString()
      assert(listOfIDRegex(4).findFirstIn(body) != None, "The list of IDs has not been found.")
    }
  }

  "/netrunner/rest/card/77" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/card/77")).get) mustBe OK
    }
  }

  "/netrunner/rest/card/77" should {
    "send html" in {
      contentType(route(app, FakeRequest(GET, "/netrunner/rest/card/77")).get) mustBe Some("application/json")
    }
  }

  "/netrunner/rest/card/77" should {
    "return the card Nevinnyrral with ID 77" in {
      contentAsJson(route(app, FakeRequest(GET, "/netrunner/rest/card/77")).get).toString() must include ("Nevinyrral")
    }
  }

  "/netrunner/rest/card/4711" should {
    "return 404" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/card/4711")).get) mustBe NOT_FOUND
    }
  }

  "/netrunner/rest/starter/runner" should {
    "generates only ID 77" in {
      val body = contentAsJson(route(app, FakeRequest(GET, "/netrunner/rest/starter/runner")).get).toString()
      assert(listOfIDRegex(1).findFirstIn(body) != None, "The list of IDs has not been found.")
    }
  }


  "/netrunner/rest/starter/runner" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/starter/runner")).get) mustBe OK
    }
  }

  "/netrunner/rest/starter/runner" should {
    "send html" in {
      contentType(route(app, FakeRequest(GET, "/netrunner/rest/starter/runner")).get) mustBe Some("application/json")
    }
  }

  "/netrunner/rest/starter/runner" should {
    "generates 60 IDs" in {
      val body = contentAsJson(route(app, FakeRequest(GET, "/netrunner/rest/starter/runner")).get).toString()
      assert(listOfIDRegex(60).findFirstIn(body) != None, "The list of IDs has not been found.")
    }
  }

  "/netrunner/rest/starter/corporation" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/starter/corporation")).get) mustBe OK
    }
  }

  "/netrunner/rest/starter/corporation" should {
    "send html" in {
      contentType(route(app, FakeRequest(GET, "/netrunner/rest/starter/corporation")).get) mustBe Some("application/json")
    }
  }

  "/netrunner/rest/starter/corporation" should {
    "generates 60 IDs" in {
      val body = contentAsJson(route(app, FakeRequest(GET, "/netrunner/rest/starter/corporation")).get).toString()
      assert(listOfIDRegex(60).findFirstIn(body) != None, "The list of IDs has not been found.")
    }
  }

  "/netrunner/rest/booster/limited" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/booster/limited")).get) mustBe OK
    }
  }

  "/netrunner/rest/booster/limited" should {
    "send html" in {
      contentType(route(app, FakeRequest(GET, "/netrunner/rest/booster/limited")).get) mustBe Some("application/json")
    }
  }

  "/netrunner/rest/booster/limited" should {
    "generates 15 IDs" in {
      val body = contentAsJson(route(app, FakeRequest(GET, "/netrunner/rest/booster/limited")).get).toString()
      assert(listOfIDRegex(15).findFirstIn(body) != None, "The list of IDs has not been found.")
    }
  }

  "/netrunner/rest/booster/proteus" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/booster/proteus")).get) mustBe OK
    }
  }

  "/netrunner/rest/booster/proteus" should {
    "send html" in {
      contentType(route(app, FakeRequest(GET, "/netrunner/rest/booster/proteus")).get) mustBe Some("application/json")
    }
  }

  "/netrunner/rest/booster/proteus" should {
    "generates 15 IDs" in {
      val body = contentAsJson(route(app, FakeRequest(GET, "/netrunner/rest/booster/proteus")).get).toString()
      assert(listOfIDRegex(15).findFirstIn(body) != None, "The list of IDs has not been found.")
    }
  }

  "/netrunner/rest/booster/classic" should {
    "return 200" in {
      status(route(app, FakeRequest(GET, "/netrunner/rest/booster/classic")).get) mustBe OK
    }
  }

  "/netrunner/rest/booster/classic" should {
    "send html" in {
      contentType(route(app, FakeRequest(GET, "/netrunner/rest/booster/classic")).get) mustBe Some("application/json")
    }
  }

  "/netrunner/rest/booster/classic" should {
    "generates 8 IDs" in {
      val body = contentAsJson(route(app, FakeRequest(GET, "/netrunner/rest/booster/classic")).get).toString()
      assert(listOfIDRegex(8).findFirstIn(body) != None, "The list of IDs has not been found.")
    }
  }

}
