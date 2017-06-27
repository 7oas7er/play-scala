
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object nrmenu_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class nrmenu extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="row" id="nrmenu">
    <div class="col-md-12">
        <a class="btn btn-link" href="/netrunner" role="button"><i class="fa fa-list" aria-hidden="true"></i>&nbsp;All Cards</a>
        <a class="btn btn-link" href="/netrunner/starter/runner" role="button"><i class="fa fa-random" aria-hidden="true"></i>&nbsp;Runner Starter</a>
        <a class="btn btn-link" href="/netrunner/starter/corporation" role="button"><i class="fa fa-random" aria-hidden="true"></i>&nbsp;Corp Starter</a>
        <a class="btn btn-link" href="/netrunner/booster/limited" role="button"><i class="fa fa-random" aria-hidden="true"></i>&nbsp;Limited Booster</a>
        <a class="btn btn-link" href="/netrunner/booster/proteus" role="button"><i class="fa fa-random" aria-hidden="true"></i>&nbsp;Proteus Booster</a>
        <a class="btn btn-link" href="/netrunner/booster/classic" role="button"><i class="fa fa-random" aria-hidden="true"></i>&nbsp;Classic Booster</a>
        <a class="btn btn-link" href="/register" role="button">Register</a>
    </div>
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
object nrmenu extends nrmenu_Scope0.nrmenu
              /*
                  -- GENERATED --
                  DATE: Mon Jun 26 11:07:57 CEST 2017
                  SOURCE: /Users/fschlesinger/Qsync/professional/workspace/netrunner/app/views/nrmenu.scala.html
                  HASH: ab92602eb512d4fbc80409eb5db5574e27238fc8
                  MATRIX: 611->0
                  LINES: 25->1
                  -- GENERATED --
              */
          