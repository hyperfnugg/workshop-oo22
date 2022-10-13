package no.scienta.workshop.oooct22.quantity

import java.math.BigDecimal

sealed class Unit(internal val ratio: Int) {

    companion object {

        object Teaspoon : Unit(1)
        object Tablespoon : Unit(3 * Teaspoon)
        object Ounce : Unit(2 * Tablespoon)
        object Cup : Unit(8 * Ounce)
        object Pint : Unit(2 * Cup)
        object Quart : Unit(2 * Pint)
        object Gallon : Unit(4 * Quart)

        val Int.teaSpoon get() = cookingVolume(Teaspoon)
        val Int.tableSpoon get() = cookingVolume(Tablespoon)
        val Int.ounce get() = cookingVolume(Ounce)
        val Int.cup get() = cookingVolume(Cup)
        val Int.pint get() = cookingVolume(Pint)
        val Int.quart get() = cookingVolume(Quart)
        val Int.gallon get() = cookingVolume(Gallon)

        private operator fun Int.times(unit: Unit) = this * unit.ratio

        private fun Int.cookingVolume(unit: Unit) = Quantity(this, unit)
    }

    private fun asTeaspoons(quantity: Int) = quantity * ratio
    internal fun convert(amount: BigDecimal, unit: Unit) =
        unit.ratio.toBigDecimal().setScale(5) / this.ratio.toBigDecimal().setScale(5) * amount

}
