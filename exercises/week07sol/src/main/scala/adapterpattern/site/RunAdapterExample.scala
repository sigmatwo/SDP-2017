package adapterpattern.site

import adapterpattern.payd.PayD
import adapterpattern.xpay.Xpay

object RunAdapterExample {
  def main(args: Array[String]) {
    // Object for Xpay
    val xpay: Xpay = new XpayImpl
    xpay.setCreditCardNo("4789565874102365")
    xpay.setCustomerName("Max Warner")
    xpay.setCardExpMonth("09")
    xpay.setCardExpYear("25")
    xpay.setCardCVVNo(235.toShort)
    xpay.setAmount(2565.23)
    val payD: PayD = new XpayToPayDAdapter(xpay)
    testPayD(payD)
  }

  private def testPayD(payD: PayD) {
    System.out.println(payD.getCardOwnerName)
    System.out.println(payD.getCustCardNo)
    System.out.println(payD.getCardExpMonthDate)
    System.out.println(payD.getCVVNo)
    System.out.println(payD.getTotalAmount)
  }
}
