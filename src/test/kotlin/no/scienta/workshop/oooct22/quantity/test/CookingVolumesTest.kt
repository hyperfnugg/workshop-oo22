package no.scienta.workshop.oooct22.quantity.test

import no.scienta.workshop.oooct22.quantity.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CookingVolumesTest {

    @Test
    fun `should do equality`() {
        assertNotEquals(1.tableSpoon, 1.teaSpoons)
        assertEquals(1.tableSpoon, 1.tableSpoons)
        assertEquals(1.tableSpoon, 3.teaSpoons)

        assertEquals(1.pint, 32.tableSpoons)
        assertEquals(2.cups, 16.ounces)

        assertEquals(3.feet, 36.inches)
        assertEquals(3.yards, 9.feet)

        assertEquals(hashSetOf(1.tableSpoon, 3.teaSpoons).size, 1)
        assertEquals(hashSetOf(30.teaSpoons, 10.tableSpoons, 5.ounces).size, 1)

        assertEquals(hashSetOf(30.teaSpoons, 1.inch, 5.ounces).size, 2)
        assertEquals(hashSetOf(1.teaSpoon, 1.inch).size, 2)
    }

    @Test
    fun `should not compare across dimensions`() {
        assertNotEquals(1.inch, 1.teaSpoon)
    }
}
