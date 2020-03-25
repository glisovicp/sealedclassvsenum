package com.example.sealedclassesvsenums

enum class ServerEnvEnum {

    /**
     * Development server API.
     */
    Development,

    /**
     * Test server API.
     */
    QA,

    /**
     * Acceptance server API.
     */
    Acceptance,

    /**
     * Production server API.
     */
    Production;

    val url: String
        get() = when(this) {
            Development -> "https://api-dev.server.com/graphql"
            QA -> "https://api-qa.server.com/graphql"
            Acceptance -> "https://api-acc.server.com/graphql"
            Production -> "https://api.server.com/graphql"
        }
}