package no.scienta.workshop.oooct22.quantity

sealed interface Dimension {

    object Distance : Dimension

    object Volume : Dimension
}
