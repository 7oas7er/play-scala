
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/fschlesinger/Qsync/professional/workspace/netrunner/conf/routes
// @DATE:Mon Jun 26 11:07:56 CEST 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned(file:Asset): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:60
  class ReverseNetrunnerRestController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:75
    def starterCorporation(): Call = {
    
      () match {
      
        // @LINE:75
        case ()  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "netrunner/rest/starter/corporation")
      
      }
    
    }
  
    // @LINE:81
    def boosterLimited(): Call = {
    
      () match {
      
        // @LINE:81
        case ()  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "netrunner/rest/booster/limited")
      
      }
    
    }
  
    // @LINE:60
    def card(id:Int): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "netrunner/rest/card/" + implicitly[PathBindable[Int]].unbind("id", id))
    }
  
    // @LINE:69
    def starterRunner(): Call = {
    
      () match {
      
        // @LINE:69
        case ()  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "netrunner/rest/starter/runner")
      
      }
    
    }
  
    // @LINE:93
    def boosterClassic(): Call = {
    
      () match {
      
        // @LINE:93
        case ()  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "netrunner/rest/booster/classic")
      
      }
    
    }
  
    // @LINE:63
    def allCards(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "netrunner/rest/cards")
    }
  
    // @LINE:66
    def cards(idList:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "netrunner/rest/cards/ids/" + implicitly[PathBindable[String]].unbind("idList", idList))
    }
  
    // @LINE:87
    def boosterProteus(): Call = {
    
      () match {
      
        // @LINE:87
        case ()  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "netrunner/rest/booster/proteus")
      
      }
    
    }
  
  }

  // @LINE:12
  class ReverseImprintController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def getImprint(): Call = {
    
      () match {
      
        // @LINE:12
        case ()  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "imprint")
      
      }
    
    }
  
  }

  // @LINE:98
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:99
    def addUser(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "user/add")
    }
  
    // @LINE:100
    def deleteUser(id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "user/delete/" + implicitly[PathBindable[Long]].unbind("id", id))
    }
  
    // @LINE:98
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
  }

  // @LINE:6
  class ReverseNetrunnerController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def starterCorporation(): Call = {
    
      () match {
      
        // @LINE:31
        case ()  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "netrunner/starter/corporation")
      
      }
    
    }
  
    // @LINE:37
    def boosterLimited(): Call = {
    
      () match {
      
        // @LINE:37
        case ()  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "netrunner/booster/limited")
      
      }
    
    }
  
    // @LINE:25
    def starterRunner(): Call = {
    
      () match {
      
        // @LINE:25
        case ()  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "netrunner/starter/runner")
      
      }
    
    }
  
    // @LINE:6
    def cards(): Call = {
    
      () match {
      
        // @LINE:6
        case ()  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix)
      
      }
    
    }
  
    // @LINE:49
    def boosterClassic(): Call = {
    
      () match {
      
        // @LINE:49
        case ()  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "netrunner/booster/classic")
      
      }
    
    }
  
    // @LINE:43
    def boosterProteus(): Call = {
    
      () match {
      
        // @LINE:43
        case ()  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "netrunner/booster/proteus")
      
      }
    
    }
  
  }


}
