package adapterpattern.site

import adapterpattern.payd.PayD
import adapterpattern.xpay.Xpay

class XpayToPayDAdapter(val xpay: Xpay) extends PayD {

  private var custCardNo: String = null
  private var cardOwnerName: String = null
  private var cardExpMonthDate: String = null
  private var cVVNo: Int = 0
  private var totalAmount: Double = .0

  setCardOwnerName(xpay.getCustomerName)
  setCustCardNo(xpay.getCreditCardNo)
  setCardExpMonthDate(xpay.getCardExpMonth + "/" + xpay.getCardExpYear)
  setCVVNo(xpay.getCardCVVNo.intValue)
  setTotalAmount(xpay.getAmount)


  def getCustCardNo: String = custCardNo

  def setCustCardNo(custCardNo: String) = this.custCardNo = custCardNo

  def getCardOwnerName: String = cardOwnerName

  def setCardOwnerName(cardOwnerName: String) = this.cardOwnerName = cardOwnerName

  def getCardExpMonthDate: String = cardExpMonthDate

  def setCardExpMonthDate(cardExpMonthDate: String) = this.cardExpMonthDate = cardExpMonthDate

  def getCVVNo(): Int = cVVNo

  def setCVVNo(cVVNo: Int) = {
    this.cVVNo = cVVNo
  }

  def getTotalAmount: Double = totalAmount

  def setTotalAmount(totalAmount: Double) = this.totalAmount = totalAmount
}
