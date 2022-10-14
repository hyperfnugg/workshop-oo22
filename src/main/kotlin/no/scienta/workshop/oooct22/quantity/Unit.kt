package no.scienta.workshop.oooct22.quantity

fun <D : Dimension> base(name: String, dimension: D, plural: String? = null): Unit<D> =
    Unit(dimension, name, plural ?: "${name}s")

fun <D : Dimension> unit(name: String, ratio: Int, unit: Unit<D>, plural: String? = null) =
    Unit(ratio, unit, name, plural ?: "${name}s")

class Unit<D : Dimension> private constructor(
    private val ratio: Int,
    private val unit: Unit<D>? = null,
    private val name: String,
    private val pluralName: String = "${name}s",
    internal val dimension: D = unit?.dimension
        ?: throw IllegalStateException("The base unit needs an explicit dimension"),
) {

    constructor(dimension: D, name: String, pluralName: String)
            : this(1, null, name, pluralName, dimension)

    constructor(ratio: Int, unit: Unit<D>, name: String, pluralName: String)
            : this(positive(ratio), unit, name, pluralName, unit.dimension)

    internal fun isComparableWith(unit: Unit<*>): Boolean = dimension === unit.dimension

    internal fun baseAmount(amount: Int, terminator: Unit<D>? = null) =
        amount * baseRatio(terminator)

    internal fun unitRange(): List<Unit<D>> = listOf(this) + (unit?.unitRange() ?: emptyList())

    companion object {
        private fun positive(ratio: Int) = (ratio.takeIf { it > 0 }
            ?: throw IllegalArgumentException("The unit must be positive: $ratio"))
    }

    private fun baseRatio(terminator: Unit<D>? = null): Int =
        this.ratio * (unit?.takeIf { it != terminator }?.baseRatio(terminator) ?: 1)

    override fun toString(): String = "$name/${dimension}"
    internal fun print(amount: Int): String = if (amount > 1) pluralName else name
}
