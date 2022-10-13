@file:Suppress("unused")

package no.scienta.workshop.oooct22.quantity

import java.lang.IllegalStateException

sealed class Unit<D : Dimension>(
    private val ratio: Int,
    private val unit: Unit<D>? = null,
    private val dimension: D = unit?.dimension ?: throw IllegalStateException("The base unit needs an explicit dimension"),
) {
    init {
        require(unit != null || ratio == 1) { "Base unit must be arity 1: $this = $ratio" }
    }

    internal fun comparesWith(unit: Unit<*>): Boolean = dimension === unit.dimension

    internal fun baseAmount(amount: Int) = amount * chainedRatio

    private val chainedRatio: Int get() = this.ratio * (unit?.chainedRatio ?: 1)

    override fun toString(): String = "${javaClass.simpleName}/${dimension}"
}


