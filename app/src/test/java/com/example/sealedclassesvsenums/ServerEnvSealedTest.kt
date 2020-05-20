package com.example.sealedclassesvsenums

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ServerEnvSealedTest {

    private lateinit var serverEnvSealedSUT: ServerEnvSealed

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `Environment is Development and name is Development and index is 0`() {
        serverEnvSealedSUT = Development()
        assertEquals("Development", serverEnvSealedSUT.name)
        assertEquals(0, serverEnvSealedSUT.index)
        assertEquals("https://api-dev.server.com/graphql", serverEnvSealedSUT.url)
    }

    @Test
    fun `Environment is QA and name is QA and index is 1`() {
        serverEnvSealedSUT = QA()
        assertEquals("QA", serverEnvSealedSUT.name)
        assertEquals(1, serverEnvSealedSUT.index)
        assertEquals("https://api-qa.server.com/graphql", serverEnvSealedSUT.url)
    }

    @Test
    fun `Environment is Acceptance and name is Acceptance and index is 2`() {
        serverEnvSealedSUT = Acceptance()
        assertEquals("Acceptance", serverEnvSealedSUT.name)
        assertEquals(2, serverEnvSealedSUT.index)
        assertEquals("https://api-acc.server.com/graphql", serverEnvSealedSUT.url)
    }

    @Test
    fun `Environment is Production and name is Production and index is 3`() {
        serverEnvSealedSUT = Production()
        assertEquals("Production", serverEnvSealedSUT.name)
        assertEquals(3, serverEnvSealedSUT.index)
        assertEquals("https://api.server.com/graphql", serverEnvSealedSUT.url)
    }

    @Test
    fun `servers array is not empty`() {
        val servers = ServerEnvSealed.servers()

        assertNotNull(servers)
        assertTrue(servers.count() == 4)
    }
}