
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object header_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class header extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="container-fluid">
    <div class="row">
        <div class="col-md-12" style="background: seagreen;position: relative;height: 34px;padding-bottom: 34px;"></div>
    </div>
    <div class="row" id="menu">
        <div class="col-md-12" style="color: seagreen; position: relative;height: 40px;padding-bottom: 40px">
            <a class="btn btn-link" href="/netrunner" role="button">Netrunner</a>
            <a class="btn btn-link " href="http://7oas7er.wordpress.com" target="_blank" role="button"><i class="fa fa-wordpress" aria-hidden="true"></i>&nbsp;Sliced Thoughts</a>
        </div>
    </div>
</div>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object header extends header_Scope0.header
              /*
                  -- GENERATED --
                  DATE: Mon Jun 26 11:07:57 CEST 2017
                  SOURCE: /Users/fschlesinger/Qsync/professional/workspace/netrunner/app/views/header.scala.html
                  HASH: 8201776a682d4803ab322d03baf37f385bf09ced
                  MATRIX: 611->0
                  LINES: 25->1
                  -- GENERATED --
              */
          