import java.math.BigDecimal
import java.math.RoundingMode

//Understands the likelihood of something occuring
class Chance private constructor(private val fraction: BigDecimal) {
    init {
        require(fraction.scale() == SCALE)
        require(fraction >= BigDecimal.ZERO)
        require(fraction <= BigDecimal.ONE)
    }

    override fun equals(other: Any?) =
        this === other || other is Chance && this.equals(other)

    private fun equals(other: Chance) =
        this.fraction == other.fraction

    override fun hashCode() =
        fraction.hashCode()


    companion object {
        private const val SCALE = 5
        infix fun Number.outOf(total: Number) =
            (this.toDouble() / total.toDouble())
                .let(Double::toBigDecimal)
                .setScale(SCALE, RoundingMode.HALF_UP)
                .let(::Chance)
    }
}