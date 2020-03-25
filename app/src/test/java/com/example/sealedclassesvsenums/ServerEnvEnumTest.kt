package com.example.sealedclassesvsenums

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ServerEnvEnumTest {

    val TAG = ServerEnvEnumTest::class.java.simpleName

    lateinit var serverEnvEnumSUT: ServerEnvEnum

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `server is Development and title is Development and ordinal is 0`() {
        serverEnvEnumSUT = ServerEnvEnum.Development
        assertEquals(0, serverEnvEnumSUT.ordinal)
        assertEquals("https://api-dev.server.com/graphql", serverEnvEnumSUT.url)
    }

    @Test
    fun `server is Test and title is Test and ordinal is 1`() {
        serverEnvEnumSUT = ServerEnvEnum.QA
        assertEquals(1, serverEnvEnumSUT.ordinal)
        assertEquals("https://api-qa.server.com/graphql", serverEnvEnumSUT.url)
    }

    @Test
    fun `server is Acceptance and title is Acceptance and ordinal is 2`() {
        serverEnvEnumSUT = ServerEnvEnum.Acceptance
        assertEquals(2, serverEnvEnumSUT.ordinal)
        assertEquals("https://api-acc.server.com/graphql", serverEnvEnumSUT.url)
    }

    @Test
    fun `server is Production and title is Production and ordinal is 3`() {
        serverEnvEnumSUT = ServerEnvEnum.Production
        assertEquals(3, serverEnvEnumSUT.ordinal)
        assertEquals("https://api.server.com/graphql", serverEnvEnumSUT.url)
    }
}