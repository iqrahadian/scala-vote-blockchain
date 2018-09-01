package ir.actors

import akka.actor.{Actor, ActorLogging}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.stream.{ActorMaterializer, ActorMaterializerSettings}
import akka.util.Timeout

import scala.concurrent.duration._
import scala.io.StdIn

class WebServer extends Actor with ActorLogging{

  private val actorMaterializerSetting = ActorMaterializerSettings(context.system).withDispatcher("akka-pool")

  implicit val system = context.system
  implicit val ec = context.dispatcher
  implicit val materializer = ActorMaterializer(actorMaterializerSetting)

  implicit val timeout      = Timeout(35 seconds)

  val route = get {
    path("status") {
      complete("UP")
    }
  }

  try {
    Http().bindAndHandle(route, "localhost", 8080)
    log.info(s"Server online at http://localhost:8080")
  }catch {
    case e:Exception =>
      log.error(e.getMessage)
  }

  override def receive: Receive = {
    case _ =>

  }

}
