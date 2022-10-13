@file:Suppress("unused")

package no.scienta.workshop.oooct22.quantity

val Int.teaSpoon get() = Quantity(this, Teaspoon)

val Int.tableSpoon get() = Quantity(this, Tablespoon)

val Int.ounce get() = Quantity(this, Ounce)

val Int.cup get() = Quantity(this, Cup)

val Int.pint get() = Quantity(this, Pint)

val Int.quart get() = Quantity(this, Quart)

val Int.gallon get() = Quantity(this, Gallon)

val Int.inch get() = Quantity(this, Inch)

val Int.foot get() = Quantity(this, Foot)

