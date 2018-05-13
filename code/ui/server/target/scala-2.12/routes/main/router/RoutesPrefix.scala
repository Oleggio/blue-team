
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/oleg/GitHub/scala-course/server/conf/routes
// @DATE:Sun May 13 12:03:07 EEST 2018


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
