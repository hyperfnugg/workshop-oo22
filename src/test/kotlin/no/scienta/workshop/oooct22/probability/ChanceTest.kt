package no.scienta.workshop.oooct22.probability

import Chance.Companion.outOf
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ChanceTest {

    companion object {
        private val CERTAIN = 1 outOf 1
        private val IMPOSSIBLE = 0 outOf 1
        private val LIKELY = 3 outOf 4
        private val UNLIKELY = 1 outOf 4
        private val EQUALLY_LIKELY = 1 outOf 2
    }


    @Test
    fun `invalid fractions`() {
        assertThrows<IllegalArgumentException> { 12 outOf 10 }
        assertThrows<IllegalArgumentException> { 12 outOf 0 }
        assertThrows<IllegalArgumentException> { -2 outOf 10 }
    }

    @Test
    fun equality() {
        assertEquals(CERTAIN, CERTAIN)
        assertEquals(EQUALLY_LIKELY, 1 outOf 2)
        assertNotEquals(LIKELY, UNLIKELY)
        assertNotEquals(IMPOSSIBLE, null)
    }

    @Test
    fun hash() {
        assertEquals(CERTAIN.hashCode(), CERTAIN.hashCode())
        assertEquals(EQUALLY_LIKELY.hashCode(), (1 outOf 2).hashCode())
    }

    @Test
    fun not() {
        assertEquals(!CERTAIN, IMPOSSIBLE)
        assertEquals(CERTAIN.not(), IMPOSSIBLE)
        assertEquals(!!LIKELY, LIKELY)
    }

    @Test
    fun and() {
        assertEquals(CERTAIN and IMPOSSIBLE, IMPOSSIBLE)
        assertEquals(LIKELY and LIKELY, 9 outOf 16)
        assertEquals(LIKELY and UNLIKELY, UNLIKELY and LIKELY)
        assertEquals(CERTAIN and UNLIKELY, UNLIKELY)
    }

    @Test
    fun or() {
        assertEquals(LIKELY or IMPOSSIBLE, LIKELY)
        assertEquals(LIKELY or LIKELY, 15 outOf 16)
        assertEquals(LIKELY or UNLIKELY, UNLIKELY or LIKELY)
        assertEquals(LIKELY or CERTAIN, CERTAIN)
    }
}