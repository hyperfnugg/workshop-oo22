import java.math.BigDecimal
import java.math.RoundingMode

//Understands the likelihood of something occuring
class Chance private constructor(private val fraction: BigDecimal) {
    init {
        require(fraction.scale() == SCALE)
        require(fraction in IMPOSSIBLE_FRACTION..CERTAIN_FRACTION)
    }

    override fun equals(other: Any?): Boolean {
        return this === other || equals(other as? Chance)
    }

    private fun equals(chance: Chance?) = chance?.fraction == fraction

    override fun hashCode() =
        fraction.hashCode()

    operator fun not() =
        Chance(CERTAIN_FRACTION - fraction)

    infix fun and(other: Chance) =
        Chance((this.fraction * other.fraction).setScale(5))

    infix fun or(other: Chance) =
        !(!this and !other)


    companion object {
        private const val SCALE = 5
        private val IMPOSSIBLE_FRACTION = BigDecimal.ZERO
        private val CERTAIN_FRACTION = BigDecimal.ONE
        infix fun Number.outOf(total: Number) =
            (this.toDouble() / total.toDouble())
                .let(Double::toBigDecimal)
                .setScale(SCALE, RoundingMode.HALF_UP)
                .let(::Chance)
    }
}
