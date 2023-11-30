package org.wireforce.virbet.classes

/**
 * Enum `ContentLanguage` представляет собой перечисление поддерживаемых языков для контента.
 * Каждый элемент enum представляет язык с использованием кодов:
 * - `RU` - русский,
 * - `EN` - английский.
 */
enum class ContentLanguage(val code: String) {
    /**
     * Русский - язык с кодом `RU`.
     */
    RU("ru"),

    /**
     * Английский - язык с кодом `EN`.
     */
    EN("en")
}