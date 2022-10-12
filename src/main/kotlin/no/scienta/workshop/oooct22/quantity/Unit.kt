package no.scienta.workshop.oooct22.quantity

import no.scienta.workshop.oooct22.quantity.Dimension.Distance
import no.scienta.workshop.oooct22.quantity.Dimension.Volume

sealed class Unit<D : Dimension>(private val ratio: Int) {

    private constructor(amount: Int, baseUnit: Unit<D>) : this(amount * baseUnit.ratio)

    companion object {

        object Teaspoon : Unit<Volume>(1)
        object Tablespoon : Unit<Volume>(3, Teaspoon)
        object Ounce : Unit<Volume>(2, Tablespoon)
        object Cup : Unit<Volume>(8, Ounce)
        object Pint : Unit<Volume>(2, Cup)
        object Quart : Unit<Volume>(2, Pint)
        object Gallon : Unit<Volume>(4, Quart)

        object Inch : Unit<Distance>(1)
        object Foot : Unit<Distance>(12, Inch)
        object Yard : Unit<Distance>(3, Foot)

        val Int.teaSpoon get() = quantity(Teaspoon)
        val Int.tableSpoon get() = quantity(Tablespoon)
        val Int.ounce get() = quantity(Ounce)
        val Int.cup get() = quantity(Cup)
        val Int.pint get() = quantity(Pint)
        val Int.quart get() = quantity(Quart)
        val Int.gallon get() = quantity(Gallon)

        val Int.inches get() = quantity(Inch)

        val Int.foot get() = quantity(Foot)

        private fun <D : Dimension> Int.quantity(unit: Unit<D>) = Quantity<D>(this, unit)

        operator fun <D : Dimension> Int.times(unit: Unit<D>) = unit.asBaseUnits(this)
    }

    private fun asBaseUnits(quantity: Int) = quantity * ratio

    override fun toString(): String = javaClass.simpleName

    internal fun baseAmount(amount: Int) = amount * this.ratio
}
