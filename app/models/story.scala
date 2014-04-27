package models

import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.collection.mutable._
import play.api.Play.current
import scala.io._
class Story(sections:List[Section]) {
  def getSectionWithLabel(label:String) : Section = {
    var section = sections.filter((section : Section) => section.label.equals(label)).head
    return section
  }

  def getStoryStart() : Section = {
    var section = sections.filter((section : Section) => section.label.equals("start")).head
    return section
  }
}

object Stories {
  def load(storyName:String) : Story = {
    val file = Source.fromFile(Play.getFile("app/stories/" + storyName + ".json").getPath()).mkString
    val jsonStory = Json.parse(file)
    val sections : List[JsObject] = jsonStory.as[List[JsObject]]
    var storySections  = sections.map { section =>
        Sections.create((section \ "label").as[String], (section \ "text").as[String])
    }

    var story = new Story(storySections)
    return story
  }
}





















