package controllers

import play.api._
import play.api.mvc._

import play.api.libs.concurrent.Execution.Implicits.defaultContext

import model.webgetters.{CodeForcesWebGetter}
import model.accounts.{CodeforcesAccountsList}

import concurrent.{Future}


object Application extends Controller {

  def index = Action { request =>
  	Ok(views.html.index("Feel my power!"))
  }
  
def list= Action.async{ request =>
    val pairedFutures = CodeforcesAccountsList.getAll.map( handle =>
        (handle, CodeForcesWebGetter.get(handle).map{_.solvedCount})
        )
        
    val resultFuture = Future.traverse(pairedFutures) { p => 
      p._2 .map((_, p._1))
    }
    
    for(l <- resultFuture) yield Ok(views.html.list(l))
  }
}