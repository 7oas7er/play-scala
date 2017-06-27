
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/fschlesinger/Qsync/professional/workspace/netrunner/conf/routes
// @DATE:Mon Jun 26 11:07:56 CEST 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  NetrunnerController_3: controllers.NetrunnerController,
  // @LINE:9
  Assets_4: controllers.Assets,
  // @LINE:12
  ImprintController_2: controllers.ImprintController,
  // @LINE:60
  NetrunnerRestController_0: controllers.NetrunnerRestController,
  // @LINE:98
  UserController_1: controllers.UserController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    NetrunnerController_3: controllers.NetrunnerController,
    // @LINE:9
    Assets_4: controllers.Assets,
    // @LINE:12
    ImprintController_2: controllers.ImprintController,
    // @LINE:60
    NetrunnerRestController_0: controllers.NetrunnerRestController,
    // @LINE:98
    UserController_1: controllers.UserController
  ) = this(errorHandler, NetrunnerController_3, Assets_4, ImprintController_2, NetrunnerRestController_0, UserController_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, NetrunnerController_3, Assets_4, ImprintController_2, NetrunnerRestController_0, UserController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.NetrunnerController.cards"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """imprint""", """controllers.ImprintController.getImprint"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """imprint/""", """controllers.ImprintController.getImprint"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner""", """controllers.NetrunnerController.cards"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/""", """controllers.NetrunnerController.cards"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/starter/runner""", """controllers.NetrunnerController.starterRunner"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/starter/runner/""", """controllers.NetrunnerController.starterRunner"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/starter/corporation""", """controllers.NetrunnerController.starterCorporation"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/starter/corporation/""", """controllers.NetrunnerController.starterCorporation"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/booster/limited""", """controllers.NetrunnerController.boosterLimited"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/booster/limited/""", """controllers.NetrunnerController.boosterLimited"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/booster/proteus""", """controllers.NetrunnerController.boosterProteus"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/booster/proteus/""", """controllers.NetrunnerController.boosterProteus"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/booster/classic""", """controllers.NetrunnerController.boosterClassic"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/booster/classic/""", """controllers.NetrunnerController.boosterClassic"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/rest/card/""" + "$" + """id<[0-9]+>""", """controllers.NetrunnerRestController.card(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/rest/cards""", """controllers.NetrunnerRestController.allCards"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/rest/cards/ids/""" + "$" + """idList<(\d{1,3},)*\d{1,3}>""", """controllers.NetrunnerRestController.cards(idList:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/rest/starter/runner""", """controllers.NetrunnerRestController.starterRunner"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/rest/starter/runner/""", """controllers.NetrunnerRestController.starterRunner"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/rest/starter/corporation""", """controllers.NetrunnerRestController.starterCorporation"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/rest/starter/corporation/""", """controllers.NetrunnerRestController.starterCorporation"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/rest/booster/limited""", """controllers.NetrunnerRestController.boosterLimited"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/rest/booster/limited/""", """controllers.NetrunnerRestController.boosterLimited"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/rest/booster/proteus""", """controllers.NetrunnerRestController.boosterProteus"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/rest/booster/proteus/""", """controllers.NetrunnerRestController.boosterProteus"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/rest/booster/classic""", """controllers.NetrunnerRestController.boosterClassic"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """netrunner/rest/booster/classic/""", """controllers.NetrunnerRestController.boosterClassic"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/add""", """controllers.UserController.addUser"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/delete/""" + "$" + """id<[^/]+>""", """controllers.UserController.deleteUser(id:Long)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_NetrunnerController_cards0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_NetrunnerController_cards0_invoker = createInvoker(
    NetrunnerController_3.cards,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerController",
      "cards",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_ImprintController_getImprint2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("imprint")))
  )
  private[this] lazy val controllers_ImprintController_getImprint2_invoker = createInvoker(
    ImprintController_2.getImprint,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ImprintController",
      "getImprint",
      Nil,
      "GET",
      """ Renders the imprint""",
      this.prefix + """imprint"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_ImprintController_getImprint3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("imprint/")))
  )
  private[this] lazy val controllers_ImprintController_getImprint3_invoker = createInvoker(
    ImprintController_2.getImprint,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ImprintController",
      "getImprint",
      Nil,
      "GET",
      """ Renders the imprint""",
      this.prefix + """imprint/"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_NetrunnerController_cards4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner")))
  )
  private[this] lazy val controllers_NetrunnerController_cards4_invoker = createInvoker(
    NetrunnerController_3.cards,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerController",
      "cards",
      Nil,
      "GET",
      """ A page where later the NetRunner deck builder should run""",
      this.prefix + """netrunner"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_NetrunnerController_cards5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/")))
  )
  private[this] lazy val controllers_NetrunnerController_cards5_invoker = createInvoker(
    NetrunnerController_3.cards,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerController",
      "cards",
      Nil,
      "GET",
      """ A page where later the NetRunner deck builder should run""",
      this.prefix + """netrunner/"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_NetrunnerController_starterRunner6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/starter/runner")))
  )
  private[this] lazy val controllers_NetrunnerController_starterRunner6_invoker = createInvoker(
    NetrunnerController_3.starterRunner,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerController",
      "starterRunner",
      Nil,
      "GET",
      """ Renders a random generated starter deck""",
      this.prefix + """netrunner/starter/runner"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_NetrunnerController_starterRunner7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/starter/runner/")))
  )
  private[this] lazy val controllers_NetrunnerController_starterRunner7_invoker = createInvoker(
    NetrunnerController_3.starterRunner,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerController",
      "starterRunner",
      Nil,
      "GET",
      """ Renders a random generated starter deck""",
      this.prefix + """netrunner/starter/runner/"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_NetrunnerController_starterCorporation8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/starter/corporation")))
  )
  private[this] lazy val controllers_NetrunnerController_starterCorporation8_invoker = createInvoker(
    NetrunnerController_3.starterCorporation,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerController",
      "starterCorporation",
      Nil,
      "GET",
      """ Renders a random generated starter deck""",
      this.prefix + """netrunner/starter/corporation"""
    )
  )

  // @LINE:34
  private[this] lazy val controllers_NetrunnerController_starterCorporation9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/starter/corporation/")))
  )
  private[this] lazy val controllers_NetrunnerController_starterCorporation9_invoker = createInvoker(
    NetrunnerController_3.starterCorporation,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerController",
      "starterCorporation",
      Nil,
      "GET",
      """ Renders a random generated starter deck""",
      this.prefix + """netrunner/starter/corporation/"""
    )
  )

  // @LINE:37
  private[this] lazy val controllers_NetrunnerController_boosterLimited10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/booster/limited")))
  )
  private[this] lazy val controllers_NetrunnerController_boosterLimited10_invoker = createInvoker(
    NetrunnerController_3.boosterLimited,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerController",
      "boosterLimited",
      Nil,
      "GET",
      """ Renders a random generated limited booster""",
      this.prefix + """netrunner/booster/limited"""
    )
  )

  // @LINE:40
  private[this] lazy val controllers_NetrunnerController_boosterLimited11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/booster/limited/")))
  )
  private[this] lazy val controllers_NetrunnerController_boosterLimited11_invoker = createInvoker(
    NetrunnerController_3.boosterLimited,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerController",
      "boosterLimited",
      Nil,
      "GET",
      """ Renders a random generated limited booster""",
      this.prefix + """netrunner/booster/limited/"""
    )
  )

  // @LINE:43
  private[this] lazy val controllers_NetrunnerController_boosterProteus12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/booster/proteus")))
  )
  private[this] lazy val controllers_NetrunnerController_boosterProteus12_invoker = createInvoker(
    NetrunnerController_3.boosterProteus,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerController",
      "boosterProteus",
      Nil,
      "GET",
      """ Renders a random generated proteus booster""",
      this.prefix + """netrunner/booster/proteus"""
    )
  )

  // @LINE:46
  private[this] lazy val controllers_NetrunnerController_boosterProteus13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/booster/proteus/")))
  )
  private[this] lazy val controllers_NetrunnerController_boosterProteus13_invoker = createInvoker(
    NetrunnerController_3.boosterProteus,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerController",
      "boosterProteus",
      Nil,
      "GET",
      """ Renders a random generated proteus booster""",
      this.prefix + """netrunner/booster/proteus/"""
    )
  )

  // @LINE:49
  private[this] lazy val controllers_NetrunnerController_boosterClassic14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/booster/classic")))
  )
  private[this] lazy val controllers_NetrunnerController_boosterClassic14_invoker = createInvoker(
    NetrunnerController_3.boosterClassic,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerController",
      "boosterClassic",
      Nil,
      "GET",
      """ Renders a random generated classic booster""",
      this.prefix + """netrunner/booster/classic"""
    )
  )

  // @LINE:52
  private[this] lazy val controllers_NetrunnerController_boosterClassic15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/booster/classic/")))
  )
  private[this] lazy val controllers_NetrunnerController_boosterClassic15_invoker = createInvoker(
    NetrunnerController_3.boosterClassic,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerController",
      "boosterClassic",
      Nil,
      "GET",
      """ Renders a random generated classic booster""",
      this.prefix + """netrunner/booster/classic/"""
    )
  )

  // @LINE:60
  private[this] lazy val controllers_NetrunnerRestController_card16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/rest/card/"), DynamicPart("id", """[0-9]+""",false)))
  )
  private[this] lazy val controllers_NetrunnerRestController_card16_invoker = createInvoker(
    NetrunnerRestController_0.card(fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerRestController",
      "card",
      Seq(classOf[Int]),
      "GET",
      """ A Json containing the cards with the given ID""",
      this.prefix + """netrunner/rest/card/""" + "$" + """id<[0-9]+>"""
    )
  )

  // @LINE:63
  private[this] lazy val controllers_NetrunnerRestController_allCards17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/rest/cards")))
  )
  private[this] lazy val controllers_NetrunnerRestController_allCards17_invoker = createInvoker(
    NetrunnerRestController_0.allCards,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerRestController",
      "allCards",
      Nil,
      "GET",
      """ A Json containing all cards""",
      this.prefix + """netrunner/rest/cards"""
    )
  )

  // @LINE:66
  private[this] lazy val controllers_NetrunnerRestController_cards18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/rest/cards/ids/"), DynamicPart("idList", """(\d{1,3},)*\d{1,3}""",false)))
  )
  private[this] lazy val controllers_NetrunnerRestController_cards18_invoker = createInvoker(
    NetrunnerRestController_0.cards(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerRestController",
      "cards",
      Seq(classOf[String]),
      "GET",
      """ A Json containing all cards""",
      this.prefix + """netrunner/rest/cards/ids/""" + "$" + """idList<(\d{1,3},)*\d{1,3}>"""
    )
  )

  // @LINE:69
  private[this] lazy val controllers_NetrunnerRestController_starterRunner19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/rest/starter/runner")))
  )
  private[this] lazy val controllers_NetrunnerRestController_starterRunner19_invoker = createInvoker(
    NetrunnerRestController_0.starterRunner,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerRestController",
      "starterRunner",
      Nil,
      "GET",
      """ A Json containing a random generated starter deck""",
      this.prefix + """netrunner/rest/starter/runner"""
    )
  )

  // @LINE:72
  private[this] lazy val controllers_NetrunnerRestController_starterRunner20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/rest/starter/runner/")))
  )
  private[this] lazy val controllers_NetrunnerRestController_starterRunner20_invoker = createInvoker(
    NetrunnerRestController_0.starterRunner,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerRestController",
      "starterRunner",
      Nil,
      "GET",
      """ A Json containing a random generated starter deck""",
      this.prefix + """netrunner/rest/starter/runner/"""
    )
  )

  // @LINE:75
  private[this] lazy val controllers_NetrunnerRestController_starterCorporation21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/rest/starter/corporation")))
  )
  private[this] lazy val controllers_NetrunnerRestController_starterCorporation21_invoker = createInvoker(
    NetrunnerRestController_0.starterCorporation,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerRestController",
      "starterCorporation",
      Nil,
      "GET",
      """ A Json containing a random generated starter deck""",
      this.prefix + """netrunner/rest/starter/corporation"""
    )
  )

  // @LINE:78
  private[this] lazy val controllers_NetrunnerRestController_starterCorporation22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/rest/starter/corporation/")))
  )
  private[this] lazy val controllers_NetrunnerRestController_starterCorporation22_invoker = createInvoker(
    NetrunnerRestController_0.starterCorporation,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerRestController",
      "starterCorporation",
      Nil,
      "GET",
      """ A Json containing a random generated starter deck""",
      this.prefix + """netrunner/rest/starter/corporation/"""
    )
  )

  // @LINE:81
  private[this] lazy val controllers_NetrunnerRestController_boosterLimited23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/rest/booster/limited")))
  )
  private[this] lazy val controllers_NetrunnerRestController_boosterLimited23_invoker = createInvoker(
    NetrunnerRestController_0.boosterLimited,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerRestController",
      "boosterLimited",
      Nil,
      "GET",
      """ A Json containing a random generated limited booster""",
      this.prefix + """netrunner/rest/booster/limited"""
    )
  )

  // @LINE:84
  private[this] lazy val controllers_NetrunnerRestController_boosterLimited24_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/rest/booster/limited/")))
  )
  private[this] lazy val controllers_NetrunnerRestController_boosterLimited24_invoker = createInvoker(
    NetrunnerRestController_0.boosterLimited,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerRestController",
      "boosterLimited",
      Nil,
      "GET",
      """ A Json containing a random generated limited booster""",
      this.prefix + """netrunner/rest/booster/limited/"""
    )
  )

  // @LINE:87
  private[this] lazy val controllers_NetrunnerRestController_boosterProteus25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/rest/booster/proteus")))
  )
  private[this] lazy val controllers_NetrunnerRestController_boosterProteus25_invoker = createInvoker(
    NetrunnerRestController_0.boosterProteus,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerRestController",
      "boosterProteus",
      Nil,
      "GET",
      """ A Json containing a random generated proteus booster""",
      this.prefix + """netrunner/rest/booster/proteus"""
    )
  )

  // @LINE:90
  private[this] lazy val controllers_NetrunnerRestController_boosterProteus26_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/rest/booster/proteus/")))
  )
  private[this] lazy val controllers_NetrunnerRestController_boosterProteus26_invoker = createInvoker(
    NetrunnerRestController_0.boosterProteus,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerRestController",
      "boosterProteus",
      Nil,
      "GET",
      """ A Json containing a random generated proteus booster""",
      this.prefix + """netrunner/rest/booster/proteus/"""
    )
  )

  // @LINE:93
  private[this] lazy val controllers_NetrunnerRestController_boosterClassic27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/rest/booster/classic")))
  )
  private[this] lazy val controllers_NetrunnerRestController_boosterClassic27_invoker = createInvoker(
    NetrunnerRestController_0.boosterClassic,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerRestController",
      "boosterClassic",
      Nil,
      "GET",
      """ A Json containing a random generated classic booster""",
      this.prefix + """netrunner/rest/booster/classic"""
    )
  )

  // @LINE:96
  private[this] lazy val controllers_NetrunnerRestController_boosterClassic28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("netrunner/rest/booster/classic/")))
  )
  private[this] lazy val controllers_NetrunnerRestController_boosterClassic28_invoker = createInvoker(
    NetrunnerRestController_0.boosterClassic,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NetrunnerRestController",
      "boosterClassic",
      Nil,
      "GET",
      """ A Json containing a random generated classic booster""",
      this.prefix + """netrunner/rest/booster/classic/"""
    )
  )

  // @LINE:98
  private[this] lazy val controllers_UserController_index29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UserController_index29_invoker = createInvoker(
    UserController_1.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """users"""
    )
  )

  // @LINE:99
  private[this] lazy val controllers_UserController_addUser30_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/add")))
  )
  private[this] lazy val controllers_UserController_addUser30_invoker = createInvoker(
    UserController_1.addUser,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "addUser",
      Nil,
      "POST",
      """""",
      this.prefix + """user/add"""
    )
  )

  // @LINE:100
  private[this] lazy val controllers_UserController_deleteUser31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_deleteUser31_invoker = createInvoker(
    UserController_1.deleteUser(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "deleteUser",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """user/delete/""" + "$" + """id<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_NetrunnerController_cards0_route(params) =>
      call { 
        controllers_NetrunnerController_cards0_invoker.call(NetrunnerController_3.cards)
      }
  
    // @LINE:9
    case controllers_Assets_versioned1_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_4.versioned(path, file))
      }
  
    // @LINE:12
    case controllers_ImprintController_getImprint2_route(params) =>
      call { 
        controllers_ImprintController_getImprint2_invoker.call(ImprintController_2.getImprint)
      }
  
    // @LINE:15
    case controllers_ImprintController_getImprint3_route(params) =>
      call { 
        controllers_ImprintController_getImprint3_invoker.call(ImprintController_2.getImprint)
      }
  
    // @LINE:19
    case controllers_NetrunnerController_cards4_route(params) =>
      call { 
        controllers_NetrunnerController_cards4_invoker.call(NetrunnerController_3.cards)
      }
  
    // @LINE:22
    case controllers_NetrunnerController_cards5_route(params) =>
      call { 
        controllers_NetrunnerController_cards5_invoker.call(NetrunnerController_3.cards)
      }
  
    // @LINE:25
    case controllers_NetrunnerController_starterRunner6_route(params) =>
      call { 
        controllers_NetrunnerController_starterRunner6_invoker.call(NetrunnerController_3.starterRunner)
      }
  
    // @LINE:28
    case controllers_NetrunnerController_starterRunner7_route(params) =>
      call { 
        controllers_NetrunnerController_starterRunner7_invoker.call(NetrunnerController_3.starterRunner)
      }
  
    // @LINE:31
    case controllers_NetrunnerController_starterCorporation8_route(params) =>
      call { 
        controllers_NetrunnerController_starterCorporation8_invoker.call(NetrunnerController_3.starterCorporation)
      }
  
    // @LINE:34
    case controllers_NetrunnerController_starterCorporation9_route(params) =>
      call { 
        controllers_NetrunnerController_starterCorporation9_invoker.call(NetrunnerController_3.starterCorporation)
      }
  
    // @LINE:37
    case controllers_NetrunnerController_boosterLimited10_route(params) =>
      call { 
        controllers_NetrunnerController_boosterLimited10_invoker.call(NetrunnerController_3.boosterLimited)
      }
  
    // @LINE:40
    case controllers_NetrunnerController_boosterLimited11_route(params) =>
      call { 
        controllers_NetrunnerController_boosterLimited11_invoker.call(NetrunnerController_3.boosterLimited)
      }
  
    // @LINE:43
    case controllers_NetrunnerController_boosterProteus12_route(params) =>
      call { 
        controllers_NetrunnerController_boosterProteus12_invoker.call(NetrunnerController_3.boosterProteus)
      }
  
    // @LINE:46
    case controllers_NetrunnerController_boosterProteus13_route(params) =>
      call { 
        controllers_NetrunnerController_boosterProteus13_invoker.call(NetrunnerController_3.boosterProteus)
      }
  
    // @LINE:49
    case controllers_NetrunnerController_boosterClassic14_route(params) =>
      call { 
        controllers_NetrunnerController_boosterClassic14_invoker.call(NetrunnerController_3.boosterClassic)
      }
  
    // @LINE:52
    case controllers_NetrunnerController_boosterClassic15_route(params) =>
      call { 
        controllers_NetrunnerController_boosterClassic15_invoker.call(NetrunnerController_3.boosterClassic)
      }
  
    // @LINE:60
    case controllers_NetrunnerRestController_card16_route(params) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_NetrunnerRestController_card16_invoker.call(NetrunnerRestController_0.card(id))
      }
  
    // @LINE:63
    case controllers_NetrunnerRestController_allCards17_route(params) =>
      call { 
        controllers_NetrunnerRestController_allCards17_invoker.call(NetrunnerRestController_0.allCards)
      }
  
    // @LINE:66
    case controllers_NetrunnerRestController_cards18_route(params) =>
      call(params.fromPath[String]("idList", None)) { (idList) =>
        controllers_NetrunnerRestController_cards18_invoker.call(NetrunnerRestController_0.cards(idList))
      }
  
    // @LINE:69
    case controllers_NetrunnerRestController_starterRunner19_route(params) =>
      call { 
        controllers_NetrunnerRestController_starterRunner19_invoker.call(NetrunnerRestController_0.starterRunner)
      }
  
    // @LINE:72
    case controllers_NetrunnerRestController_starterRunner20_route(params) =>
      call { 
        controllers_NetrunnerRestController_starterRunner20_invoker.call(NetrunnerRestController_0.starterRunner)
      }
  
    // @LINE:75
    case controllers_NetrunnerRestController_starterCorporation21_route(params) =>
      call { 
        controllers_NetrunnerRestController_starterCorporation21_invoker.call(NetrunnerRestController_0.starterCorporation)
      }
  
    // @LINE:78
    case controllers_NetrunnerRestController_starterCorporation22_route(params) =>
      call { 
        controllers_NetrunnerRestController_starterCorporation22_invoker.call(NetrunnerRestController_0.starterCorporation)
      }
  
    // @LINE:81
    case controllers_NetrunnerRestController_boosterLimited23_route(params) =>
      call { 
        controllers_NetrunnerRestController_boosterLimited23_invoker.call(NetrunnerRestController_0.boosterLimited)
      }
  
    // @LINE:84
    case controllers_NetrunnerRestController_boosterLimited24_route(params) =>
      call { 
        controllers_NetrunnerRestController_boosterLimited24_invoker.call(NetrunnerRestController_0.boosterLimited)
      }
  
    // @LINE:87
    case controllers_NetrunnerRestController_boosterProteus25_route(params) =>
      call { 
        controllers_NetrunnerRestController_boosterProteus25_invoker.call(NetrunnerRestController_0.boosterProteus)
      }
  
    // @LINE:90
    case controllers_NetrunnerRestController_boosterProteus26_route(params) =>
      call { 
        controllers_NetrunnerRestController_boosterProteus26_invoker.call(NetrunnerRestController_0.boosterProteus)
      }
  
    // @LINE:93
    case controllers_NetrunnerRestController_boosterClassic27_route(params) =>
      call { 
        controllers_NetrunnerRestController_boosterClassic27_invoker.call(NetrunnerRestController_0.boosterClassic)
      }
  
    // @LINE:96
    case controllers_NetrunnerRestController_boosterClassic28_route(params) =>
      call { 
        controllers_NetrunnerRestController_boosterClassic28_invoker.call(NetrunnerRestController_0.boosterClassic)
      }
  
    // @LINE:98
    case controllers_UserController_index29_route(params) =>
      call { 
        controllers_UserController_index29_invoker.call(UserController_1.index)
      }
  
    // @LINE:99
    case controllers_UserController_addUser30_route(params) =>
      call { 
        controllers_UserController_addUser30_invoker.call(UserController_1.addUser)
      }
  
    // @LINE:100
    case controllers_UserController_deleteUser31_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_deleteUser31_invoker.call(UserController_1.deleteUser(id))
      }
  }
}
