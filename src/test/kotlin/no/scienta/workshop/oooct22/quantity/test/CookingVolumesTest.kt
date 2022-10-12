package no.scienta.workshop.oooct22.quantity.test

import no.scienta.workshop.oooct22.quantity.tableSpoon
import no.scienta.workshop.oooct22.quantity.teaSpoon
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class CookingVolumesTest {

    @Test
    fun `should do equality`() {
        assertNotEquals(1.tableSpoon, 1.teaSpoon)
        assertEquals(1.tableSpoon, 1.tableSpoon)

        assertEquals(hashSetOf(1.tableSpoon, 1.tableSpoon).size, 1)
        assertEquals(hashSetOf(1.teaSpoon, 1.teaSpoon, 1.teaSpoon).size, 1)
    }
}
