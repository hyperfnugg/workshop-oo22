package no.scienta.workshop.oooct22.quantity

class CookingVolume internal constructor(private val amount: Int) {

    override fun equals(other: Any?) = other is CookingVolume && equals(other)

    private fun equals(other: CookingVolume) = amount == other.amount

    override fun toString() = "$amount teaspoons"

    override fun hashCode(): Int = amount.hashCode()
}
