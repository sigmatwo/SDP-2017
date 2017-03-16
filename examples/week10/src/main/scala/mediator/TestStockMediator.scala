package mediator

object TestStockMediator extends App {
    val nyse = StockMediator()
    val broker = GormanSlacks(nyse)
    val broker2 = JTPoorman(nyse)
    broker.saleOffer("MSFT", 100)
    broker.saleOffer("GOOG", 50)
    broker2.buyOffer("MSFT", 100)
    broker2.saleOffer("NRG", 10)
    broker.buyOffer("NRG", 10)
    nyse.getstockOfferings()
}
