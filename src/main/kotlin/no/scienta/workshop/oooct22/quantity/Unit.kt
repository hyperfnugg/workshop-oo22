@file:Suppress("unused")

package no.scienta.workshop.oooct22.quantity

import no.scienta.workshop.oooct22.quantity.Dimension.Distance
import no.scienta.workshop.oooct22.quantity.Dimension.Volume

val Int.teaSpoon get() = this.toQuantity(Teaspoon)

val Int.tableSpoon get() = this.toQuantity(Tablespoon)

val Int.ounce get() = this.toQuantity(Ounce)

val Int.cup get() = this.toQuantity(Cup)

val Int.pint get() = this.toQuantity(Pint)

val Int.quart get() = this.toQuantity(Quart)

val Int.gallon get() = this.toQuantity(Gallon)

val Int.inch get() = this.toQuantity(Inch)

val Int.foot get() = this.toQuantity(Foot)

private fun <D : Dimension> Int.toQuantity(unit: Unit<D>) = Quantity(this, unit)

object Teaspoon : Unit<Volume>(1, Teaspoon, Volume)
object Tablespoon : Unit<Volume>(3, Teaspoon)
object Ounce : Unit<Volume>(2, Tablespoon)
object Cup : Unit<Volume>(8, Ounce)
object Pint : Unit<Volume>(2, Cup)
object Quart : Unit<Volume>(2, Pint)
object Gallon : Unit<Volume>(4, Quart)

object Inch : Unit<Distance>(1, Inch, Distance)
object Foot : Unit<Distance>(12, Inch)
object Yard : Unit<Distance>(3, Foot)

sealed class Unit<D : Dimension>(private val ratio: Int, private val unit: Unit<D>? = null, val dimension: D = unit?.dimension!!) {

    override fun toString(): String = "${javaClass.simpleName}/${dimension}"

    internal fun comparesWith(unit: Unit<*>): Boolean = dimension === unit.dimension

    internal fun baseAmount(amount: Int) = amount * chainedRatio

    private val chainedRatio: Int get() = this.ratio * (unit?.chainedRatio ?: 1)
}


