package no.scienta.workshop.oooct22.quantity

class CookingVolume(private val quantity: Int, private val unit: VolumeUnit) {

    override fun equals(other: Any?) = other is CookingVolume && equals(other)

    private fun equals(other: CookingVolume) = quantity == other.quantity && unit === other.unit

    override fun toString() = "$quantity $unit"
    override fun hashCode(): Int = (quantity to unit).hashCode()
}
