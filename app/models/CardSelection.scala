package models


class CardSelection(c:List[Karte]) {
  require(c != null, "The list of cards cannot be null!")

  val cards = c

  def ids = {
    cards.map(k => k.id.toString).foldLeft("")((a:String,b:String) => a.concat(",").concat(b)).substring(1)
  }
}
