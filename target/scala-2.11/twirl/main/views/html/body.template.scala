
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object body_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class body extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Html,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(top: Html, menu: Html, content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.40*/("""

"""),format.raw/*3.1*/("""<div class="container-fluid" style="color: ivory; background: darkslategray;position: relative;height: 204px">
    <div class="container">
        """),_display_(/*5.10*/top),format.raw/*5.13*/("""
    """),format.raw/*6.5*/("""</div>
</div>

<div class="container-fluid" style="position:relative; height: 34px; margin-top: 34px;margin-bottom: 22px; background: darkseagreen">
    <div class="container">
        """),_display_(/*11.10*/menu),format.raw/*11.14*/("""
    """),format.raw/*12.5*/("""</div>
</div>

<div class="container">
    """),_display_(/*16.6*/content),format.raw/*16.13*/("""
"""),format.raw/*17.1*/("""</div>

"""))
      }
    }
  }

  def render(top:Html,menu:Html,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(top,menu,content)

  def f:((Html,Html,Html) => play.twirl.api.HtmlFormat.Appendable) = (top,menu,content) => apply(top,menu,content)

  def ref: this.type = this

}


}

/**/
object body extends body_Scope0.body
              /*
                  -- GENERATED --
                  DATE: Mon Jun 26 11:07:57 CEST 2017
                  SOURCE: /Users/fschlesinger/Qsync/professional/workspace/netrunner/app/views/body.scala.html
                  HASH: 6d232484d5ee69ee67ba8be9aec3d8ff0752362e
                  MATRIX: 533->1|666->39|694->41|868->189|891->192|922->197|1135->383|1160->387|1192->392|1262->436|1290->443|1318->444
                  LINES: 20->1|25->1|27->3|29->5|29->5|30->6|35->11|35->11|36->12|40->16|40->16|41->17
                  -- GENERATED --
              */
          