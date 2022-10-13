@file:Suppress("unused")

package no.scienta.workshop.oooct22.quantity

object Teaspoon : BaseUnit<Volume>(Volume)
typealias Teaspoons = Teaspoon

object Tablespoon : Unit<Volume>(3, Teaspoons)
typealias Tablespoons = Tablespoon

object Ounce : Unit<Volume>(2, Tablespoons)
typealias Ounces = Ounce

object Cup : Unit<Volume>(8, Ounces)
typealias Cups = Cup

object Pint : Unit<Volume>(2, Cups)
typealias Pints = Pint

object Quart : Unit<Volume>(2, Pints)
typealias Quarts = Quart

object Gallon : Unit<Volume>(4, Quarts)
typealias Gallons = Gallon

object Inch : BaseUnit<Distance>(Distance)
typealias Inches = Inch

object Foot : Unit<Distance>(12, Inches)
typealias Feet = Foot

object Yard : Unit<Distance>(3, Feet)
typealias Yards = Yard

