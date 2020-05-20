package com.example.sealedclassesvsenums

/**
 * Declaring ServerEnvSealed class as sealed class means,
 * It is an Abstract class like in Java. We can have all the features
 * in Sealed class which Abstract class has.
 * In this example, added one property field to sealed class "url" and
 * This is overridden in the classes extended to this sealed class.
 * Sealed classes are used to have restricted hierarchy.
 */
sealed class ServerEnvSealed {

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

    companion object {
        fun servers() = arrayListOf(Development(), QA(), Acceptance(), Production())
    }
}

/**
 * Development server API.
 */
class Development: ServerEnvSealed() {
    override val url = "https://api-dev.server.com/graphql"
}

/**
 * Test server API.
 */
class QA: ServerEnvSealed() {
    override val url = "https://api-qa.server.com/graphql"
}

/**
 * Acceptance server API.
 */
class Acceptance: ServerEnvSealed() {
    override val url = "https://api-acc.server.com/graphql"
}

/**
 * Production server API.
 */
class Production: ServerEnvSealed() {
    override val url = "https://api.server.com/graphql"
}