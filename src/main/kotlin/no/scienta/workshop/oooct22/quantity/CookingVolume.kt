package no.scienta.workshop.oooct22.quantity

import java.math.BigDecimal

private const val SCALE = 5

class CookingVolume private constructor(private val amount: BigDecimal) {

    constructor(amount: Int) : this(amount.toBigDecimal().setScale(SCALE))
    init {
        require(amount.scale() == SCALE)
    }

    override fun equals(other: Any?) = other is CookingVolume && equals(other)

    private fun equals(other: CookingVolume) = amount == other.amount

    override fun toString() = "$amount teaspoons"

    override fun hashCode(): Int = amount.hashCode()
}
