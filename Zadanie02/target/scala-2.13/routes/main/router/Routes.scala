// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_10: controllers.HomeController,
  // @LINE:10
  Assets_8: controllers.Assets,
  // @LINE:14
  ProductController_6: controllers.ProductController,
  // @LINE:20
  CartController_0: controllers.CartController,
  // @LINE:26
  ItemReviewController_9: controllers.ItemReviewController,
  // @LINE:32
  ItemScoreController_4: controllers.ItemScoreController,
  // @LINE:38
  LoginController_3: controllers.LoginController,
  // @LINE:42
  OrderController_1: controllers.OrderController,
  // @LINE:47
  PaymentController_5: controllers.PaymentController,
  // @LINE:52
  RecordInCartController_2: controllers.RecordInCartController,
  // @LINE:58
  UserController_7: controllers.UserController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_10: controllers.HomeController,
    // @LINE:10
    Assets_8: controllers.Assets,
    // @LINE:14
    ProductController_6: controllers.ProductController,
    // @LINE:20
    CartController_0: controllers.CartController,
    // @LINE:26
    ItemReviewController_9: controllers.ItemReviewController,
    // @LINE:32
    ItemScoreController_4: controllers.ItemScoreController,
    // @LINE:38
    LoginController_3: controllers.LoginController,
    // @LINE:42
    OrderController_1: controllers.OrderController,
    // @LINE:47
    PaymentController_5: controllers.PaymentController,
    // @LINE:52
    RecordInCartController_2: controllers.RecordInCartController,
    // @LINE:58
    UserController_7: controllers.UserController
  ) = this(errorHandler, HomeController_10, Assets_8, ProductController_6, CartController_0, ItemReviewController_9, ItemScoreController_4, LoginController_3, OrderController_1, PaymentController_5, RecordInCartController_2, UserController_7, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_10, Assets_8, ProductController_6, CartController_0, ItemReviewController_9, ItemScoreController_4, LoginController_3, OrderController_1, PaymentController_5, RecordInCartController_2, UserController_7, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product""", """controllers.ProductController.addProduct()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product/""" + "$" + """id<[^/]+>""", """controllers.ProductController.getProduct(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product/""" + "$" + """id<[^/]+>""", """controllers.ProductController.delete(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product/""" + "$" + """id<[^/]+>""", """controllers.ProductController.updateProduct(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cart""", """controllers.CartController.addCart()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cart/""" + "$" + """id<[^/]+>""", """controllers.CartController.getCart(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cart/""" + "$" + """id<[^/]+>""", """controllers.CartController.deleteCart(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cart/""" + "$" + """id<[^/]+>""", """controllers.CartController.updateCart(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """itemreview""", """controllers.ItemReviewController.addItemReview()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """itemreview/""" + "$" + """id<[^/]+>""", """controllers.ItemReviewController.getItemReview(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """itemreview/""" + "$" + """id<[^/]+>""", """controllers.ItemReviewController.deleteItemReview(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """itemreview/""" + "$" + """id<[^/]+>""", """controllers.ItemReviewController.updateItemReview(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """itemscore""", """controllers.ItemScoreController.addItemScore()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """itemscore/""" + "$" + """id<[^/]+>""", """controllers.ItemScoreController.getItemScore(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """itemscore/""" + "$" + """id<[^/]+>""", """controllers.ItemScoreController.deleteItemScore(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """itemscore/""" + "$" + """id<[^/]+>""", """controllers.ItemScoreController.updateItemScore(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.LoginController.login()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.LoginController.logout(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """order""", """controllers.OrderController.addOrder()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """order/""" + "$" + """id<[^/]+>""", """controllers.OrderController.getOrder(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """order/""" + "$" + """id<[^/]+>""", """controllers.OrderController.delete(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """order/""" + "$" + """id<[^/]+>""", """controllers.OrderController.updateOrder(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payment""", """controllers.PaymentController.addPayment()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payment/""" + "$" + """id<[^/]+>""", """controllers.PaymentController.getPayment(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payment/""" + "$" + """id<[^/]+>""", """controllers.PaymentController.deletePayment(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payment/""" + "$" + """id<[^/]+>""", """controllers.PaymentController.updatePayment(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """record""", """controllers.RecordInCartController.addRecordInCart()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """record/""" + "$" + """id<[^/]+>""", """controllers.RecordInCartController.getRecordInCart(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """record/""" + "$" + """id<[^/]+>""", """controllers.RecordInCartController.deleteRecordInCart(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """record/""" + "$" + """id<[^/]+>""", """controllers.RecordInCartController.updateRecordInCart(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """controllers.UserController.addUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """id<[^/]+>""", """controllers.UserController.getUser(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """id<[^/]+>""", """controllers.UserController.delete(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """id<[^/]+>""", """controllers.UserController.updateUser(id:Long)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_10.index(),
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

  // @LINE:10
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_8.versioned(fakeValue[String], fakeValue[Asset]),
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

  // @LINE:14
  private[this] lazy val controllers_ProductController_addProduct2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product")))
  )
  private[this] lazy val controllers_ProductController_addProduct2_invoker = createInvoker(
    ProductController_6.addProduct(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "addProduct",
      Nil,
      "POST",
      this.prefix + """product""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_ProductController_getProduct3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_getProduct3_invoker = createInvoker(
    ProductController_6.getProduct(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "getProduct",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """product/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_ProductController_delete4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_delete4_invoker = createInvoker(
    ProductController_6.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """product/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_ProductController_updateProduct5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_updateProduct5_invoker = createInvoker(
    ProductController_6.updateProduct(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "updateProduct",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """product/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_CartController_addCart6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cart")))
  )
  private[this] lazy val controllers_CartController_addCart6_invoker = createInvoker(
    CartController_0.addCart(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CartController",
      "addCart",
      Nil,
      "POST",
      this.prefix + """cart""",
      """ cart routes""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_CartController_getCart7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cart/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CartController_getCart7_invoker = createInvoker(
    CartController_0.getCart(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CartController",
      "getCart",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """cart/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_CartController_deleteCart8_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cart/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CartController_deleteCart8_invoker = createInvoker(
    CartController_0.deleteCart(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CartController",
      "deleteCart",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """cart/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_CartController_updateCart9_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cart/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CartController_updateCart9_invoker = createInvoker(
    CartController_0.updateCart(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CartController",
      "updateCart",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """cart/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_ItemReviewController_addItemReview10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("itemreview")))
  )
  private[this] lazy val controllers_ItemReviewController_addItemReview10_invoker = createInvoker(
    ItemReviewController_9.addItemReview(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemReviewController",
      "addItemReview",
      Nil,
      "POST",
      this.prefix + """itemreview""",
      """ item review routes""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_ItemReviewController_getItemReview11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("itemreview/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ItemReviewController_getItemReview11_invoker = createInvoker(
    ItemReviewController_9.getItemReview(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemReviewController",
      "getItemReview",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """itemreview/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_ItemReviewController_deleteItemReview12_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("itemreview/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ItemReviewController_deleteItemReview12_invoker = createInvoker(
    ItemReviewController_9.deleteItemReview(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemReviewController",
      "deleteItemReview",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """itemreview/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_ItemReviewController_updateItemReview13_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("itemreview/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ItemReviewController_updateItemReview13_invoker = createInvoker(
    ItemReviewController_9.updateItemReview(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemReviewController",
      "updateItemReview",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """itemreview/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_ItemScoreController_addItemScore14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("itemscore")))
  )
  private[this] lazy val controllers_ItemScoreController_addItemScore14_invoker = createInvoker(
    ItemScoreController_4.addItemScore(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemScoreController",
      "addItemScore",
      Nil,
      "POST",
      this.prefix + """itemscore""",
      """ item score routes""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_ItemScoreController_getItemScore15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("itemscore/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ItemScoreController_getItemScore15_invoker = createInvoker(
    ItemScoreController_4.getItemScore(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemScoreController",
      "getItemScore",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """itemscore/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_ItemScoreController_deleteItemScore16_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("itemscore/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ItemScoreController_deleteItemScore16_invoker = createInvoker(
    ItemScoreController_4.deleteItemScore(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemScoreController",
      "deleteItemScore",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """itemscore/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_ItemScoreController_updateItemScore17_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("itemscore/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ItemScoreController_updateItemScore17_invoker = createInvoker(
    ItemScoreController_4.updateItemScore(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemScoreController",
      "updateItemScore",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """itemscore/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_LoginController_login18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_LoginController_login18_invoker = createInvoker(
    LoginController_3.login(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "login",
      Nil,
      "POST",
      this.prefix + """login""",
      """ login routes""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_LoginController_logout19_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_LoginController_logout19_invoker = createInvoker(
    LoginController_3.logout(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "logout",
      Seq(classOf[Long]),
      "POST",
      this.prefix + """logout""",
      """""",
      Seq()
    )
  )

  // @LINE:42
  private[this] lazy val controllers_OrderController_addOrder20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("order")))
  )
  private[this] lazy val controllers_OrderController_addOrder20_invoker = createInvoker(
    OrderController_1.addOrder(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "addOrder",
      Nil,
      "POST",
      this.prefix + """order""",
      """ order routes""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_OrderController_getOrder21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("order/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrderController_getOrder21_invoker = createInvoker(
    OrderController_1.getOrder(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "getOrder",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """order/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:44
  private[this] lazy val controllers_OrderController_delete22_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("order/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrderController_delete22_invoker = createInvoker(
    OrderController_1.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """order/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:45
  private[this] lazy val controllers_OrderController_updateOrder23_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("order/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrderController_updateOrder23_invoker = createInvoker(
    OrderController_1.updateOrder(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "updateOrder",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """order/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:47
  private[this] lazy val controllers_PaymentController_addPayment24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payment")))
  )
  private[this] lazy val controllers_PaymentController_addPayment24_invoker = createInvoker(
    PaymentController_5.addPayment(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaymentController",
      "addPayment",
      Nil,
      "POST",
      this.prefix + """payment""",
      """ payment routes""",
      Seq()
    )
  )

  // @LINE:48
  private[this] lazy val controllers_PaymentController_getPayment25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payment/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PaymentController_getPayment25_invoker = createInvoker(
    PaymentController_5.getPayment(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaymentController",
      "getPayment",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """payment/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:49
  private[this] lazy val controllers_PaymentController_deletePayment26_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payment/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PaymentController_deletePayment26_invoker = createInvoker(
    PaymentController_5.deletePayment(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaymentController",
      "deletePayment",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """payment/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:50
  private[this] lazy val controllers_PaymentController_updatePayment27_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payment/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PaymentController_updatePayment27_invoker = createInvoker(
    PaymentController_5.updatePayment(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaymentController",
      "updatePayment",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """payment/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:52
  private[this] lazy val controllers_RecordInCartController_addRecordInCart28_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("record")))
  )
  private[this] lazy val controllers_RecordInCartController_addRecordInCart28_invoker = createInvoker(
    RecordInCartController_2.addRecordInCart(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecordInCartController",
      "addRecordInCart",
      Nil,
      "POST",
      this.prefix + """record""",
      """ record in cart routes""",
      Seq()
    )
  )

  // @LINE:53
  private[this] lazy val controllers_RecordInCartController_getRecordInCart29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("record/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecordInCartController_getRecordInCart29_invoker = createInvoker(
    RecordInCartController_2.getRecordInCart(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecordInCartController",
      "getRecordInCart",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """record/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:54
  private[this] lazy val controllers_RecordInCartController_deleteRecordInCart30_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("record/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecordInCartController_deleteRecordInCart30_invoker = createInvoker(
    RecordInCartController_2.deleteRecordInCart(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecordInCartController",
      "deleteRecordInCart",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """record/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:55
  private[this] lazy val controllers_RecordInCartController_updateRecordInCart31_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("record/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecordInCartController_updateRecordInCart31_invoker = createInvoker(
    RecordInCartController_2.updateRecordInCart(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecordInCartController",
      "updateRecordInCart",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """record/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:58
  private[this] lazy val controllers_UserController_addUser32_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_UserController_addUser32_invoker = createInvoker(
    UserController_7.addUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "addUser",
      Nil,
      "POST",
      this.prefix + """user""",
      """ user routes""",
      Seq()
    )
  )

  // @LINE:59
  private[this] lazy val controllers_UserController_getUser33_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_getUser33_invoker = createInvoker(
    UserController_7.getUser(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUser",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """user/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:60
  private[this] lazy val controllers_UserController_delete34_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_delete34_invoker = createInvoker(
    UserController_7.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """user/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:61
  private[this] lazy val controllers_UserController_updateUser35_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_updateUser35_invoker = createInvoker(
    UserController_7.updateUser(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "updateUser",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """user/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_10.index())
      }
  
    // @LINE:10
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_8.versioned(path, file))
      }
  
    // @LINE:14
    case controllers_ProductController_addProduct2_route(params@_) =>
      call { 
        controllers_ProductController_addProduct2_invoker.call(ProductController_6.addProduct())
      }
  
    // @LINE:15
    case controllers_ProductController_getProduct3_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ProductController_getProduct3_invoker.call(ProductController_6.getProduct(id))
      }
  
    // @LINE:16
    case controllers_ProductController_delete4_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ProductController_delete4_invoker.call(ProductController_6.delete(id))
      }
  
    // @LINE:17
    case controllers_ProductController_updateProduct5_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ProductController_updateProduct5_invoker.call(ProductController_6.updateProduct(id))
      }
  
    // @LINE:20
    case controllers_CartController_addCart6_route(params@_) =>
      call { 
        controllers_CartController_addCart6_invoker.call(CartController_0.addCart())
      }
  
    // @LINE:21
    case controllers_CartController_getCart7_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_CartController_getCart7_invoker.call(CartController_0.getCart(id))
      }
  
    // @LINE:22
    case controllers_CartController_deleteCart8_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_CartController_deleteCart8_invoker.call(CartController_0.deleteCart(id))
      }
  
    // @LINE:23
    case controllers_CartController_updateCart9_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_CartController_updateCart9_invoker.call(CartController_0.updateCart(id))
      }
  
    // @LINE:26
    case controllers_ItemReviewController_addItemReview10_route(params@_) =>
      call { 
        controllers_ItemReviewController_addItemReview10_invoker.call(ItemReviewController_9.addItemReview())
      }
  
    // @LINE:27
    case controllers_ItemReviewController_getItemReview11_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ItemReviewController_getItemReview11_invoker.call(ItemReviewController_9.getItemReview(id))
      }
  
    // @LINE:28
    case controllers_ItemReviewController_deleteItemReview12_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ItemReviewController_deleteItemReview12_invoker.call(ItemReviewController_9.deleteItemReview(id))
      }
  
    // @LINE:29
    case controllers_ItemReviewController_updateItemReview13_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ItemReviewController_updateItemReview13_invoker.call(ItemReviewController_9.updateItemReview(id))
      }
  
    // @LINE:32
    case controllers_ItemScoreController_addItemScore14_route(params@_) =>
      call { 
        controllers_ItemScoreController_addItemScore14_invoker.call(ItemScoreController_4.addItemScore())
      }
  
    // @LINE:33
    case controllers_ItemScoreController_getItemScore15_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ItemScoreController_getItemScore15_invoker.call(ItemScoreController_4.getItemScore(id))
      }
  
    // @LINE:34
    case controllers_ItemScoreController_deleteItemScore16_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ItemScoreController_deleteItemScore16_invoker.call(ItemScoreController_4.deleteItemScore(id))
      }
  
    // @LINE:35
    case controllers_ItemScoreController_updateItemScore17_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ItemScoreController_updateItemScore17_invoker.call(ItemScoreController_4.updateItemScore(id))
      }
  
    // @LINE:38
    case controllers_LoginController_login18_route(params@_) =>
      call { 
        controllers_LoginController_login18_invoker.call(LoginController_3.login())
      }
  
    // @LINE:39
    case controllers_LoginController_logout19_route(params@_) =>
      call(params.fromQuery[Long]("id", None)) { (id) =>
        controllers_LoginController_logout19_invoker.call(LoginController_3.logout(id))
      }
  
    // @LINE:42
    case controllers_OrderController_addOrder20_route(params@_) =>
      call { 
        controllers_OrderController_addOrder20_invoker.call(OrderController_1.addOrder())
      }
  
    // @LINE:43
    case controllers_OrderController_getOrder21_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_OrderController_getOrder21_invoker.call(OrderController_1.getOrder(id))
      }
  
    // @LINE:44
    case controllers_OrderController_delete22_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_OrderController_delete22_invoker.call(OrderController_1.delete(id))
      }
  
    // @LINE:45
    case controllers_OrderController_updateOrder23_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_OrderController_updateOrder23_invoker.call(OrderController_1.updateOrder(id))
      }
  
    // @LINE:47
    case controllers_PaymentController_addPayment24_route(params@_) =>
      call { 
        controllers_PaymentController_addPayment24_invoker.call(PaymentController_5.addPayment())
      }
  
    // @LINE:48
    case controllers_PaymentController_getPayment25_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PaymentController_getPayment25_invoker.call(PaymentController_5.getPayment(id))
      }
  
    // @LINE:49
    case controllers_PaymentController_deletePayment26_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PaymentController_deletePayment26_invoker.call(PaymentController_5.deletePayment(id))
      }
  
    // @LINE:50
    case controllers_PaymentController_updatePayment27_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PaymentController_updatePayment27_invoker.call(PaymentController_5.updatePayment(id))
      }
  
    // @LINE:52
    case controllers_RecordInCartController_addRecordInCart28_route(params@_) =>
      call { 
        controllers_RecordInCartController_addRecordInCart28_invoker.call(RecordInCartController_2.addRecordInCart())
      }
  
    // @LINE:53
    case controllers_RecordInCartController_getRecordInCart29_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RecordInCartController_getRecordInCart29_invoker.call(RecordInCartController_2.getRecordInCart(id))
      }
  
    // @LINE:54
    case controllers_RecordInCartController_deleteRecordInCart30_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RecordInCartController_deleteRecordInCart30_invoker.call(RecordInCartController_2.deleteRecordInCart(id))
      }
  
    // @LINE:55
    case controllers_RecordInCartController_updateRecordInCart31_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RecordInCartController_updateRecordInCart31_invoker.call(RecordInCartController_2.updateRecordInCart(id))
      }
  
    // @LINE:58
    case controllers_UserController_addUser32_route(params@_) =>
      call { 
        controllers_UserController_addUser32_invoker.call(UserController_7.addUser())
      }
  
    // @LINE:59
    case controllers_UserController_getUser33_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_getUser33_invoker.call(UserController_7.getUser(id))
      }
  
    // @LINE:60
    case controllers_UserController_delete34_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_delete34_invoker.call(UserController_7.delete(id))
      }
  
    // @LINE:61
    case controllers_UserController_updateUser35_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_updateUser35_invoker.call(UserController_7.updateUser(id))
      }
  }
}
