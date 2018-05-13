
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
/*1.2*/import model.Hotel

object hotelsTable extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Seq[Hotel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(searchResults: Seq[Hotel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*4.2*/gmapsLink/*4.11*/(hotel: Hotel) = {{
    import hotel._, coordinates._
    s"http://maps.google.com/?q=$name near $lat,$long"
}};
Seq[Any](format.raw/*2.29*/("""

"""),format.raw/*7.2*/("""


"""),format.raw/*10.1*/("""<table class="table">
    <tr>
        <th>Name</th>
        <th>Location</th>
        <th>Images</th>
    </tr>
    """),_display_(/*16.6*/for(hotel <- searchResults) yield /*16.33*/ {_display_(Seq[Any](format.raw/*16.35*/("""
        """),format.raw/*17.9*/("""<tr>
            <td>"""),_display_(/*18.18*/hotel/*18.23*/.name),format.raw/*18.28*/("""</td>
            <td><a href=""""),_display_(/*19.27*/gmapsLink(hotel)),format.raw/*19.43*/("""">Map</a></td>
            <td>
            """),_display_(/*21.14*/for(image <- hotel.images) yield /*21.40*/ {_display_(Seq[Any](format.raw/*21.42*/("""
                """),format.raw/*22.17*/("""<img height="200px" src=""""),_display_(/*22.43*/image),format.raw/*22.48*/("""" />
            """)))}),format.raw/*23.14*/("""
            """),format.raw/*24.13*/("""</td>
        </tr>
    """)))}),format.raw/*26.6*/("""
"""),format.raw/*27.1*/("""</table>
"""))
      }
    }
  }

  def render(searchResults:Seq[Hotel]): play.twirl.api.HtmlFormat.Appendable = apply(searchResults)

  def f:((Seq[Hotel]) => play.twirl.api.HtmlFormat.Appendable) = (searchResults) => apply(searchResults)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun May 13 12:03:02 EEST 2018
                  SOURCE: /Users/oleg/GitHub/scala-course/shared/src/main/scala/views/hotelsTable.scala.html
                  HASH: 85a0875aec8c81b0a11330c151e66177385558ea
                  MATRIX: 269->1|602->21|707->51|724->60|864->48|892->170|922->173|1066->291|1109->318|1149->320|1185->329|1234->351|1248->356|1274->361|1333->393|1370->409|1442->454|1484->480|1524->482|1569->499|1622->525|1648->530|1697->548|1738->561|1793->586|1821->587
                  LINES: 10->1|15->2|19->4|19->4|23->2|25->7|28->10|34->16|34->16|34->16|35->17|36->18|36->18|36->18|37->19|37->19|39->21|39->21|39->21|40->22|40->22|40->22|41->23|42->24|44->26|45->27
                  -- GENERATED --
              */
          