package mediator

import scala.collection.mutable.ArrayBuffer

case class StockMediator() extends Mediator {
  private var colleagues = ArrayBuffer.empty[Colleague]
  private var stockBuyOffers = ArrayBuffer.empty[StockOffer]
  private var stockSaleOffers = ArrayBuffer.empty[StockOffer]
  private var colleagueCodes: Int = 0

  override def addColleague(newColleague: Colleague) {
    colleagues += newColleague
    colleagueCodes += 1
    newColleague.setCollCode(colleagueCodes)
  }

  override def saleOffer(stock: String, shares: Int, collCode: Int) {
    var stockSold: Boolean = false
    for (offer <- stockBuyOffers) {
      if (!stockSold && (offer.stockSymbol == stock) && (offer.stockShares == shares)) {
        println(shares + " shares of " + stock + " sold to colleague code " + offer.colleagueCode)
        stockBuyOffers -= offer
        stockSold = true
      }
    }
    if (!stockSold) {
      println(shares + " shares of " + stock + " added to inventory")
      val newOffering: StockOffer = new StockOffer(shares, stock, collCode)
      stockSaleOffers += newOffering
    }
  }

  override def buyOffer(stock: String, shares: Int, collCode: Int) {
    var stockBought: Boolean = false
    import scala.collection.JavaConversions._
    for (offer <- stockSaleOffers) {
      if (!stockBought && (offer.stockSymbol == stock) && (offer.stockShares == shares)) {
        println(shares + " shares of " + stock + " bought by colleague code " + offer.colleagueCode)
        stockSaleOffers.remove(offer)
        stockBought = true
      }
    }
    if (!stockBought) {
      println(shares + " shares of " + stock + " added to inventory")
      val newOffering: StockOffer = new StockOffer(shares, stock, collCode)
      stockBuyOffers.add(newOffering)
    }
  }

  def getstockOfferings() {
    println("\nStocks for Sale")
    for (offer <- stockSaleOffers) {
      println(offer.stockShares + " of " + offer.stockSymbol)
    }
    println("\nStock Buy Offers")
    for (offer <- stockBuyOffers) {
      println(offer.stockShares + " of " + offer.stockSymbol)
    }
  }
}
