package controllers

import models.{User, Address}
import play.api.data.Form
import play.api.data.Forms.{longNumber, mapping, nonEmptyText}
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._
import repositories.{AddressRepository, UserRepository}

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

case class UpdateAddressForm(id: Long, userId: Long, city: String, postalCode: String, country: String, telephone: String, mobile: String, addressLine: String);
case class CreateAddressForm(userId: Long, city: String, postalCode: String, country: String, telephone: String, mobile: String, addressLine: String);
object CreateAddressForm {
  implicit val createCreateAddressFormFormat = Json.format[CreateAddressForm]
}

@Singleton
class AddressController @Inject()(addressRepo: AddressRepository, userRepo: UserRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val createAddressForm: Form[CreateAddressForm] = Form {
    mapping(
      "userId" -> longNumber,
      "city" -> nonEmptyText,
      "postalCode" -> nonEmptyText,
      "country" -> nonEmptyText,
      "telephone" -> nonEmptyText,
      "mobile" -> nonEmptyText,
      "addressLine" -> nonEmptyText
    )(CreateAddressForm.apply)(CreateAddressForm.unapply)
  }

  val updateAddressForm: Form[UpdateAddressForm] = Form {
    mapping(
      "id" -> longNumber,
      "userId" -> longNumber,
      "city" -> nonEmptyText,
      "postalCode" -> nonEmptyText,
      "country" -> nonEmptyText,
      "telephone" -> nonEmptyText,
      "mobile" -> nonEmptyText,
      "addressLine" -> nonEmptyText
    )(UpdateAddressForm.apply)(UpdateAddressForm.unapply)
  }

  def addAddressHandle = Action.async { implicit request =>
    var user: Seq[User] = Seq[User]()
    val usersList = userRepo.list().onComplete{
      case Success(us) => user = us
      case Failure(_) => println("fail")
    }

    createAddressForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(
          BadRequest(views.html.address_add(errorForm, user))
        )
      },
      add => {
        addressRepo.create(add.userId, add.city, add.postalCode, add.country, add.telephone, add.mobile, add.addressLine).map { _ =>
          Redirect(routes.AddressController.addAddress()).flashing("success" -> "address created")
        }
      }
    )
  }

  def addAddress(): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    val user = userRepo.list()
    user.map(u => Ok(views.html.address_add(createAddressForm, u)))
  }

  def getAddresses: Action[AnyContent] = Action.async { implicit request =>
    val usersAdd = addressRepo.list()
    usersAdd.map(el => Ok(views.html.usersAddresses(el)))
  }

  def getAddress(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deleteAddress(id: Long): Action[AnyContent] = Action {
    addressRepo.delete(id)
    Redirect("/addresses")
  }

  def updateAddressHandle = Action.async { implicit request =>
    var user: Seq[User] = Seq[User]()
    val usersList = userRepo.list().onComplete{
      case Success(us) => user = us
      case Failure(_) => println("fail")
    }

    updateAddressForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(
          BadRequest(views.html.address_update(errorForm, user))
        )
      },
      add => {
        addressRepo.update(add.id, Address(add.id, add.userId, add.city, add.postalCode, add.country, add.telephone, add.mobile, add.addressLine)).map { _ =>
          Redirect(routes.AddressController.updateAddress(add.id)).flashing("success" -> "address updated")
        }
      }
    )
  }

  def updateAddress(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    var userList: Seq[User] = Seq[User]()
    val usersListTest = userRepo.list().onComplete{
      case Success(us) => userList = us
      case Failure(_) => print("fail")
    }

    val usersAdd = addressRepo.getById(id)
    usersAdd.map(add => {
      val form = updateAddressForm.fill(UpdateAddressForm(add.id, add.userId, add.city, add.postalCode, add.country, add.telephone, add.mobile, add.addressLine))
      Ok(views.html.address_update(form, userList))
    })
  }

  def getUsersAddressesJson = Action.async {
    val user = addressRepo.list()
    user.map { seq =>
      Ok(Json.toJson(seq))
    }
  }

  def getAddressesJson(id: Long) = Action.async {
    val user = addressRepo.getById(id)
    user.map { seq =>
      Ok(Json.toJson(seq))
    }
  }


  def addaddresJson(): Action[JsValue] = Action.async(parse.json) { implicit request =>

    println(request.body)

    request.body.validate[CreateAddressForm].map {
      add =>
        addressRepo.create(add.userId, add.city, add.postalCode, add.country, add.telephone, add.mobile, add.addressLine).map { res =>
          Ok(Json.toJson(res))
        }
    }.getOrElse(Future.successful(BadRequest("incorrect data")))
  }

  def updateaddrestJson(): Action[JsValue] = Action.async(parse.json) { request =>

    println(request.body)

    request.body.validate[Address].map {
      add =>
        addressRepo.updateJson(add.id, Address(add.id, add.userId, add.city, add.postalCode, add.country, add.telephone, add.mobile, add.addressLine)).map { res =>
          Ok(Json.toJson(res))
        }
    }.getOrElse(Future.successful(BadRequest("incorrect data")))
  }

  def deleteaddresJson(id: Long): Action[AnyContent] = Action.async {
    addressRepo.deleteJson(id).map { res =>
      Ok(Json.toJson(res))
    }
  }

}

