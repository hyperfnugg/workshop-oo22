package no.scienta.workshop.oooct22.quantity

import no.scienta.workshop.oooct22.quantity.Unit.Dimension.Distance
import no.scienta.workshop.oooct22.quantity.Unit.Dimension.Volume
import java.math.BigDecimal

@Suppress("unused")
sealed class Unit(private val ratio: Int, val dimension: Dimension) {

    private constructor(multiplier: Int, baseUnit: Unit) : this(multiplier * baseUnit.ratio, baseUnit.dimension)

    companion object {

        object Teaspoon : Unit(1, Volume)
        object Tablespoon : Unit(3, Teaspoon)
        object Ounce : Unit(2, Tablespoon)
        object Cup : Unit(8, Ounce)
        object Pint : Unit(2, Cup)
        object Quart : Unit(2, Pint)
        object Gallon : Unit(4, Quart)

        object Inches : Unit(1, Distance)
        object Foot : Unit(12, Inches)
        object Yard : Unit(3, Foot)

        infix fun Int.of(unit: Unit) =
            Quantity(this, unit)
    }

    internal fun convert(amount: BigDecimal, unit: Unit): BigDecimal {
        require(compatibleWith(unit))
        return unit.ratio.toBigDecimal().setScale(5) / this.ratio.toBigDecimal().setScale(5) * amount
    }

    fun compatibleWith(other: Unit) = this.dimension ==  other.dimension

    fun hashCode(amount: BigDecimal) =
        (dimension to ratio.toBigDecimal() * amount).hashCode()

    sealed interface Dimension {
        object Volume : Dimension
        object Distance : Dimension
    }
}
