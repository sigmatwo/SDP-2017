package adapterpattern.site

import adapterpattern.xpay.Xpay

class XpayImpl extends Xpay {
  private var creditCardNo = ""
  private var customerName  = ""
  private var cardExpMonth  = ""
  private var cardExpYear  = ""
  private var cardCVVNo: Short = 0
  private var amount: Double = 0.0

  def getCreditCardNo: String = creditCardNo

  def setCreditCardNo(creditCardNo: String) = {
    this.creditCardNo = creditCardNo
  }

  def getCustomerName: String = customerName

  def setCustomerName(customerName: String) = {
    this.customerName = customerName
  }
  
  def getCardExpMonth: String = cardExpMonth

  def setCardExpMonth(cardExpMonth: String) = {
    this.cardExpMonth = cardExpMonth
  }

  def getCardExpYear: String = cardExpYear

  def setCardExpYear(cardExpYear: String) = {
    this.cardExpYear = cardExpYear
  }

  def getCardCVVNo = cardCVVNo

  def setCardCVVNo(cardCVVNo: Short) = {
    this.cardCVVNo = cardCVVNo
  }

  def getAmount: Double = amount

  def setAmount(amount: Double) = {
    this.amount = amount
  }
}
