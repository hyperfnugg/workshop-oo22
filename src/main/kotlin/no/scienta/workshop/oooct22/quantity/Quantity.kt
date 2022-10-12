package no.scienta.workshop.oooct22.quantity

class Quantity<D : Dimension> internal constructor(private val amount: Int, private val unit: Unit<D>) {

    override fun equals(other: Any?) = other is Quantity<*> && equals(other)

    private fun <D : Dimension> equals(other: Quantity<D>) = baseAmount() == other.baseAmount()

    private fun baseAmount() = unit.baseAmount(amount)

    override fun toString() = "$amount $unit"

    override fun hashCode(): Int = (amount to unit).hashCode()
}
