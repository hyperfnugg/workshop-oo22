package no.scienta.workshop.oooct22.quantity.test

import no.scienta.workshop.oooct22.quantity.Unit.Companion.pint
import no.scienta.workshop.oooct22.quantity.Unit.Companion.tableSpoon
import no.scienta.workshop.oooct22.quantity.Unit.Companion.teaSpoon
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class QuantityTest {

    @Test
    fun `should do equality`() {
        assertNotEquals(1.tableSpoon, 1.teaSpoon)
        assertEquals(1.tableSpoon, 1.tableSpoon)
        assertEquals(1.tableSpoon, 3.teaSpoon)
        assertEquals(1.tableSpoon, 3.teaSpoon)

        assertEquals(1.pint, 32.tableSpoon)

        assertEquals(hashSetOf(1.tableSpoon, 1.tableSpoon).size, 1)
        assertEquals(hashSetOf(1.teaSpoon, 1.teaSpoon, 1.teaSpoon).size, 1)
    }
}
