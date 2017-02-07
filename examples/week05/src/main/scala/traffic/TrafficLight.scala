package traffic

// Model a Traffic Light (TL) using sealed trait(s) 
// and case class(es) or case object(s)
// A TL is either Red, Green, or Amber

// Using polymorphism add a method "next" which returns the next TL in sequence
// Red -> Green -> Amber -> Red

sealed trait TrafficLight {
    def next: TrafficLight
}

final case object Red extends TrafficLight {
    def next = {
        Green // don't use return
    }
}

final case object Green extends TrafficLight {
    def next = Amber
}

final case object Amber extends TrafficLight {
    def next = Red
}
