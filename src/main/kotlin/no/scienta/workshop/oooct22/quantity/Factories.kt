package no.scienta.workshop.oooct22.quantity

val Int.teaSpoon get() = this.toQuantity(Teaspoon)

val Int.tableSpoon get() = this.toQuantity(Tablespoon)

val Int.ounce get() = this.toQuantity(Ounce)

val Int.cup get() = this.toQuantity(Cup)

val Int.pint get() = this.toQuantity(Pint)

val Int.quart get() = this.toQuantity(Quart)

val Int.gallon get() = this.toQuantity(Gallon)

val Int.inch get() = this.toQuantity(Inch)

val Int.foot get() = this.toQuantity(Foot)

private fun <D : Dimension> Int.toQuantity(unit: Unit<D>) = Quantity(this, unit)
