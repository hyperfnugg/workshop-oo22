package no.scienta.workshop.oooct22.quantity

class Quantity<D : Dimension> internal constructor(private val amount: Int, private val unit: Unit<D>) {

    private val baseAmount = unit.baseAmount(amount)

    infix fun convertedTo(unit: Unit<D>) =
        if (unit == this.unit) this else Quantity(this.unit.baseAmount(amount, unit), unit)

    operator fun plus(quantity: Quantity<D>) =
        commonUnit(quantity).let { commonUnit ->
            Quantity(amountIn(commonUnit, quantity), commonUnit)
        }

    private fun commonUnit(quantity: Quantity<D>) =
        unit.unitRange().reversed().zip(quantity.unit.unitRange().reversed())
            .map { (u1, _) -> u1 }
            .last()

    private fun amountIn(common: Unit<D>, quantity: Quantity<D>) =
        listOf(this.convertedTo(common), quantity.convertedTo(common))
            .sumOf { it.amount }

    override fun equals(other: Any?) =
        other is Quantity<*> && unit.isComparableWith(other.unit) && baseAmount == other.baseAmount

    override fun hashCode(): Int = (baseAmount to unit.dimension).hashCode()

    override fun toString() = "$amount ${unit.print(amount)}"
}
