// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:32
  class ReverseItemScoreController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def deleteItemScore(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "itemscore/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:33
    def getItemScore(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "itemscore/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:32
    def addItemScore(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "itemscore")
    }
  
    // @LINE:35
    def updateItemScore(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "itemscore/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:10
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:26
  class ReverseItemReviewController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def addItemReview(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "itemreview")
    }
  
    // @LINE:28
    def deleteItemReview(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "itemreview/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:29
    def updateItemReview(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "itemreview/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:27
    def getItemReview(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "itemreview/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:47
  class ReversePaymentController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:48
    def getPayment(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "payment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:47
    def addPayment(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "payment")
    }
  
    // @LINE:50
    def updatePayment(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "payment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:49
    def deletePayment(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "payment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:20
  class ReverseCartController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def updateCart(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "cart/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:20
    def addCart(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "cart")
    }
  
    // @LINE:22
    def deleteCart(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "cart/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:21
    def getCart(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "cart/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:14
  class ReverseProductController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def addProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "product")
    }
  
    // @LINE:17
    def updateProduct(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "product/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:15
    def getProduct(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "product/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:16
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "product/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:52
  class ReverseRecordInCartController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:53
    def getRecordInCart(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "record/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:54
    def deleteRecordInCart(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "record/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:55
    def updateRecordInCart(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "record/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:52
    def addRecordInCart(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "record")
    }
  
  }

  // @LINE:58
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:58
    def addUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "user")
    }
  
    // @LINE:61
    def updateUser(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:59
    def getUser(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:60
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:38
  class ReverseLoginController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:39
    def logout(id:Long): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "logout" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Long]].unbind("id", id)))))
    }
  
    // @LINE:38
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
  }

  // @LINE:42
  class ReverseOrderController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:45
    def updateOrder(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "order/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:43
    def getOrder(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "order/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:42
    def addOrder(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "order")
    }
  
    // @LINE:44
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "order/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }


}
