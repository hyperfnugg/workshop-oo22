@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package no.scienta.workshop.oooct22.quantity

object Units {

    val teaspoon = baseUnit(Volume)

    val tablespoon = unit(3, teaspoon)

    val ounce = unit(2, tablespoon)

    val cup = unit(8, ounce)

    val pint = unit(2, cup)

    val quart = unit(2, pint)

    val gallon = unit(4, quart)

    val inch = baseUnit(Distance)

    val foot = unit(12, inch)

    val yard = unit(3, foot)
}
