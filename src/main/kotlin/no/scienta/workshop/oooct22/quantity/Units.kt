package no.scienta.workshop.oooct22.quantity

object Teaspoon : Unit<Dimension.Volume>(1, Teaspoon, Dimension.Volume)
object Tablespoon : Unit<Dimension.Volume>(3, Teaspoon)
object Ounce : Unit<Dimension.Volume>(2, Tablespoon)
object Cup : Unit<Dimension.Volume>(8, Ounce)
object Pint : Unit<Dimension.Volume>(2, Cup)
object Quart : Unit<Dimension.Volume>(2, Pint)
object Gallon : Unit<Dimension.Volume>(4, Quart)

object Inch : Unit<Dimension.Distance>(1, Inch, Dimension.Distance)
object Foot : Unit<Dimension.Distance>(12, Inch)
object Yard : Unit<Dimension.Distance>(3, Foot)
