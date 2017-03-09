import akka.testkit.TestFSMRef
import CoffeeProtocol._

class CoffeeShopSpec extends ActorHarness {

  "A Coffee Shop" must {

    val coffeeShop = TestFSMRef(new CoffeeShop)

    "Must be idle until it received the Open message" in {
      coffeeShop.underlyingActor.stateName must be(Closed)
      coffeeShop ! Open
      coffeeShop.underlyingActor.stateName must be(Opened)
    }

    "Have barristas ready to go when initialised" in {
      coffeeShop.children.size must be(4)
    }

    "receive an order" in {
      coffeeShop.tell(CustomerOrder("Flat white"), testActor)
      coffeeShop.underlyingActor.stateData match {
        case OrderQueue(o) => o.values.head must be("Flat white")
        case Uninitialised => fail("We should have initialised our state data by now")
      }
    }

    "acknowledge the receipt of an order" in {
      expectMsg(Info("I will be making your coffee today"))
      assert(coffeeShop.children.toList.contains(lastSender))
    }

    "Return a queue when asked" in {
      coffeeShop.tell(Queue, testActor)
    }
  }
}
