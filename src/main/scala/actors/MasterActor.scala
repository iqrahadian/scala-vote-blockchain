package actors

import akka.actor.{Actor, ActorLogging, Props}

class MasterActor extends Actor with ActorLogging{

  val workerProps:Map[String,Props] = Map(
    "webServer" -> Props[WebServer]
  )

  private def createWorker(name:String,prop:Props):Unit = {
    val ref = context.actorOf(prop,name)
    context watch ref
  }

  override def preStart(): Unit = {
    log.info("Master Actor is Up ! Start Initializing Actors")
    workerProps.foreach{
      case (name,prop) =>
        createWorker(name,prop)
    }
  }

  override def receive():Receive = {
    case _ =>
      log.warning("Message cannot be Identified")
  }

}
