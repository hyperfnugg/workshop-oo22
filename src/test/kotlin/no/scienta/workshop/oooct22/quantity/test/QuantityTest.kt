package no.scienta.workshop.oooct22.quantity.test

import no.scienta.workshop.oooct22.quantity.Unit.Companion.Celsius
import no.scienta.workshop.oooct22.quantity.Unit.Companion.Fahrenheit
import no.scienta.workshop.oooct22.quantity.Unit.Companion.Foot
import no.scienta.workshop.oooct22.quantity.Unit.Companion.Gallon
import no.scienta.workshop.oooct22.quantity.Unit.Companion.Inches
import no.scienta.workshop.oooct22.quantity.Unit.Companion.Pint
import no.scienta.workshop.oooct22.quantity.Unit.Companion.Quart
import no.scienta.workshop.oooct22.quantity.Unit.Companion.Tablespoon
import no.scienta.workshop.oooct22.quantity.Unit.Companion.Teaspoon
import no.scienta.workshop.oooct22.quantity.Unit.Companion.Yard
import no.scienta.workshop.oooct22.quantity.Unit.Companion.of
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class QuantityTest {

    @Test
    fun `should do equality`() {
//        assertNotEquals(1 of Tablespoon, 1 of Teaspoon)
//        assertEquals(1 of Tablespoon, 1 of Tablespoon)
//        assertEquals(1 of Tablespoon, 3 of Teaspoon)
//        assertEquals(1 of Tablespoon, 3 of Teaspoon)
//        assertEquals(0 of Celsius, 32 of Fahrenheit)
        assertEquals(10 of Celsius, 50 of Fahrenheit)
        assertEquals(-25 of Celsius, -13 of Fahrenheit)

        assertNotEquals(1 of Inches, 1 of Teaspoon)

        assertEquals(1 of Yard, 3 of Foot)
        assertNotEquals(1 of Yard, 6 of Foot)

        assertEquals(1 of Pint, 32 of Tablespoon)

        assertEquals(hashSetOf(1 of Tablespoon, 3 of Teaspoon).size, 1)
        assertEquals(hashSetOf(1 of Tablespoon, 1 of Tablespoon).size, 1)
        assertEquals(hashSetOf(1 of Yard, 3 of Foot).size, 1)
        assertEquals(hashSetOf(1 of Teaspoon, 1 of Teaspoon, 1 of Teaspoon).size, 1)
    }

    @Test
    fun addition() {
        assertEquals((6 of Quart) + (2 of Quart), 2 of Gallon)
        assertEquals((3 of Foot) + (2 of Yard), 3 of Yard)
        assertThrows<IllegalArgumentException> { (3 of Foot) + (2 of Gallon) }
    }

    @Test
    fun subtraction() {
        assertEquals((6 of Quart) - (2 of Quart), 4 of Quart)
        assertEquals((9 of Foot) - (2 of Yard), 3 of Foot)
        assertThrows<IllegalArgumentException> { (3 of Foot) - (2 of Gallon) }
    }

    @Test
    fun negation() {
        assertEquals(-(6 of Quart), (-6) of Quart)
        assertEquals(- -(6 of Quart), 6 of Quart)
    }
}
