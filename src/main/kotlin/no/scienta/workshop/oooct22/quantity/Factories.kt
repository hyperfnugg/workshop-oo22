@file:Suppress("unused")

package no.scienta.workshop.oooct22.quantity

infix fun <D: Dimension> Int.unitOf(unit: Unit<D>) = this unitsOf unit

infix fun <D: Dimension> Int.unitsOf(unit: Unit<D>) = Quantity(this, unit)

val Int.teaSpoon get() = this unitsOf Teaspoon
val Int.tableSpoons get() = tableSpoon

val Int.tableSpoon get() = this unitsOf Tablespoon
val Int.teaSpoons get() = teaSpoon

val Int.ounce get() = this unitsOf Ounce
val Int.ounces get() = ounce

val Int.cup get() = this unitsOf Cup
val Int.cups get() = cup

val Int.pint get() = this unitsOf Pint
val Int.pints get() = pint

val Int.quart get() = this unitsOf Quart
val Int.quarts get() = quart

val Int.gallon get() = this unitsOf Gallon
val Int.gallons get() = gallon

val Int.inch get() = this unitsOf Inch
val Int.inches get() = inch

val Int.foot get() = this unitsOf Foot
val Int.feet get() = foot

val Int.yard get() = this unitsOf Yard
val Int.yards get() = yard

