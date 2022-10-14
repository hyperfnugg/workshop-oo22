package no.scienta.workshop.oooct22.quantity.test

import no.scienta.workshop.oooct22.quantity.Units.cup
import no.scienta.workshop.oooct22.quantity.Units.foot
import no.scienta.workshop.oooct22.quantity.Units.inch
import no.scienta.workshop.oooct22.quantity.Units.ounce
import no.scienta.workshop.oooct22.quantity.Units.pint
import no.scienta.workshop.oooct22.quantity.Units.tablespoon
import no.scienta.workshop.oooct22.quantity.Units.teaspoon
import no.scienta.workshop.oooct22.quantity.Units.yard
import no.scienta.workshop.oooct22.quantity.unitOf
import no.scienta.workshop.oooct22.quantity.unitsOf
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CookingVolumesTest {

    @Test
    fun `should do equality`() {
        assertNotEquals(1 unitsOf tablespoon, 1 unitsOf teaspoon)
        assertEquals(1 unitsOf tablespoon, 1 unitsOf tablespoon)
        assertEquals(1 unitsOf tablespoon, 3 unitsOf teaspoon)

        assertEquals(1 unitOf pint, 32 unitsOf tablespoon)
        assertEquals(2 unitsOf cup, 16 unitsOf ounce)

        assertEquals(3 unitsOf foot, 36 unitsOf inch)
        assertEquals(3 unitsOf yard, 9 unitsOf foot)

        assertEquals("9 feet", (9 unitsOf foot).toString())

        val tablespoons = (2 unitsOf pint) convertedTo tablespoon

        assertEquals("64 tablespoons", tablespoons.toString())

        val tablespoonsAdded = (2 unitsOf pint) + (3 unitsOf tablespoon)
        assertEquals(tablespoonsAdded.toString(), "67 tablespoons")

        assertEquals("30 feet", ((5 unitsOf yard) + (15 unitsOf foot)).toString())

        assertEquals(setOf(1 unitOf tablespoon, 3 unitsOf teaspoon).size, 1)
        assertEquals(setOf(30 unitsOf teaspoon, 10 unitsOf tablespoon, 5 unitsOf ounce).size, 1)
        assertEquals(
            setOf(
                30 unitsOf teaspoon,
                10 unitsOf tablespoon,
                5 unitsOf ounce,
                1 unitOf teaspoon
            ).size, 2
        )

    }

    @Test
    fun `should not compare across dimensions`() {
        @Suppress("AssertBetweenInconvertibleTypes")
        assertNotEquals(1 unitOf inch, 1 unitOf teaspoon)

        val set = setOf(
            1 unitOf teaspoon,
            1 unitOf inch,
        )
        assertEquals(set.size, 2)

        val quantitySet = setOf(
            30 unitsOf teaspoon,
            1 unitOf inch,
            5 unitsOf ounce,
            10 unitsOf tablespoon,
        )
        assertEquals(quantitySet.size, 2)
    }
}
