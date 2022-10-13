package no.scienta.workshop.oooct22.quantity

open class Dimension {
    override fun toString(): String = javaClass.simpleName
}

object Distance : Dimension()

object Volume : Dimension()
