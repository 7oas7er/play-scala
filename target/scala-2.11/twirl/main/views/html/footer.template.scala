
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object footer_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class footer extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="container-fluid" style="background: darkslategray;position: relative;height: 68px;margin-top: 22px">
    <div class="container">
        <div class="row" id="nrfooter">
            <div class="col-md-8">
                <a class="btn btn-link" href="/imprint" role="button">Imprint</a>
                <a class="btn btn-link" href="https://www.xing.com/profile/Frank_Schlesinger" target="_blank" role="button"><i class="fa fa-xing" aria-hidden="true"></i></a>
                <a class="btn btn-link" href="https://www.linkedin.com/in/frankschlesinger/" target="_blank" role="button"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                <a class="btn btn-link" href="https://twitter.com/intent/follow?screen_name=7oas7er"><i class="fa fa-twitter" aria-hidden="true"></i></a>
            </div>
            <div class="col-md-4">
            </div>
        </div>
    </div>
</div>


<div class="container-fluid" style="position: relative;height: 34px;margin-top: 12px">
    <div class="container">
        <div class="row" id="nrsocialfooter">
            <div class="col-md-12">
            </div>
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
object footer extends footer_Scope0.footer
              /*
                  -- GENERATED --
                  DATE: Mon Jun 26 11:07:57 CEST 2017
                  SOURCE: /Users/fschlesinger/Qsync/professional/workspace/netrunner/app/views/footer.scala.html
                  HASH: 5e827e95a3027e56cfec62a7e8e64dfc276de244
                  MATRIX: 611->0
                  LINES: 25->1
                  -- GENERATED --
              */
          