package no.scienta.workshop.oooct22.quantity

class Quantity<D : Dimension> internal constructor(private val amount: Int, private val unit: Unit<D>) {

    private fun baseAmount() = unit.baseAmount(amount)

    override fun equals(other: Any?) =
        other is Quantity<*> && unit.comparesWith(other.unit) && baseAmount() == other.baseAmount()

    override fun hashCode(): Int = (amount to unit).hashCode()

    override fun toString() = "$amount $unit"
}
