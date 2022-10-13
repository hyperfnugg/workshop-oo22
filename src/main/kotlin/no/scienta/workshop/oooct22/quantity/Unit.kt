package no.scienta.workshop.oooct22.quantity

import kotlin.IllegalStateException

sealed class Unit<D : Dimension>(
    private val ratio: Int,
    private val unit: Unit<D>?,
    internal val dimension: D = unit?.dimension ?: throw IllegalStateException("The base unit needs an explicit dimension"),
) {
    init {
        require(ratio >= 1) { "The unit must be positive: $this != $ratio" }
        require(unit != null || ratio == 1) { "The base unit must be unary: $this != $ratio" }
    }

    internal fun isComparableWith(unit: Unit<*>): Boolean = dimension === unit.dimension

    internal fun baseAmount(amount: Int) = amount * chainedRatio

    private val chainedRatio: Int get() = this.ratio * (unit?.chainedRatio ?: 1)

    override fun toString(): String = "${javaClass.simpleName}/${dimension}"
}


