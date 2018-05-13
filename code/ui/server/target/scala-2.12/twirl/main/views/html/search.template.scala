
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._
/*1.2*/import model.Hotel

object search extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,String,Seq[Hotel],WebJarAssets,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(destination: String, radius: String, searchResults: Seq[Hotel], webJarAssets: WebJarAssets):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*5.2*/gmapsLink/*5.11*/(hotel: Hotel) = {{
    import hotel._, coordinates._
    s"http://maps.google.com/?q=$name near $lat,$long"
}};
Seq[Any](format.raw/*2.94*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>

"""),format.raw/*8.2*/("""

"""),format.raw/*10.1*/("""<html lang="en">
    <head>
        <title>Hotels within """),_display_(/*12.31*/radius),format.raw/*12.37*/(""" """),format.raw/*12.38*/("""kilometers of """),_display_(/*12.53*/destination),format.raw/*12.64*/("""</title>
        <link rel='stylesheet' href='"""),_display_(/*13.39*/routes/*13.45*/.WebJarAssets.at(webJarAssets.locate("css/bootstrap.css"))),format.raw/*13.103*/("""'>
        <script src=""""),_display_(/*14.23*/routes/*14.29*/.WebJarAssets.at(webJarAssets.locate("jquery.js"))),format.raw/*14.79*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*15.23*/routes/*15.29*/.WebJarAssets.at(webJarAssets.locate("js/bootstrap.js"))),format.raw/*15.85*/("""" type="text/javascript"></script>
    </head>
    <body>
        <div id="container">

            <p>
                <form class="form-inline" method="get">
                    <div class="form-group">
                        <label for="destination">Destination</label>
                        <input type="text" class="form-control" name="destination" id="destination" placeholder="e.g. London" value=""""),_display_(/*24.135*/destination),format.raw/*24.146*/("""">
                    </div>
                    <div class="form-group">
                        <label for="distance">Distance</label>
                        <input type="number" min="0.5" max="20" step="0.5" class="form-control" name="distance" id="distance" value=""""),_display_(/*28.135*/{
                            radius
                        }),format.raw/*30.26*/("""">
                    </div>
                    <button id="load-hotels" type="submit" class="btn btn-default">Search</button>
                </form>
            </p>

            <p>
                <table class="table">
                    <tr>
                        <th>Name</th>
                        <th>Location</th>
                        <th>Images</th>
                    </tr>
                    """),_display_(/*43.22*/for(hotel <- searchResults) yield /*43.49*/ {_display_(Seq[Any](format.raw/*43.51*/("""
                        """),format.raw/*44.25*/("""<tr>
                            <td>"""),_display_(/*45.34*/hotel/*45.39*/.name),format.raw/*45.44*/("""</td>
                            <td><a href=""""),_display_(/*46.43*/gmapsLink(hotel)),format.raw/*46.59*/("""">Map</a></td>
                            <td>
                            """),_display_(/*48.30*/for(image <- hotel.images) yield /*48.56*/ {_display_(Seq[Any](format.raw/*48.58*/("""
                                """),format.raw/*49.33*/("""<img height="200px" src=""""),_display_(/*49.59*/image),format.raw/*49.64*/("""" />
                            """)))}),format.raw/*50.30*/("""
                            """),format.raw/*51.29*/("""</td>
                        </tr>
                    """)))}),format.raw/*53.22*/("""
                """),format.raw/*54.17*/("""</table>
            </p>

        </div>

        <!-- Load `client` code -->
        """),_display_(/*60.10*/scalajs/*60.17*/.html.scripts("client", routes.Assets.versioned(_).toString, name => getClass.getResource(s"/public/$name") != null)),format.raw/*60.133*/("""
        """),format.raw/*61.9*/("""<script type="application/javascript">
                App().main()
        </script>

    </body>
</html>"""))
      }
    }
  }

  def render(destination:String,radius:String,searchResults:Seq[Hotel],webJarAssets:WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(destination,radius,searchResults,webJarAssets)

  def f:((String,String,Seq[Hotel],WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (destination,radius,searchResults,webJarAssets) => apply(destination,radius,searchResults,webJarAssets)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun May 13 12:03:07 EEST 2018
                  SOURCE: /Users/oleg/GitHub/scala-course/server/app/views/search.scala.html
                  HASH: 010a95f8abb2db2be151c6c3d6a602d2caca70d8
                  MATRIX: 432->1|787->21|957->132|974->141|1114->113|1141->114|1184->251|1213->253|1298->311|1325->317|1354->318|1396->333|1428->344|1502->391|1517->397|1597->455|1649->480|1664->486|1735->536|1819->593|1834->599|1911->655|2347->1063|2380->1074|2680->1346|2763->1408|3207->1825|3250->1852|3290->1854|3343->1879|3408->1917|3422->1922|3448->1927|3523->1975|3560->1991|3664->2068|3706->2094|3746->2096|3807->2129|3860->2155|3886->2160|3951->2194|4008->2223|4096->2280|4141->2297|4256->2385|4272->2392|4410->2508|4446->2517
                  LINES: 17->1|22->2|26->5|26->5|30->2|31->3|33->8|35->10|37->12|37->12|37->12|37->12|37->12|38->13|38->13|38->13|39->14|39->14|39->14|40->15|40->15|40->15|49->24|49->24|53->28|55->30|68->43|68->43|68->43|69->44|70->45|70->45|70->45|71->46|71->46|73->48|73->48|73->48|74->49|74->49|74->49|75->50|76->51|78->53|79->54|85->60|85->60|85->60|86->61
                  -- GENERATED --
              */
          