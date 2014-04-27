package models

import play.api._
import play.api.mvc._
import scala.collection.mutable._

case class Section(label: String, text:String, choices:MutableList[Section])

object Sections {
  def create(label:String, text:String, choices:MutableList[Section]) : Section = {
    var section : Section = new Section(label, text, choices)
    return section
  }

  def create(label:String, text:String) : Section = {
    val choices = new MutableList[Section]
    var section : Section = new Section(label, text, choices)
    return section
  }
}
