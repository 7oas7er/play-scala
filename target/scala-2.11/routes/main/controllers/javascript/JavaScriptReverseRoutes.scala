
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/fschlesinger/Qsync/professional/workspace/netrunner/conf/routes
// @DATE:Mon Jun 26 11:07:56 CEST 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:60
  class ReverseNetrunnerRestController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:75
    def starterCorporation: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NetrunnerRestController.starterCorporation",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "netrunner/rest/starter/corporation"})
          }
        
        }
      """
    )
  
    // @LINE:81
    def boosterLimited: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NetrunnerRestController.boosterLimited",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "netrunner/rest/booster/limited"})
          }
        
        }
      """
    )
  
    // @LINE:60
    def card: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NetrunnerRestController.card",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "netrunner/rest/card/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
    // @LINE:69
    def starterRunner: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NetrunnerRestController.starterRunner",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "netrunner/rest/starter/runner"})
          }
        
        }
      """
    )
  
    // @LINE:93
    def boosterClassic: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NetrunnerRestController.boosterClassic",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "netrunner/rest/booster/classic"})
          }
        
        }
      """
    )
  
    // @LINE:63
    def allCards: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NetrunnerRestController.allCards",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "netrunner/rest/cards"})
        }
      """
    )
  
    // @LINE:66
    def cards: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NetrunnerRestController.cards",
      """
        function(idList0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "netrunner/rest/cards/ids/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("idList", idList0)})
        }
      """
    )
  
    // @LINE:87
    def boosterProteus: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NetrunnerRestController.boosterProteus",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "netrunner/rest/booster/proteus"})
          }
        
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseImprintController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def getImprint: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ImprintController.getImprint",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "imprint"})
          }
        
        }
      """
    )
  
  }

  // @LINE:98
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:99
    def addUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.addUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/add"})
        }
      """
    )
  
    // @LINE:100
    def deleteUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.deleteUser",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/delete/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
    // @LINE:98
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseNetrunnerController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def starterCorporation: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NetrunnerController.starterCorporation",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "netrunner/starter/corporation"})
          }
        
        }
      """
    )
  
    // @LINE:37
    def boosterLimited: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NetrunnerController.boosterLimited",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "netrunner/booster/limited"})
          }
        
        }
      """
    )
  
    // @LINE:25
    def starterRunner: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NetrunnerController.starterRunner",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "netrunner/starter/runner"})
          }
        
        }
      """
    )
  
    // @LINE:6
    def cards: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NetrunnerController.cards",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + """"})
          }
        
        }
      """
    )
  
    // @LINE:49
    def boosterClassic: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NetrunnerController.boosterClassic",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "netrunner/booster/classic"})
          }
        
        }
      """
    )
  
    // @LINE:43
    def boosterProteus: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NetrunnerController.boosterProteus",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "netrunner/booster/proteus"})
          }
        
        }
      """
    )
  
  }


}
