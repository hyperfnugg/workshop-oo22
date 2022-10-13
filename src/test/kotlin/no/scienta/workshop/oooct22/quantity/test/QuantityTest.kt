package no.scienta.workshop.oooct22.quantity.test

import no.scienta.workshop.oooct22.quantity.Unit.Companion.Pint
import no.scienta.workshop.oooct22.quantity.Unit.Companion.Tablespoon
import no.scienta.workshop.oooct22.quantity.Unit.Companion.Teaspoon
import no.scienta.workshop.oooct22.quantity.Unit.Companion.of
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class QuantityTest {

    @Test
    fun `should do equality`() {
        assertNotEquals(1 of Tablespoon, 1 of Teaspoon)
        assertEquals(1 of Tablespoon, 1 of Tablespoon)
        assertEquals(1 of Tablespoon, 3 of Teaspoon)
        assertEquals(1 of Tablespoon, 3 of Teaspoon)

        assertEquals(1 of Pint, 32 of Tablespoon)

        assertEquals(hashSetOf(1 of Tablespoon, 1 of Tablespoon).size, 1)
        assertEquals(hashSetOf(1 of Teaspoon, 1 of Teaspoon, 1 of Teaspoon).size, 1)
    }
}
