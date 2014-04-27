package controllers

import play.api._
import play.api.mvc._
import models._

object Application extends Controller {

  def index = Action {
    val story = Stories.load("test-story")
    story.getSectionWithLabel("i love you")
    println(story)
    Ok(views.html.index("Your new application is ready."))
  }
}
