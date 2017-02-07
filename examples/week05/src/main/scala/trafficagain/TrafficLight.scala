package trafficagain

// TL problem again

// Using pattern matching add a method "next" which returns the next TL in sequence
// Red -> Green -> Amber -> Red

sealed trait TrafficLight {
    def next: TrafficLight = 
        this match {
            case Red => Green
            case Green => Amber
            case Amber => Red
            //case _ => Red --- not good practice when you know all the types
        }
}

final case object Red extends TrafficLight 
final case object Green extends TrafficLight
final case object Amber extends TrafficLight 