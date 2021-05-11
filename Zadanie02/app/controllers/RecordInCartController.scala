package controllers

import models.{Cart, RecordInCart, Product}
import play.api.data.Form
import play.api.data.Forms.{date, longNumber, mapping, nonEmptyText, number}
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.Results.BadRequest
import play.api.mvc._
import repositories.{RecordInCartRepository, CartRepository, ProductRepository}

import javax.inject._
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

case class UpdateRecordInCartForm(id: Long, quantity: Int, productId: Long, cartId: Long)
case class CreateRecordInCartForm(quantity: Int, productId: Long, cartId: Long)
object CreateRecordInCartForm {
  implicit val createCreateRecordInCartFormat = Json.format[CreateRecordInCartForm]
}

@Singleton
class RecordInCartController @Inject()(recordInCartsRepo: RecordInCartRepository, cartRepository: CartRepository, productRepository: ProductRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val createRecordInCartForm: Form[CreateRecordInCartForm] = Form {
    mapping(
      "quantity" -> number,
      "productId" -> longNumber,
      "cardId" -> longNumber
    )(CreateRecordInCartForm.apply)(CreateRecordInCartForm.unapply)
  }

  val updateRecordInCartForm: Form[UpdateRecordInCartForm] = Form {
    mapping(
      "id" -> longNumber,
      "quantity" -> number,
      "productId" -> longNumber,
      "cardId" -> longNumber
    )(UpdateRecordInCartForm.apply)(UpdateRecordInCartForm.unapply)
  }

  def addRecordInCartHandle = Action.async { implicit request =>

    var carSeq: Seq[Cart] = Seq[Cart]()
    var prodSeq: Seq[Product] = Seq[Product]()


    productRepository.list().onComplete{
      case Success(us) => prodSeq = us
      case Failure(_) => println("fail")
    }

    cartRepository.list().onComplete{
      case Success(u) => carSeq = u
      case Failure(_) => println("fail")
    }

    Thread.sleep(10)

    createRecordInCartForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(
          BadRequest(views.html.recordInCart_add(errorForm, prodSeq, carSeq))
        )
      },
      add => {
        recordInCartsRepo.create(add.quantity, add.productId, add.cartId).map { _ =>
          Redirect(routes.RecordInCartController.addRecordInCart()).flashing("success" -> "recordInCart created")
        }
      }
    )
  }

  def addRecordInCart: Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    var prodSeq: Seq[Product] = Seq[Product]()
    productRepository.list().onComplete{
      case Success(us) => prodSeq = us
      case Failure(_) => println("fail")
    }

    val carSeq = cartRepository.list()
    carSeq.map(u => Ok(views.html.recordInCart_add(createRecordInCartForm, prodSeq, u)))
  }

  def getRecordInCart(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def getRecordInCarts: Action[AnyContent] = Action.async { implicit request =>
    val cartIt = recordInCartsRepo.list()
    cartIt.map(el => Ok(views.html.recordInCarts(el)))
  }

  def deleteRecordInCart(id: Long): Action[AnyContent] = Action {
    recordInCartsRepo.delete(id)
    Redirect("/recordInCarts")
  }

  def updateRecordInCartHandle() = Action.async { implicit request =>
    var prodSeq: Seq[Product] = Seq[Product]()
    productRepository.list().onComplete{
      case Success(us) => prodSeq = us
      case Failure(_) => println("fail")
    }

    var carSeq: Seq[Cart] = Seq[Cart]()
    cartRepository.list().onComplete{
      case Success(us) => carSeq = us
      case Failure(_) => println("fail")
    }

    updateRecordInCartForm.bindFromRequest.fold(
      errorForm => {
        Future(
          BadRequest(views.html.recordInCart_update(errorForm, prodSeq, carSeq))
        )
      },
      add => {
        recordInCartsRepo.update(add.id, RecordInCart(add.id, add.quantity, add.productId, add.cartId)).map { _ =>
          Redirect(routes.RecordInCartController.updateRecordInCart(add.id)).flashing("success" -> "recordInCart update")
        }
      }
    )
  }

  def updateRecordInCart(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    var prodSeq: Seq[Product] = Seq[Product]()
    productRepository.list().onComplete{
      case Success(us) => prodSeq = us
      case Failure(_) => println("fail")
    }

    var carSeq: Seq[Cart] = Seq[Cart]()
    cartRepository.list().onComplete{
      case Success(us) => carSeq = us
      case Failure(_) => println("fail")
    }

    var cartIt = recordInCartsRepo.getById(id)
    cartIt .map(e => {
      val form = updateRecordInCartForm.fill(UpdateRecordInCartForm(e.id, e.quantity, e.productId, e.cartId))
      Ok(views.html.recordInCart_update(form, prodSeq, carSeq))
    })

  }

  def getCartsItemsJson = Action.async {
    val cart = recordInCartsRepo.list()
    cart.map { seq =>
      Ok(Json.toJson(seq))
    }
  }

  def getCarItemsJson(id: Long) = Action.async {
    val cart = recordInCartsRepo.getById(id)
    cart.map { seq =>
      Ok(Json.toJson(seq))
    }
  }

  def addCarItemJson(): Action[JsValue] = Action.async(parse.json) { implicit request =>

    println(request.body)

    request.body.validate[CreateRecordInCartForm].map {
      add =>
        recordInCartsRepo.create(add.quantity, add.productId, add.cartId).map { res =>
          Ok(Json.toJson(res))
        }
    }.getOrElse(Future.successful(BadRequest("incorrect data")))
  }

  def updateCarItemJson(): Action[JsValue] = Action.async(parse.json) { request =>

    println(request.body)

    request.body.validate[RecordInCart].map {
      add =>
        recordInCartsRepo.updateJson(add.id, RecordInCart(add.id, add.quantity, add.productId, add.cartId)).map { res =>
          Ok(Json.toJson(res))
        }
    }.getOrElse(Future.successful(BadRequest("incorrect data")))
  }


  def deleteCarItemJson(id: Long): Action[AnyContent] = Action.async {
    recordInCartsRepo.deleteJson(id).map { res =>
      Ok(Json.toJson(res))
    }
  }
}
