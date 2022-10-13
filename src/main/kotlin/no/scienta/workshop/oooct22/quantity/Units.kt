@file:Suppress("unused")

package no.scienta.workshop.oooct22.quantity

import no.scienta.workshop.oooct22.quantity.Dimension.Distance
import no.scienta.workshop.oooct22.quantity.Dimension.Volume

object Teaspoon : Unit<Volume>(1, Teaspoon, Volume)
object Tablespoon : Unit<Volume>(3, Teaspoon)
object Ounce : Unit<Volume>(2, Tablespoon)
object Cup : Unit<Volume>(8, Ounce)
object Pint : Unit<Volume>(2, Cup)
object Quart : Unit<Volume>(2, Pint)
object Gallon : Unit<Volume>(4, Quart)

object Inch : Unit<Distance>(1, Inch, Distance)
object Foot : Unit<Distance>(12, Inch)
object Yard : Unit<Distance>(3, Foot)
