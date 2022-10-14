@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package no.scienta.workshop.oooct22.quantity

object Units {

    val teaspoon = base("teaspoon", Volume)

    val tablespoon = unit("tablespoon", 3, teaspoon)

    val ounce = unit("ounce", 2, tablespoon)

    val cup = unit("cup", 8, ounce)

    val pint = unit("pint", 2, cup)

    val quart = unit("quart", 2, pint)

    val gallon = unit("gallon", 4, quart)

    val inch = base("inch", Distance, plural = "inches")

    val foot = unit("foot", 12, inch, plural = "feet")

    val yard = unit("yard", 3, foot)
}
