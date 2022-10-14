package no.scienta.workshop.oooct22.quantity

class Quantity<D : Dimension> internal constructor(private val amount: Int, private val unit: Unit<D>) {

    private val baseAmount = unit.baseAmount(amount)

    infix fun convertedTo(unit: Unit<D>) =
        if (unit == this.unit) this else Quantity(this.unit.baseAmount(amount, unit), unit)

    operator fun plus(quantity: Quantity<D>) =
        commonUnit(quantity).let {
            val q1 = convertedTo(it)
            val q2 = quantity.convertedTo(it)
            Quantity(q1.amount + q2.amount, it)
        }

    private fun commonUnit(quantity: Quantity<D>) =
        unit.unitRange().reversed().zip(quantity.unit.unitRange().reversed())
            .map { (u1, _) -> u1 }
            .last()

    override fun equals(other: Any?) =
        other is Quantity<*> && unit.isComparableWith(other.unit) && baseAmount == other.baseAmount

    override fun hashCode(): Int = (baseAmount to unit.dimension).hashCode()

    override fun toString() = "$amount ${unit.print(amount)}"
}
