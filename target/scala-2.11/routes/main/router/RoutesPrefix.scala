
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/fschlesinger/Qsync/professional/workspace/netrunner/conf/routes
// @DATE:Mon Jun 26 11:07:56 CEST 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
