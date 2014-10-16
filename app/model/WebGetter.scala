package model.webgetters

import scala.concurrent.{Future}

import spray.http._
import spray.client.pipelining._
import spray.json._

import play.api.Play.current
import play.api.libs.concurrent.Akka

import com.codeforces.api.objects._
import com.codeforces.api.JsonProtocol._

abstract class Data {
    def raw: String
    def solvedCount: Int
}

class CodeForcesData(val data: StatusResponce) extends Data {
  override def raw = data.toJson.prettyPrint
  override def solvedCount = data.result.map(_.problem.name).toSet.size
}

object CodeForcesData {
    def apply(rj: StatusResponce) = new CodeForcesData(rj)
}

trait WebGetter {
    def get(param: String): Future[Data]
}

object CodeForcesWebGetter extends WebGetter {
    def get(param: String) = {
        implicit val system = Akka.system
        import system.dispatcher
        
        import spray.httpx.SprayJsonSupport._
        
        val pipeline = sendReceive ~> unmarshal[StatusResponce]
        val response = pipeline(
            Get("http://codeforces.com/api/user.status?handle=" + param + "&from=1&count=10000")
            )
        response.map(sr => CodeForcesData(sr))
    }
}