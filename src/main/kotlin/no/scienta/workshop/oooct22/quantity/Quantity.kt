package no.scienta.workshop.oooct22.quantity

import java.math.BigDecimal
import java.math.RoundingMode

private const val SCALE = 5

class Quantity private constructor(private val amount: BigDecimal, private val unit: Unit) {

    private val presentationValue get() : BigDecimal = amount.setScale(2, RoundingMode.HALF_UP)

    constructor(amount: Int, unit: Unit) : this(amount.toBigDecimal().setScale(SCALE), unit)

    init {
        require(amount.scale() == SCALE)
    }

    override fun equals(other: Any?) = other is Quantity && equals(other)

    private fun equals(other: Quantity) = unit.compatibleWith(other.unit)
            && other.convertTo(unit).presentationValue == presentationValue

    private fun convertTo(toUnit: Unit) =
        Quantity(toUnit.convert(amount, unit).setScale(SCALE, RoundingMode.HALF_UP), toUnit)

    override fun toString() = "$presentationValue ${unit::class.java.simpleName}"

    override fun hashCode(): Int = unit.hashCode(presentationValue)

    operator fun plus(other: Quantity) = Quantity(amount + other.convertTo(unit).amount, unit)

    operator fun minus(other: Quantity) = this + (-other)

    operator fun unaryMinus() = Quantity(-amount, unit)
}
