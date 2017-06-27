
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object welcome_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class welcome extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String, style: String = "scala"):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.44*/(""" 

"""),_display_(/*3.2*/defining(play.core.PlayVersion.current)/*3.41*/ { version =>_display_(Seq[Any](format.raw/*3.54*/("""

"""),format.raw/*5.1*/("""<link rel="stylesheet" media="screen" href="/@documentation/resources/style/main.css">

<section id="top">
  <div class="wrapper">
    <h1><a href="https://playframework.com/documentation/"""),_display_(/*9.59*/version),format.raw/*9.66*/("""/Home">"""),_display_(/*9.74*/message),format.raw/*9.81*/("""</a></h1>
  </div>
</section>

<div id="content" class="wrapper doc">
<article>

  <h1>Welcome to Play</h1>

  <p>
    Congratulations, you’ve just created a new Play application. This page will help you with the next few steps.
  </p>

  <blockquote>
    <p>
      You’re using Play """),_display_(/*24.26*/version),format.raw/*24.33*/("""
    """),format.raw/*25.5*/("""</p>
  </blockquote>

  <h2>Why do you see this page?</h2>

    <p>
      The <code>conf/routes</code> file defines a route that tells Play to invoke the <code>HomeController.index</code> action
      whenever a browser requests the <code>/</code> URI using the GET method:
    </p>

    <pre><code># Home page
GET     /               controllers.HomeController.index</code></pre>

    <p>
      Play has invoked the <code>controllers.HomeController.index</code> method to obtain the <code>Action</code> to execute:
    </p>

    <pre><code>def index = Action """),format.raw/*42.35*/("""{"""),format.raw/*42.36*/(""" """),format.raw/*42.37*/("""implicit request: Request[AnyContent] =>
  Ok(views.html.index("Your new application is ready!"))
"""),format.raw/*44.1*/("""}"""),format.raw/*44.2*/("""</code></pre>

    <p>
      An action is a function that handles the incoming HTTP request, and returns the HTTP result to send back to the web client.
      Here we send a <code>200 OK</code> response, using a template to fill its content.
    </p>


    <pre><code>@(message: String)

@main("Welcome to Play") """),format.raw/*54.27*/("""{"""),format.raw/*54.28*/("""

    """),format.raw/*56.5*/("""@welcome(message)

"""),format.raw/*58.1*/("""}"""),format.raw/*58.2*/("""</code></pre>

    <p>
      The first line of the template defines the function signature. Here it just takes a single <code>String</code> parameter.
      This template then calls another function defined in <code>app/views/main.scala.html</code>, which displays the HTML
      layout, and another function that displays this welcome message. You can freely add any HTML fragment mixed with Scala
      code in this file.
    </p>

    <p>You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*67.86*/version),format.raw/*67.93*/("""/ScalaTemplates">Twirl</a>, the template language used by Play, and how Play handles <a href="https://www.playframework.com/documentation/"""),_display_(/*67.232*/version),format.raw/*67.239*/("""/ScalaActions">actions</a>.</p>

    <h2>Async Controller</h2>

    Now that you've seen how Play renders a page, take a look at <code>AsyncController.scala</code>, which shows how to do asynchronous programming when handling a request.  The code is almost exactly the same as <code>HomeController.scala</code>, but instead of returning <code>Result</code>, the action returns <code>Future[Result]</code> to Play.  When the execution completes, Play can use a thread to render the result without blocking the thread in the mean time.


    <p>
        You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*75.87*/version),format.raw/*75.94*/("""/ScalaAsync">asynchronous actions</a> in the documentation.
    </p>

    <h2>Count Controller</h2>

    <p>
        Both the HomeController and AsyncController are very simple, and typically controllers present the results of the interaction of several services.  As an example, see the <code>CountController</code>, which shows how to inject a component into a controller and use the component when handling requests.  The count controller increments every time you click on it, so keep clicking to see the numbers go up.
    </p>

    <p>
        You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*85.87*/version),format.raw/*85.94*/("""/ScalaDependencyInjection">dependency injection</a> in the documentation.
    </p>

    <h2>Need more info on the console?</h2>

  <p>
    For more information on the various commands you can run on Play, i.e. running tests and packaging applications for production, see <a href="https://playframework.com/documentation/"""),_display_(/*91.187*/version),format.raw/*91.194*/("""/PlayConsole">Using the Play console</a>.
  </p>  

  <h2>Need to set up an IDE?</h2>

  <p>
      You can start hacking your application right now using any text editor. Any changes will be automatically reloaded at each page refresh, 
      including modifications made to Scala source files.
  </p>

  <p>
      If you want to set-up your application in <strong>IntelliJ IDEA</strong> or any other Java IDE, check the 
      <a href="https://www.playframework.com/documentation/"""),_display_(/*103.61*/version),format.raw/*103.68*/("""/IDE">Setting up your preferred IDE</a> page.
  </p>

  <h2>Need more documentation?</h2>

  <p>
    Play documentation is available at <a href="https://www.playframework.com/documentation/"""),_display_(/*109.94*/version),format.raw/*109.101*/("""">https://www.playframework.com/documentation</a>.
  </p>

  <p>
    Play comes with lots of example templates showcasing various bits of Play functionality at <a href="https://www.playframework.com/download#examples">https://www.playframework.com/download#examples</a>.
  </p>

  <h2>Need more help?</h2>

  <p>
    Play questions are asked and answered on Stackoverflow using the "playframework" tag: <a href="https://stackoverflow.com/questions/tagged/playframework">https://stackoverflow.com/questions/tagged/playframework</a>
  </p>

  <p>
    The <a href="http://groups.google.com/group/play-framework">Play Google Group</a> is where Play users come to seek help,
    announce projects, and discuss issues and new features. If you don’t have a Google account, you can still join the mailing
    list by sending an e-mail to
    <strong>play-framework+subscribe@googlegroups.com</strong>.
  </p>

  <p>
    Gitter is a real time chat channel, like IRC. The <a href="https://gitter.im/playframework/playframework">playframework/playframework</a>  channel is used by Play users to discuss the ins and outs of writing great Play applications.
  </p>
 
</article>

<aside>
  <h3>Browse</h3>
  <ul>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*138.59*/version),format.raw/*138.66*/("""">Documentation</a></li>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*139.59*/version),format.raw/*139.66*/("""/api/"""),_display_(/*139.72*/style),format.raw/*139.77*/("""/index.html">Browse the """),_display_(/*139.102*/{style.capitalize}),format.raw/*139.120*/(""" """),format.raw/*139.121*/("""API</a></li>
  </ul>
  <h3>Start here</h3>
  <ul>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*143.59*/version),format.raw/*143.66*/("""/PlayConsole">Using the Play console</a></li>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*144.59*/version),format.raw/*144.66*/("""/IDE">Setting up your preferred IDE</a></li>
    <li><a href="https://playframework.com/download#examples">Example Projects</a>
  </ul>
  <h3>Help here</h3>
  <ul>
    <li><a href="https://stackoverflow.com/questions/tagged/playframework">Stack Overflow</a></li>
    <li><a href="http://groups.google.com/group/play-framework">Mailing List</a></li>
    <li><a href="https://gitter.im/playframework/playframework">Gitter Channel</a></li>
  </ul>
  
</aside>

</div>
""")))}))
      }
    }
  }

  def render(message:String,style:String): play.twirl.api.HtmlFormat.Appendable = apply(message,style)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (message,style) => apply(message,style)

  def ref: this.type = this

}


}

/**/
object welcome extends welcome_Scope0.welcome
              /*
                  -- GENERATED --
                  DATE: Mon Jun 26 11:07:57 CEST 2017
                  SOURCE: /Users/fschlesinger/Qsync/professional/workspace/netrunner/app/views/welcome.scala.html
                  HASH: 383e5ce9151989348444e4961d69168b4b730d44
                  MATRIX: 538->1|675->43|704->47|751->86|801->99|829->101|1044->291|1071->298|1105->306|1132->313|1444->598|1472->605|1504->610|2092->1170|2121->1171|2150->1172|2275->1270|2303->1271|2644->1586|2673->1587|2706->1593|2752->1613|2780->1614|3326->2133|3354->2140|3521->2279|3550->2286|4207->2916|4235->2923|4890->3551|4918->3558|5267->3879|5296->3886|5806->4368|5835->4375|6053->4565|6083->4572|7368->5830|7397->5837|7508->5920|7537->5927|7571->5933|7598->5938|7652->5963|7693->5981|7724->5982|7860->6090|7889->6097|8021->6201|8050->6208
                  LINES: 20->1|25->1|27->3|27->3|27->3|29->5|33->9|33->9|33->9|33->9|48->24|48->24|49->25|66->42|66->42|66->42|68->44|68->44|78->54|78->54|80->56|82->58|82->58|91->67|91->67|91->67|91->67|99->75|99->75|109->85|109->85|115->91|115->91|127->103|127->103|133->109|133->109|162->138|162->138|163->139|163->139|163->139|163->139|163->139|163->139|163->139|167->143|167->143|168->144|168->144
                  -- GENERATED --
              */
          