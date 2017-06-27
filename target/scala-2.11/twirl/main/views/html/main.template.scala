
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
* This template is called from the `index` template. This template
* handles the rendering of the page header and body tags. It takes
* two arguments, a `String` for the title of the page and an `Html`
* object to insert into the body of the page.
*/
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.32*/("""

"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*12.62*/("""
        """),format.raw/*13.9*/("""<title>"""),_display_(/*13.17*/title),format.raw/*13.22*/("""</title>

        <link rel="shortcut icon" cardType="image/png" href=""""),_display_(/*15.63*/routes/*15.69*/.Assets.versioned("images/favicon.png")),format.raw/*15.108*/("""">

        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

        <link rel="stylesheet" media="screen" href=""""),_display_(/*19.54*/routes/*19.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*19.101*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*20.54*/routes/*20.60*/.Assets.versioned("stylesheets/tablesorter.css")),format.raw/*20.108*/("""">

        <link rel="stylesheet" href=""""),_display_(/*22.39*/routes/*22.45*/.Assets.versioned("stylesheets/font-awesome.min.css")),format.raw/*22.98*/("""">

        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src=""""),_display_(/*25.23*/routes/*25.29*/.Assets.versioned("javascripts/jquery-3.2.1.min.js")),format.raw/*25.81*/("""" cardType="text/javascript"></script>
        <script src=""""),_display_(/*26.23*/routes/*26.29*/.Assets.versioned("javascripts/jquery.tablesorter.js")),format.raw/*26.83*/("""" cardType="text/javascript"></script>

        <script src=""""),_display_(/*28.23*/routes/*28.29*/.Assets.versioned("javascripts/makeTableSortable.js")),format.raw/*28.82*/("""" cardType="text/javascript"></script>

        <script cardType="text/javascript" async src="https://platform.twitter.com/widgets.js"></script>

        <script>
                (function(i,s,o,g,r,a,m)"""),format.raw/*33.41*/("""{"""),format.raw/*33.42*/("""i['GoogleAnalyticsObject']=r;i[r]=i[r]||function()"""),format.raw/*33.92*/("""{"""),format.raw/*33.93*/("""
                            """),format.raw/*34.29*/("""(i[r].q=i[r].q||[]).push(arguments)"""),format.raw/*34.64*/("""}"""),format.raw/*34.65*/(""",i[r].l=1*new Date();a=s.createElement(o),
                        m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
                """),format.raw/*36.17*/("""}"""),format.raw/*36.18*/(""")(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

                ga('create', 'UA-98918047-1', 'auto');
                ga('send', 'pageview');

        </script>

    </head>
    <body>
        """),format.raw/*46.31*/("""
        """),_display_(/*47.10*/content),format.raw/*47.17*/("""
    """),format.raw/*48.5*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


}

/*
* This template is called from the `index` template. This template
* handles the rendering of the page header and body tags. It takes
* two arguments, a `String` for the title of the page and an `Html`
* object to insert into the body of the page.
*/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Mon Jun 26 11:07:57 CEST 2017
                  SOURCE: /Users/fschlesinger/Qsync/professional/workspace/netrunner/app/views/main.scala.html
                  HASH: bb5eb03c40f6efeac48ea3b230a26ba93a7b6195
                  MATRIX: 779->255|904->285|932->287|1012->392|1048->401|1083->409|1109->414|1208->486|1223->492|1284->531|1478->698|1493->704|1556->745|1639->801|1654->807|1724->855|1793->897|1808->903|1882->956|2034->1081|2049->1087|2122->1139|2210->1200|2225->1206|2300->1260|2389->1322|2404->1328|2478->1381|2709->1584|2738->1585|2816->1635|2845->1636|2902->1665|2965->1700|2994->1701|3185->1864|3214->1865|3471->2183|3508->2193|3536->2200|3568->2205
                  LINES: 25->7|30->7|32->9|35->12|36->13|36->13|36->13|38->15|38->15|38->15|42->19|42->19|42->19|43->20|43->20|43->20|45->22|45->22|45->22|48->25|48->25|48->25|49->26|49->26|49->26|51->28|51->28|51->28|56->33|56->33|56->33|56->33|57->34|57->34|57->34|59->36|59->36|68->46|69->47|69->47|70->48
                  -- GENERATED --
              */
          