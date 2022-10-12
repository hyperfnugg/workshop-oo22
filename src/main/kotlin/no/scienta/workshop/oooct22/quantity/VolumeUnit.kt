package no.scienta.workshop.oooct22.quantity

sealed class VolumeUnit(internal val amount: Int) {

    companion object {

        object Teaspoon : VolumeUnit(1)
        object Tablespoon : VolumeUnit(3 * Teaspoon)
        object Ounce : VolumeUnit(2 * Tablespoon)
        object Cup : VolumeUnit(8 * Ounce)
        object Pint : VolumeUnit(2 * Cup)
        object Quart : VolumeUnit(2 * Pint)
        object Gallon : VolumeUnit(4 * Quart)

        val Int.teaSpoon get() = cookingVolume(Teaspoon)
        val Int.tableSpoon get() = cookingVolume(Tablespoon)
        val Int.ounce get() = cookingVolume(Ounce)
        val Int.cup get() = cookingVolume(Cup)
        val Int.pint get() = cookingVolume(Pint)
        val Int.quart get() = cookingVolume(Quart)
        val Int.gallon get() = cookingVolume(Gallon)

        private operator fun Int.times(unit: VolumeUnit) = this * unit.amount

        private fun Int.cookingVolume(unit: VolumeUnit) = CookingVolume(unit.asTeaspoons(this))
    }

    private fun asTeaspoons(quantity: Int) = quantity * amount
}
