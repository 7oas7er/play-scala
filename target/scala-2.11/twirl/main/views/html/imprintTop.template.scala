
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object imprintTop_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class imprintTop extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="row" >
    <div class="col-md-12 h1">Impressum</div>
    <div class="col-md-8"><h2>Angaben gem&auml;&szlig; &sect; 5 TMG</h2>
        <p>Frank-Michael Schlesinger<br /> Alt-Moabit 84b<br /> 10555 Berlin </p></div>
    <div class="col-md-4"></div>
    <div class="col-md-8"><h2>Kontakt:</h2>
        <table><tr><td>E-Mail:</td>
            <td>Frank(at)Schlesinger.com</td> </tr></table></div>
    <div class="col-md-4"></div>
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
object imprintTop extends imprintTop_Scope0.imprintTop
              /*
                  -- GENERATED --
                  DATE: Mon Jun 26 11:07:57 CEST 2017
                  SOURCE: /Users/fschlesinger/Qsync/professional/workspace/netrunner/app/views/imprintTop.scala.html
                  HASH: 6d6a35af75cf9d33e550c7f8210747e1156482d1
                  MATRIX: 619->0
                  LINES: 25->1
                  -- GENERATED --
              */
          