package no.scienta.workshop.oooct22.quantity

fun <D : Dimension> baseUnit(dimension: D): Unit<D> = Unit(dimension)

fun <D : Dimension> unit(ratio: Int, unit: Unit<D>) = Unit(ratio, unit)

class Unit<D : Dimension> private constructor(
    private val ratio: Int,
    private val unit: Unit<D>? = null,
    internal val dimension: D = unit?.dimension
        ?: throw IllegalStateException("The base unit needs an explicit dimension"),
) {

    constructor(dimension: D) : this(
        1,
        null,
        dimension
    )

    constructor(ratio: Int, unit: Unit<D>) : this(
        ratio.takeIf { it > 0 } ?: throw IllegalArgumentException("The unit must be positive: $ratio"),
        unit,
        unit.dimension
    )

    internal fun isComparableWith(unit: Unit<*>): Boolean = dimension === unit.dimension

    internal fun baseAmount(amount: Int) = amount * chainedRatio

    private val chainedRatio: Int get() = this.ratio * (unit?.chainedRatio ?: 1)

    override fun toString(): String = "${javaClass.simpleName}/${dimension}"
}
