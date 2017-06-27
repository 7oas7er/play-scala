
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object user_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class user extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Form[models.UserFormData],Seq[models.User],RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userForm: Form[models.UserFormData],users : Seq[models.User])(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.97*/("""


    """),format.raw/*4.5*/("""<form id="user-data-form" role="form" action='"""),_display_(/*4.52*/routes/*4.58*/.UserController.addUser()),format.raw/*4.83*/("""' method="post" class="form-horizontal" align="center" autocomplete="off">

        <fieldset class="user-fieldset">

            <div class="user-form">
                <label class="form-title" style="color: #F8741B; font-size: 22px;font-weight: bold; text-decoration:none">title</label>
            </div>
            <br/>
            <table align="center" cellspacing="20">
                <tr>
                    <td align="left">
                        <div class="user-form" id="firstName_field_label">
                            <div class="controls col-xs-offset-3 col-xs-9">
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                    <strong>firstname</strong> :
                                </div>
                            </div>
                        </div>
                    </td>
                    <td align="center">
                        <div class="user-form" id="firstName_field_value">
                            <div class="controls col-xs-offset-3 col-xs-9">
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                    <input type="text" id="firstName" name="firstName" value="" placeholder="First Name" class="form-control input-lg" required>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <div class="user-form" id="lastName_field_label">
                            <div class="controls col-xs-offset-3 col-xs-9">
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                    <strong>lastname</strong> :
                                </div>
                            </div>
                        </div>
                    </td>
                    <td align="center">
                        <div class="user-form" id="lastName_field_value">
                            <div class="controls col-xs-offset-3 col-xs-9">
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                    <input type="text" id="lastName" name="lastName" value="" placeholder="Last Name" class="form-control input-lg" required>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <div class="user-form" id="email_field_label">
                            <div class="controls col-xs-offset-3 col-xs-9">
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                    <strong>email</strong> :
                                </div>
                            </div>
                        </div>
                    </td>
                    <td align="center">
                        <div class="user-form" id="email_field_value">
                            <div class="controls col-xs-offset-3 col-xs-9">
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                    <input type="email" id="email" name="email" placeholder="Email" class="form-control input-lg" required>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
            <br/>
            <div class="form-actions controls ynt-btn-xlarge">
                <button type="submit" class="btn btn-primary ynt-btn-orange">Add</button>
            </div>

        </fieldset>
    </form>

    <div class="user-display" >
        <fieldset>
            <legend align="center"><h3>Registered Users</h3></legend>
            <table cellspacing="20">
                <tr>
                    <th>userid</th>
                    <th>firstname</th>
                    <th>lastname</th>
                    <th>email</th>
                </tr>
                """),_display_(/*98.18*/for(user <- users) yield /*98.36*/{_display_(Seq[Any](format.raw/*98.37*/("""
                    """),format.raw/*99.21*/("""<tr>
                        <td>"""),_display_(/*100.30*/user/*100.34*/.id),format.raw/*100.37*/("""</td>
                        <td>"""),_display_(/*101.30*/user/*101.34*/.firstName),format.raw/*101.44*/("""</td>
                        <td>"""),_display_(/*102.30*/user/*102.34*/.lastName),format.raw/*102.43*/("""</td>
                        <td>"""),_display_(/*103.30*/user/*103.34*/.email),format.raw/*103.40*/("""</td>
                        <td><a href=""""),_display_(/*104.39*/routes/*104.45*/.UserController.deleteUser(user.id)),format.raw/*104.80*/("""">delete</a></td>
                    </tr>
                """)))}),format.raw/*106.18*/("""
            """),format.raw/*107.13*/("""</table>
        </fieldset>
    </div>

"""))
      }
    }
  }

  def render(userForm:Form[models.UserFormData],users:Seq[models.User],request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(userForm,users)(request)

  def f:((Form[models.UserFormData],Seq[models.User]) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (userForm,users) => (request) => apply(userForm,users)(request)

  def ref: this.type = this

}


}

/**/
object user extends user_Scope0.user
              /*
                  -- GENERATED --
                  DATE: Mon Jun 26 11:07:57 CEST 2017
                  SOURCE: /Users/fschlesinger/Qsync/professional/workspace/netrunner/app/views/user.scala.html
                  HASH: add2ba416f40a3543af59f490abff7804d3f7b28
                  MATRIX: 575->1|765->96|798->103|871->150|885->156|930->181|5721->4945|5755->4963|5794->4964|5843->4985|5905->5019|5919->5023|5944->5026|6007->5061|6021->5065|6053->5075|6116->5110|6130->5114|6161->5123|6224->5158|6238->5162|6266->5168|6338->5212|6354->5218|6411->5253|6504->5314|6546->5327
                  LINES: 20->1|25->1|28->4|28->4|28->4|28->4|122->98|122->98|122->98|123->99|124->100|124->100|124->100|125->101|125->101|125->101|126->102|126->102|126->102|127->103|127->103|127->103|128->104|128->104|128->104|130->106|131->107
                  -- GENERATED --
              */
          