package com.example.sealedclassesvsenums

import com.example.sealedclassesvsenums.activity.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ServerEnvTest {

    val TAG = ServerEnvTest::class.java.simpleName

    lateinit var environmentSUT: ServerEnv

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `Environment is Development and name is Development and index is 0`() {
        environmentSUT = Development()
        assertEquals("Development", environmentSUT.name)
        assertEquals(0, environmentSUT.index)
    }

    @Test
    fun `Environment is QA and name is QA and index is 1`() {
        environmentSUT = QA()
        assertEquals("QA", environmentSUT.name)
        assertEquals(1, environmentSUT.index)
    }

    @Test
    fun `Environment is Acceptance and name is Acceptance and index is 2`() {
        environmentSUT = Acceptance()
        assertEquals("Acceptance", environmentSUT.name)
        assertEquals(2, environmentSUT.index)
    }

    @Test
    fun `Environment is Production and name is Production and index is 3`() {
        environmentSUT = Production()
        assertEquals("Production", environmentSUT.name)
        assertEquals(3, environmentSUT.index)
    }
}