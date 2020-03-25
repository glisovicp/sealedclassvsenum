package com.example.sealedclassesvsenums.activity

/**
 * Declaring ServerEnv class as sealed class means,
 * It is an Abstract class like in Java. We can have all the features
 * in Sealed class which Abstract class has.
 * In this example, added one property field to sealed class "url" and
 * This is overridden in the classes extended to this sealed class.
 * Sealed classes are used to have restricted hierarchy.
 */
sealed class ServerEnv {

    abstract val url: String

    val name: String
        get() = when (this) {
            is Development -> "Development"
            is QA -> "QA"
            is Acceptance -> "Acceptance"
            is Production -> "Production"
        }

    val index: Int
        get() = when (this) {
            is Development -> 0
            is QA -> 1
            is Acceptance -> 2
            is Production -> 3
        }
}

/**
 * Development server API.
 */
class Development: ServerEnv() {
    override val url = "https://api-dev.server.com/graphql"
}

/**
 * Test server API.
 */
class QA: ServerEnv() {
    override val url = "https://api-test.server.com/graphql"
}

/**
 * Acceptance server API.
 */
class Acceptance: ServerEnv() {
    override val url = "https://api-acc.server.com/graphql"
}

/**
 * Production server API.
 */
class Production: ServerEnv() {
    override val url = "https://api.server.com/graphql"
}