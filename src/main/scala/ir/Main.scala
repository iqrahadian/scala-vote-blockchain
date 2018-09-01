package ir

import actors.MasterActor
import akka.actor.{ActorSystem, Props}

object Main {

  def main(args: Array[String]): Unit = {

    println("Starting BlockChain Project")
    val system = ActorSystem("BlockChainProject")
    system.actorOf(Props[MasterActor], "master") // -> /user/master

  }

}
