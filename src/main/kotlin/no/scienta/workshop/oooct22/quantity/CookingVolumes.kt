package no.scienta.workshop.oooct22.quantity

val Int.tableSpoon get() = CookingVolume(this, VolumeUnit.tableSpoon)

val Int.teaSpoon get() = CookingVolume(this, VolumeUnit.teaSpoon)
