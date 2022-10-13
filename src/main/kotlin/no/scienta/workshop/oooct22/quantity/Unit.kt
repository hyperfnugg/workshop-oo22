@file:Suppress("unused")

package no.scienta.workshop.oooct22.quantity

sealed class Unit<D : Dimension>(private val ratio: Int, private val unit: Unit<D>? = null, val dimension: D = unit?.dimension!!) {

    override fun toString(): String = "${javaClass.simpleName}/${dimension}"

    internal fun comparesWith(unit: Unit<*>): Boolean = dimension === unit.dimension

    internal fun baseAmount(amount: Int) = amount * chainedRatio

    private val chainedRatio: Int get() = this.ratio * (unit?.chainedRatio ?: 1)
}


