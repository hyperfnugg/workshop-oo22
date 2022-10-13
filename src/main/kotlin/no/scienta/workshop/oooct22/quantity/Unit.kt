package no.scienta.workshop.oooct22.quantity

import no.scienta.workshop.oooct22.quantity.Unit.Dimension.Volume
import java.math.BigDecimal

sealed class Unit(private val ratio: Int, private val dimension: Dimension) {

    private constructor(multiplier: Int, baseUnit: Unit) : this(multiplier * baseUnit.ratio, baseUnit.dimension)

    companion object {

        object Teaspoon : Unit(1, Volume)
        object Tablespoon : Unit(3, Teaspoon)
        object Ounce : Unit(2, Tablespoon)
        object Cup : Unit(8, Ounce)
        object Pint : Unit(2, Cup)
        object Quart : Unit(2, Pint)
        object Gallon : Unit(4, Quart)

        infix fun Int.of(unit: Unit) =
            Quantity(this, unit)

        private fun Int.cookingVolume(unit: Unit) = Quantity(this, unit)
    }

    private fun asTeaspoons(quantity: Int) = quantity * ratio
    internal fun convert(amount: BigDecimal, unit: Unit) =
        unit.ratio.toBigDecimal().setScale(5) / this.ratio.toBigDecimal().setScale(5) * amount

    private sealed interface Dimension {
        object Volume : Dimension
        object Distance : Dimension
    }
}
