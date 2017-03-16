package adapterpattern.xpay

trait Xpay {
    def getCreditCardNo(): String
    def setCreditCardNo(creditCardNo: String): Unit
    def getCustomerName(): String
    def setCustomerName(customerName: String): Unit
    def getCardExpMonth(): String
    def setCardExpMonth(cardExpMonth: String): Unit
    def getCardExpYear(): String
    def setCardExpYear(cardExpYear: String): Unit
    def getCardCVVNo(): Short
    def setCardCVVNo(cardCVVNo: Short): Unit
    def getAmount(): Double
    def setAmount(amount: Double): Unit
}
