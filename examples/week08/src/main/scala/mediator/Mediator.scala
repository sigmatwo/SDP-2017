package mediator

trait Mediator {
  def saleOffer(stock: String, shares: Int, collCode: Int)

  def buyOffer(stock: String, shares: Int, collCode: Int)

  def addColleague(colleague: Colleague)
}
