package adapterpattern.payd

trait PayD {
    def getCustCardNo(): String
    def setCustCardNo(custCardNo: String): Unit
    def getCardOwnerName(): String
    def setCardOwnerName(cardOwnerName: String): Unit
    def getCardExpMonthDate(): String
    def setCardExpMonthDate(cardExpMonthDate: String): Unit
    def getCVVNo(): Int
    def setCVVNo(cVVNo: Int): Unit
    def getTotalAmount(): Double
    def setTotalAmount(totalAmount: Double): Unit
}
