
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/oleg/GitHub/scala-course/server/conf/routes
// @DATE:Sun May 13 12:03:07 EEST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:10
  CountController_0: controllers.CountController,
  // @LINE:12
  AsyncController_2: controllers.AsyncController,
  // @LINE:15
  Assets_4: controllers.Assets,
  // @LINE:16
  WebJarAssets_5: controllers.WebJarAssets,
  // @LINE:18
  HotelsController_3: controllers.HotelsController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:10
    CountController_0: controllers.CountController,
    // @LINE:12
    AsyncController_2: controllers.AsyncController,
    // @LINE:15
    Assets_4: controllers.Assets,
    // @LINE:16
    WebJarAssets_5: controllers.WebJarAssets,
    // @LINE:18
    HotelsController_3: controllers.HotelsController
  ) = this(errorHandler, HomeController_1, CountController_0, AsyncController_2, Assets_4, WebJarAssets_5, HotelsController_3, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, CountController_0, AsyncController_2, Assets_4, WebJarAssets_5, HotelsController_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """time""", """controllers.HomeController.time"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """webjars/""" + "$" + """file<.+>""", """controllers.WebJarAssets.at(file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hotels/search""", """controllers.HotelsController.search(destination:String, distance:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hotels/api/""" + "$" + """path<.+>""", """controllers.HotelsController.api(path:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hotels/api/""" + "$" + """path<.+>""", """controllers.HotelsController.api(path:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_time1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("time")))
  )
  private[this] lazy val controllers_HomeController_time1_invoker = createInvoker(
    HomeController_1.time,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "time",
      Nil,
      "GET",
      this.prefix + """time""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_CountController_count2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count2_invoker = createInvoker(
    CountController_0.count,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      this.prefix + """count""",
      """ An example controller showing how to use dependency injection""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_AsyncController_message3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message3_invoker = createInvoker(
    AsyncController_2.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """ An example controller showing how to write asynchronous code""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Assets_versioned4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned4_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_WebJarAssets_at5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("webjars/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_WebJarAssets_at5_invoker = createInvoker(
    WebJarAssets_5.at(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebJarAssets",
      "at",
      Seq(classOf[String]),
      "GET",
      this.prefix + """webjars/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_HotelsController_search6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hotels/search")))
  )
  private[this] lazy val controllers_HotelsController_search6_invoker = createInvoker(
    HotelsController_3.search(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HotelsController",
      "search",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """hotels/search""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_HotelsController_api7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hotels/api/"), DynamicPart("path", """.+""",false)))
  )
  private[this] lazy val controllers_HotelsController_api7_invoker = createInvoker(
    HotelsController_3.api(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HotelsController",
      "api",
      Seq(classOf[String]),
      "GET",
      this.prefix + """hotels/api/""" + "$" + """path<.+>""",
      """ API endpoint for autowire""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_HotelsController_api8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hotels/api/"), DynamicPart("path", """.+""",false)))
  )
  private[this] lazy val controllers_HotelsController_api8_invoker = createInvoker(
    HotelsController_3.api(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HotelsController",
      "api",
      Seq(classOf[String]),
      "POST",
      this.prefix + """hotels/api/""" + "$" + """path<.+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:7
    case controllers_HomeController_time1_route(params) =>
      call { 
        controllers_HomeController_time1_invoker.call(HomeController_1.time)
      }
  
    // @LINE:10
    case controllers_CountController_count2_route(params) =>
      call { 
        controllers_CountController_count2_invoker.call(CountController_0.count)
      }
  
    // @LINE:12
    case controllers_AsyncController_message3_route(params) =>
      call { 
        controllers_AsyncController_message3_invoker.call(AsyncController_2.message)
      }
  
    // @LINE:15
    case controllers_Assets_versioned4_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned4_invoker.call(Assets_4.versioned(path, file))
      }
  
    // @LINE:16
    case controllers_WebJarAssets_at5_route(params) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_WebJarAssets_at5_invoker.call(WebJarAssets_5.at(file))
      }
  
    // @LINE:18
    case controllers_HotelsController_search6_route(params) =>
      call(params.fromQuery[String]("destination", None), params.fromQuery[String]("distance", None)) { (destination, distance) =>
        controllers_HotelsController_search6_invoker.call(HotelsController_3.search(destination, distance))
      }
  
    // @LINE:21
    case controllers_HotelsController_api7_route(params) =>
      call(params.fromPath[String]("path", None)) { (path) =>
        controllers_HotelsController_api7_invoker.call(HotelsController_3.api(path))
      }
  
    // @LINE:22
    case controllers_HotelsController_api8_route(params) =>
      call(params.fromPath[String]("path", None)) { (path) =>
        controllers_HotelsController_api8_invoker.call(HotelsController_3.api(path))
      }
  }
}
