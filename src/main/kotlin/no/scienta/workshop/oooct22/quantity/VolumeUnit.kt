package no.scienta.workshop.oooct22.quantity

enum class VolumeUnit(private val amount: Int) {

    TeaSpoon(1),

    TableSpoon(3 * TeaSpoon.amount),

    Ounce(2 * TableSpoon.amount),

    Cup(8 * Ounce.amount),

    Pint(2 * Cup.amount),

    Quart(2 * Pint.amount),

    Gallon(4 * Quart.amount);

    companion object {

        val Int.tableSpoon get() = cookingVolume(TableSpoon)
        val Int.teaSpoon get() = cookingVolume(TeaSpoon)
        val Int.ounce get() = cookingVolume(Ounce)
        val Int.cup get() = cookingVolume(Cup)
        val Int.pint get() = cookingVolume(Pint)
        val Int.quart get() = cookingVolume(Quart)
        val Int.gallon get() = cookingVolume(Gallon)

        operator fun Int.times(unit: VolumeUnit) = this * unit.amount

        private fun Int.cookingVolume(unit: VolumeUnit) = CookingVolume(unit.asTeaspoons(this))
    }

    private fun asTeaspoons(quantity: Int) = quantity * amount;
}
