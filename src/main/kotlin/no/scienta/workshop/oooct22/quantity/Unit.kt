package no.scienta.workshop.oooct22.quantity

import no.scienta.workshop.oooct22.quantity.Unit.Dimension.*
import java.math.BigDecimal
import java.math.RoundingMode

sealed class Unit(ratio: BigDecimal, private val dimension: Dimension, offset: BigDecimal = BigDecimal.ZERO) {

    private val ratio = ratio.setScale(5, RoundingMode.HALF_UP)
    private val offset = offset.setScale(5, RoundingMode.HALF_UP)

    private constructor(multiplier: Int, baseUnit: Unit)
            : this(multiplier.toBigDecimal() * baseUnit.ratio, baseUnit.dimension)

    private constructor(multiplier: Double, baseUnit: Unit, offset: Double)
            : this(multiplier.toBigDecimal() * baseUnit.ratio, baseUnit.dimension, offset.toBigDecimal())

    companion object {

        object Teaspoon : Unit(BigDecimal.ONE, Volume)
        object Tablespoon : Unit(3, Teaspoon)
        object Ounce : Unit(2, Tablespoon)
        object Cup : Unit(8, Ounce)
        object Pint : Unit(2, Cup)
        object Quart : Unit(2, Pint)
        object Gallon : Unit(4, Quart)

        object Inches : Unit(BigDecimal.ONE, Distance)
        object Foot : Unit(12, Inches)
        object Yard : Unit(3, Foot)

        object Celsius : Unit(BigDecimal.ONE, Temperature)
        object Fahrenheit : Unit(1/1.8, Celsius, 32.0)

        infix fun Int.of(unit: Unit) = Quantity(this, unit)
    }

    internal fun convert(otherAmount: BigDecimal, other: Unit): BigDecimal {
        require(compatibleWith(other))
        return (otherAmount - other.offset) * other.ratio / this.ratio + this.offset
    }

    fun compatibleWith(other: Unit) = this.dimension == other.dimension

    fun hashCode(amount: BigDecimal) =
        (dimension to ratio * amount).hashCode()

    private sealed interface Dimension {
        object Volume : Dimension
        object Distance : Dimension
        object Temperature : Dimension
    }
}
