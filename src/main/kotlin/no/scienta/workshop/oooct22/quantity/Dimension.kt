package no.scienta.workshop.oooct22.quantity

sealed class Dimension {

    object Distance : Dimension()

    object Volume : Dimension()

    override fun toString(): String = javaClass.simpleName
}
