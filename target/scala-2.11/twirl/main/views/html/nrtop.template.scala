
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object nrtop_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class nrtop extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="row" >
    <div class="col-md-12 h1">7oas7er's NetRunner Page</div>
    <div class="col-md-8"><p>This page is dedicated to the Netrunner collectable card game,
        which was created by Richard Garfield and released by Wizards of the Coast, Inc in 1996.</p></div>
    <div class="col-md-4"></div>
    <div class="col-md-8"><p>You'll find a complete card list here as well as a function to generate random starter decks and booster packages.
        My work is based on the original work of Dominik Bódi and brought the code into the web.</p></div>
    <div class="col-md-4"></div>
</div>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object nrtop extends nrtop_Scope0.nrtop
              /*
                  -- GENERATED --
                  DATE: Mon Jun 26 11:07:57 CEST 2017
                  SOURCE: /Users/fschlesinger/Qsync/professional/workspace/netrunner/app/views/nrtop.scala.html
                  HASH: 12fc1259142df5b4787410a648484a01f603b5db
                  MATRIX: 609->0
                  LINES: 25->1
                  -- GENERATED --
              */
          