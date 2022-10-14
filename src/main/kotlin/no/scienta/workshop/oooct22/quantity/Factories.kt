@file:Suppress("unused")

package no.scienta.workshop.oooct22.quantity

infix fun <D: Dimension> Int.unitOf(unit: Unit<D>) = this unitsOf unit

infix fun <D: Dimension> Int.unitsOf(unit: Unit<D>) = Quantity(this, unit)
