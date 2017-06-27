
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object nrcontent_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class nrcontent extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[CardSelection,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(selection: CardSelection):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.28*/("""

"""),format.raw/*3.1*/("""<div class="row">
    <div class="col-md-12">
        <div class="table-responsive">
            <table class="table table-striped tablesorter">
                <thead>
                    <tr><th>#</th><th>ID</th><th>Name</th><th>Alignment</th><th>Type</th><th>Card Text</th><th>Flavour Text</th><th>Rarity</th><th>Illustrator</th><th>Edition</th></tr>
                </thead>
                <tbody>
                    """),_display_(/*11.22*/for(index <- 0 to selection.cards.length - 1) yield /*11.67*/ {_display_(Seq[Any](format.raw/*11.69*/("""
                        """),format.raw/*12.25*/("""<tr>
                            <td>"""),_display_(/*13.34*/(index + 1)),format.raw/*13.45*/("""</td>
                            <td>"""),_display_(/*14.34*/selection/*14.43*/.cards(index).id),format.raw/*14.59*/("""</td>
                            <td>"""),_display_(/*15.34*/selection/*15.43*/.cards(index).name),format.raw/*15.61*/("""</td>
                            <td>"""),_display_(/*16.34*/selection/*16.43*/.cards(index).alignment),format.raw/*16.66*/("""</td>
                            <td>"""),_display_(/*17.34*/selection/*17.43*/.cards(index).cardType),format.raw/*17.65*/("""</td>
                            <td>"""),_display_(/*18.34*/selection/*18.43*/.cards(index).text),format.raw/*18.61*/("""</td>
                            <td>"""),_display_(/*19.34*/selection/*19.43*/.cards(index).flavourText),format.raw/*19.68*/("""</td>
                            <td>"""),_display_(/*20.34*/selection/*20.43*/.cards(index).rarity),format.raw/*20.63*/("""</td>
                            <td>"""),_display_(/*21.34*/selection/*21.43*/.cards(index).illustrator),format.raw/*21.68*/("""</td>
                            <td>"""),_display_(/*22.34*/selection/*22.43*/.cards(index).edition),format.raw/*22.64*/("""</td>
                        </tr>
                    """)))}),format.raw/*24.22*/("""
                """),format.raw/*25.17*/("""</tbody>
            </table>
            <div class="row">
                <div class="col-md-12">
                    <h4>IDs of cards in selection</h4>
                    <p>
                       """),_display_(/*31.25*/selection/*31.34*/.ids),format.raw/*31.38*/("""
                    """),format.raw/*32.21*/("""<a class="btn btn-link" href="http://7oas7er.com/netrunner/rest/cards/ids/"""),_display_(/*32.96*/selection/*32.105*/.ids),format.raw/*32.109*/("""">
                        <i class="fa fa-cloud-download" aria-hidden="true"></i>&nbsp;as json
                    </a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
"""))
      }
    }
  }

  def render(selection:CardSelection): play.twirl.api.HtmlFormat.Appendable = apply(selection)

  def f:((CardSelection) => play.twirl.api.HtmlFormat.Appendable) = (selection) => apply(selection)

  def ref: this.type = this

}


}

/**/
object nrcontent extends nrcontent_Scope0.nrcontent
              /*
                  -- GENERATED --
                  DATE: Mon Jun 26 11:07:57 CEST 2017
                  SOURCE: /Users/fschlesinger/Qsync/professional/workspace/netrunner/app/views/nrcontent.scala.html
                  HASH: 3c248e6efbd3e10748e90f5b386541c2602dc951
                  MATRIX: 542->1|663->27|691->29|1142->453|1203->498|1243->500|1296->525|1361->563|1393->574|1459->613|1477->622|1514->638|1580->677|1598->686|1637->704|1703->743|1721->752|1765->775|1831->814|1849->823|1892->845|1958->884|1976->893|2015->911|2081->950|2099->959|2145->984|2211->1023|2229->1032|2270->1052|2336->1091|2354->1100|2400->1125|2466->1164|2484->1173|2526->1194|2614->1251|2659->1268|2889->1471|2907->1480|2932->1484|2981->1505|3083->1580|3102->1589|3128->1593
                  LINES: 20->1|25->1|27->3|35->11|35->11|35->11|36->12|37->13|37->13|38->14|38->14|38->14|39->15|39->15|39->15|40->16|40->16|40->16|41->17|41->17|41->17|42->18|42->18|42->18|43->19|43->19|43->19|44->20|44->20|44->20|45->21|45->21|45->21|46->22|46->22|46->22|48->24|49->25|55->31|55->31|55->31|56->32|56->32|56->32|56->32
                  -- GENERATED --
              */
          