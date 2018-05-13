
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/oleg/GitHub/scala-course/server/conf/routes
// @DATE:Sun May 13 12:03:07 EEST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:15
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def versioned(file:Asset): Call = {
      implicit val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:16
  class ReverseWebJarAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def at(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "webjars/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:18
  class ReverseHotelsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def search(destination:String, distance:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hotels/search" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("destination", destination)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("distance", distance)))))
    }
  
    // @LINE:21
    def api(path:String): Call = {
    
      (path: @unchecked) match {
      
        // @LINE:21
        case (path)  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "hotels/api/" + implicitly[play.api.mvc.PathBindable[String]].unbind("path", path))
      
      }
    
    }
  
  }

  // @LINE:10
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def count(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def time(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "time")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:12
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def message(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }


}
