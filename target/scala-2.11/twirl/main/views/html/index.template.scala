
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, body: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.29*/("""

"""),_display_(/*3.2*/main(title)/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""
    """),_display_(/*4.6*/header()),format.raw/*4.14*/("""
    """),_display_(/*5.6*/body),format.raw/*5.10*/("""
    """),_display_(/*6.6*/footer()),format.raw/*6.14*/("""
""")))}))
      }
    }
  }

  def render(title:String,body:Html): play.twirl.api.HtmlFormat.Appendable = apply(title,body)

  def f:((String,Html) => play.twirl.api.HtmlFormat.Appendable) = (title,body) => apply(title,body)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Mon Jun 26 11:07:57 CEST 2017
                  SOURCE: /Users/fschlesinger/Qsync/professional/workspace/netrunner/app/views/index.scala.html
                  HASH: 0c377e0c32cd58c8642915402526cc5e976ca5dc
                  MATRIX: 532->1|654->28|682->31|701->42|740->44|771->50|799->58|830->64|854->68|885->74|913->82
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|28->4|29->5|29->5|30->6|30->6
                  -- GENERATED --
              */
          