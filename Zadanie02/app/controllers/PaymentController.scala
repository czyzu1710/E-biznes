package controllers

import models.{User, Payment}
import play.api.data.Form
import play.api.data.Forms.{date, longNumber, mapping, nonEmptyText, optional, sqlDate}
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._
import repositories.{PaymentRepository, UserRepository}

import java.sql.Date
import java.text.SimpleDateFormat
import javax.inject._
import scala.concurrent.{ExecutionContext, Future}
import scala.reflect.runtime.universe.Try
import scala.util.{Failure, Success}


case class UpdatePaymentForm(id: Long, userId: Long, paymentType: String, provider: String, accountNumber: String, expiry: java.util.Date)
case class CreatePaymentForm(userId: Long, paymentType: String, provider: String, accountNumber: String, expiry: java.util.Date)
object CreatePaymentForm {
  implicit val createCreatePaymentFormFormat = Json.format[CreatePaymentForm]
}

@Singleton
class PaymentController @Inject()(paymentRepo: PaymentRepository, userRepo: UserRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val createPaymentForm: Form[CreatePaymentForm] = Form {
    mapping(
      "userId" -> longNumber,
      "paymentType" -> nonEmptyText,
      "provider" -> nonEmptyText,
      "accountNumber" -> nonEmptyText,
      "expiry" -> date,
    )(CreatePaymentForm.apply)(CreatePaymentForm.unapply)
  }

  val updatePaymentForm: Form[UpdatePaymentForm] = Form {
    mapping(
      "id" -> longNumber,
      "userId" -> longNumber,
      "paymentType" -> nonEmptyText,
      "provider" -> nonEmptyText,
      "accountNumber" -> nonEmptyText,
      "expiry" -> date,
    )(UpdatePaymentForm.apply)(UpdatePaymentForm.unapply)
  }

  def addPaymentHandle = Action.async { implicit request =>
    var user: Seq[User] = Seq[User]()
    val usersList = userRepo.list().onComplete{
      case Success(us) => user = us
      case Failure(_) => println("fail")
    }

    createPaymentForm.bindFromRequest.fold(
      errorForm => {
        println("error")
        Future.successful(
          BadRequest(views.html.payment_add(errorForm, user))
        )
      },
      user => {
        paymentRepo.create(user.userId, user.paymentType, user.provider, user.accountNumber, user.expiry).map { _ =>
          Redirect(routes.PaymentController.addPayment()).flashing("success" -> "payment.created")
        }
      }
    )
  }

  def addPayment(): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    val user = userRepo.list()
    user.map(u => Ok(views.html.payment_add(createPaymentForm, u)))
  }

  def getPayments: Action[AnyContent] = Action.async { implicit request =>
    val usersPayments = paymentRepo.list()
    usersPayments.map(el => Ok(views.html.usersPayments(el)))
  }

  def getPayment(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deletePayment(id: Long): Action[AnyContent] = Action {
    paymentRepo.delete(id)
    Redirect("/payments")
  }

  def updatePaymentHandle = Action.async { implicit request =>
    var user: Seq[User] = Seq[User]()
    val usersList = userRepo.list().onComplete{
      case Success(us) => user = us
      case Failure(_) => print("fail")
    }
    updatePaymentForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(
          BadRequest(views.html.payment_update(errorForm, user))
        )
      },
      user => {
        paymentRepo.update(user.id, Payment(user.id, user.userId, user.paymentType, user.provider, user.accountNumber, user.expiry)).map { _ =>
          Redirect(routes.PaymentController.updatePayment(user.id)).flashing("success" -> "payment updated")
        }
      }
    )
  }

  def updatePayment(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    var userList: Seq[User] = Seq[User]()
    val usersListTest = userRepo.list().onComplete{
      case Success(us) => userList = us
      case Failure(_) => print("fail")
    }

    val usersPayments = paymentRepo.getById(id)
    usersPayments.map(user => {
      val form = updatePaymentForm.fill(UpdatePaymentForm(user.id, user.userId, user.paymentType, user.provider, user.accountNumber, user.expiry))
      Ok(views.html.payment_update(form, userList))
    })
  }

  def getPaymentsJson = Action.async {
    val user = paymentRepo.list()
    user.map { seq =>
      Ok(Json.toJson(seq))
    }
  }

  def getPaymentJson(id: Long) = Action.async {
    val user = paymentRepo.getById(id)
    user.map { seq =>
      Ok(Json.toJson(seq))
    }
  }

  def addPaymentJson(): Action[JsValue] = Action.async(parse.json) { implicit request =>

    println(request.body)

    request.body.validate[CreatePaymentForm].map {
      user =>
        paymentRepo.create(user.userId, user.paymentType, user.provider, user.accountNumber, user.expiry).map { res =>
          Ok(Json.toJson(res))
        }
    }.getOrElse(Future.successful(BadRequest("incorrect data")))
  }

  def updatePaymentJson(): Action[JsValue] = Action.async(parse.json) { request =>

    println(request.body)

    request.body.validate[Payment].map {
      user =>
        paymentRepo.updateJson(user.id, Payment(user.id, user.userId, user.paymentType, user.provider, user.accountNumber, user.expiry)).map { res =>
          Ok(Json.toJson(res))
        }
    }.getOrElse(Future.successful(BadRequest("incorrect data")))

  }


  def deletePaymentJson(id: Long): Action[AnyContent] = Action.async {
    paymentRepo.deleteJson(id).map { res =>
      Ok(Json.toJson(res))
    }
  }

}
