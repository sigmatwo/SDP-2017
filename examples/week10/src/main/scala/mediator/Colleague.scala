package mediator

abstract class Colleague(var mediator: Mediator) {
  private var colleagueCode: Int = 0

  mediator.addColleague(this)

  def saleOffer(stock: String, shares: Int) =
    mediator.saleOffer(stock, shares, this.colleagueCode)

  def buyOffer(stock: String, shares: Int) =
    mediator.buyOffer(stock, shares, this.colleagueCode)

  def setCollCode(collCode: Int) {
    colleagueCode = collCode
  }
}
